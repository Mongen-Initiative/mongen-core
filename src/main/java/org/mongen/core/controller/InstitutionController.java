package org.mongen.core.controller;

import java.util.List;

import org.mongen.core.models.Institution;
import org.mongen.core.models.InstitutionType;
import org.mongen.core.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1")
public class InstitutionController {
	
	@Autowired
	InstitutionService institutionServ;
	
	@ApiOperation(value = "Get All the Institutions")
	@GetMapping("/institutions")
	public ResponseEntity<List<Institution>> getInstitutions(){
		List<Institution> ins = institutionServ.getInstitutions();
		return ResponseEntity.status(HttpStatus.OK).body(ins);
	}
	
	@ApiOperation(value = "Get All the Institution Type")
	@GetMapping("/institutions/type")
	public ResponseEntity<List<InstitutionType>> getInstitutionTypes(){
		List<InstitutionType> ins = institutionServ.getInstitutionTypes();
		return ResponseEntity.status(HttpStatus.OK).body(ins);
	}
	
	@ApiOperation(value = "Get one Institution")
	@GetMapping("/institutions/{id}")
	public ResponseEntity<Institution> getInstitutionId(@PathVariable("id") Long id){
		Institution ins = institutionServ.findInstitutionById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ins);
	}
	
	@ApiOperation(value = "Get one Institution Type")
	@GetMapping("/institutions/type/{id}")
	public ResponseEntity<InstitutionType> getInstitutionTypeId(@PathVariable("id") Long id){
		InstitutionType ins = institutionServ.findInstitutionTypeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ins);
	}
	
	@ApiOperation(value = "Create a Disability")
	@PostMapping("/institutions")
	public ResponseEntity<Institution> createInstitution(@RequestBody Institution institution,@RequestBody InstitutionType type){
		Institution ins = institutionServ.createInstitution(institution,type);
		return ResponseEntity.status(HttpStatus.CREATED).body(ins);
	}
	
	@ApiOperation(value = "Update a Institution")
	@PatchMapping("/institutions/{id}")
	public ResponseEntity<Institution> updateInstitution(@PathVariable("id") Long id, @RequestBody Institution institution){
		Institution ins = institutionServ.updateInstitution(institution, id);
		return ResponseEntity.status(HttpStatus.OK).body(ins);
	}
	
	@ApiOperation(value = "Delete a Institution")
	@DeleteMapping("/institutions/{id}")
	public ResponseEntity<?> deleteInstitution(@PathVariable("id") Long id){
		institutionServ.deleteInstitution(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Institution with ID: " + id);
	}
	
	@ApiOperation(value = "Delete a Institution Type")
	@DeleteMapping("/institutions/type/{id}")
	public ResponseEntity<?> deleteInstitutionType(@PathVariable("id") Long id){
		institutionServ.deleteInstitutionType(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Institution Type with ID: " + id);
	}
}
