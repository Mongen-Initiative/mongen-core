package org.mongen.core.controller;

import io.swagger.annotations.ApiOperation;
import org.mongen.core.models.Organization;
import org.mongen.core.models.payloads.OrganizationPayload;
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
		List<Organization> bene = organizationServ.getOrganizations();
		return ResponseEntity.status(HttpStatus.OK).body(bene);
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
		Organization bene = organizationServ.createOrganization(org);
		return ResponseEntity.status(HttpStatus.CREATED).body(bene);
	}
	
	@ApiOperation(value = "Update a Organization")
	@PatchMapping("/organization/{id}")
	public ResponseEntity<Organization> updateOrganization(@PathVariable("id") Long id, @RequestBody Organization org){
		Organization bene = organizationServ.updateOrganization(org, id);
		return ResponseEntity.status(HttpStatus.OK).body(bene);
	}
	
	@ApiOperation(value = "Delete a Organization")
	@DeleteMapping("/organization/{id}")
	public ResponseEntity<?> deleteOrganization(@PathVariable("id") Long id){
		organizationServ.deleteOrganization(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Organization with ID: " + id);
	}
}
