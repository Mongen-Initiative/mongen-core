package org.mongen.core.controller;

import io.swagger.annotations.ApiOperation;
import org.mongen.core.models.Organization;
import org.mongen.core.models.payloads.OrganizationPayload;
import org.mongen.core.models.payloads.OrganizationVerifiedStatusPayload;
import org.mongen.core.models.responses.OrganizationResponse;
import org.mongen.core.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrganizationController {
	@Autowired
	OrganizationService organizationServ;
	
	@ApiOperation(value = "Get All the Organizations")
	@GetMapping("/organizations")
	public ResponseEntity<List<Organization>> getOrganizations(){
		List<Organization> orgs = organizationServ.getOrganizations();
		return ResponseEntity.status(HttpStatus.OK).body(orgs);
	}

	@ApiOperation(value = "Get Organizations by verified state")
	@GetMapping("/organizations/verified/{state}")
	public ResponseEntity<List<Organization>> getOrganizationsByVerifiedState(@PathVariable("state") Boolean state){
		List<Organization> orgs = organizationServ.findOrganizationByVerified(state);
//		Attempt to apply a better response for the list of organizations
//		List<OrganizationResponse> response = organizationServ.generateListOrganizationResponse(orgs);
		return ResponseEntity.status(HttpStatus.OK).body(orgs);
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
	public ResponseEntity<Organization> createOrganization(@RequestBody OrganizationPayload org){
		Organization new_org = organizationServ.createOrganization(org);
		return ResponseEntity.status(HttpStatus.CREATED).body(new_org);
	}
	
	@ApiOperation(value = "Update a Organization")
	@PatchMapping("/organization/{id}")
	public ResponseEntity<Organization> updateOrganization(@PathVariable("id") Long id, @RequestBody Organization org){
		Organization bene = organizationServ.updateOrganization(org, id);
		return ResponseEntity.status(HttpStatus.OK).body(bene);
	}

	@ApiOperation(value = "Update verified status of an Organization")
	@PatchMapping("/set_organization_verified/{id}")
	public ResponseEntity<Organization> updateVerifiedStatusOrganization(@PathVariable("id") Long id, @RequestBody OrganizationVerifiedStatusPayload payload){
		Organization bene = organizationServ.updateVerifiedStatus(payload, id);
		return ResponseEntity.status(HttpStatus.OK).body(bene);
	}
	
	@ApiOperation(value = "Delete a Organization")
	@DeleteMapping("/organization/{id}")
	public ResponseEntity<?> deleteOrganization(@PathVariable("id") Long id){
		organizationServ.deleteOrganization(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Organization with ID: " + id);
	}
}
