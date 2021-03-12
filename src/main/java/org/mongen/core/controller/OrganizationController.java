package org.mongen.core.controller;

import io.swagger.annotations.ApiOperation;
import org.mongen.core.models.Organization;
import org.mongen.core.models.OrganizationStatus;
import org.mongen.core.models.payloads.OrganizationPayload;
import org.mongen.core.models.payloads.OrganizationStatusPayload;
import org.mongen.core.models.responses.OrganizationResponse;
import org.mongen.core.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class OrganizationController {
	@Autowired
	OrganizationService organizationServ;
	
	@ApiOperation(value = "Get All the Organizations")
	@GetMapping("/organizations")
	public ResponseEntity<List<OrganizationResponse>> getOrganizations(){
		List<Organization> orgs = organizationServ.getOrganizations();
		List<OrganizationResponse> response = organizationServ.generateListOrganizationResponse(orgs);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@ApiOperation(value = "Get All the Organizations statuses")
	@GetMapping("/organizations/status")
	public ResponseEntity<List<OrganizationStatus>> getOrganizationsStatuses(){
		List<OrganizationStatus> org_statuses = organizationServ.getOrganizationStatuses();
		return ResponseEntity.status(HttpStatus.OK).body(org_statuses);
	}

	@ApiOperation(value = "Get Organizations by status")
	@GetMapping("/organizations/status/{status}")
	public ResponseEntity<List<OrganizationResponse>> getOrganizationsByVerifiedState(@PathVariable("status") String status){
		List<Organization> orgs = organizationServ.findOrganizationsByStatus(status);
		List<OrganizationResponse> response = organizationServ.generateListOrganizationResponse(orgs);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@ApiOperation(value = "Get one Organization")
	@GetMapping("/organization/{id}")
	public ResponseEntity<OrganizationResponse> getOrganizationId(@PathVariable("id") Long id){
		Organization org = organizationServ.findOrganizationById(id);
		OrganizationResponse org_resp = organizationServ.generateOrganizationResponse(org);
		return ResponseEntity.status(HttpStatus.OK).body(org_resp);
	}

	@ApiOperation(value = "Get one Organization by SEO name")
	@GetMapping("/organization/seo_name/{seo_name}")
	public ResponseEntity<OrganizationResponse> getOrganizationSeoName(@PathVariable("seo_name") String seo_name){
		Organization org = organizationServ.findOrganizationBySeoName(seo_name);
		OrganizationResponse org_resp = organizationServ.generateOrganizationResponse(org);
		return ResponseEntity.status(HttpStatus.OK).body(org_resp);
	}
	
	@ApiOperation(value = "Create a Organization")
	@PostMapping("/organization")
	public ResponseEntity<Organization> createOrganization(@Valid @RequestBody OrganizationPayload org){
		Organization new_org = organizationServ.createOrganization(org);
		return ResponseEntity.status(HttpStatus.CREATED).body(new_org);
	}
	
	@ApiOperation(value = "Update a Organization")
	@PatchMapping("/organization/{id}")
	public ResponseEntity<Organization> updateOrganization(@PathVariable("id") Long id, @RequestBody Organization org){
		Organization bene = organizationServ.updateOrganization(org, id);
		return ResponseEntity.status(HttpStatus.OK).body(bene);
	}

	@ApiOperation(value = "Update status of an Organization")
	@PatchMapping("/set_organization_status/{id}")
	public ResponseEntity<Organization> updateOrganizationStatus(@PathVariable("id") Long id, @RequestBody OrganizationStatusPayload payload){
		Organization bene = organizationServ.updateStatus(payload, id);
		return ResponseEntity.status(HttpStatus.OK).body(bene);
	}
	
	@ApiOperation(value = "Delete a Organization")
	@DeleteMapping("/organization/{id}")
	public ResponseEntity<?> deleteOrganization(@PathVariable("id") Long id){
		organizationServ.deleteOrganization(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Organization with ID: " + id);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
