package org.mongen.core.controller;

import java.util.List;

import org.mongen.core.models.Disability;
import org.mongen.core.models.DisabilityType;
import org.mongen.core.service.DisabilityService;
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
public class DisabilityController {
	
	@Autowired
	DisabilityService disabilityServ;
	
	@ApiOperation(value = "Get All the Collaborators")
	@GetMapping("/disabilities")
	public ResponseEntity<List<Disability>> getDisabilities(){
		List<Disability> disa = disabilityServ.getDisabilities();
		return ResponseEntity.status(HttpStatus.OK).body(disa);
	}
	
	@ApiOperation(value = "Get All the Disability Type")
	@GetMapping("/disabilities/type")
	public ResponseEntity<List<DisabilityType>> getDisabilityTypes(){
		List<DisabilityType> disa = disabilityServ.getDisabilityTypes();
		return ResponseEntity.status(HttpStatus.OK).body(disa);
	}
	
	@ApiOperation(value = "Get one Disability")
	@GetMapping("/disabilities/{id}")
	public ResponseEntity<Disability> getDisabilityId(@PathVariable("id") Long id){
		Disability disa = disabilityServ.findDisabilityById(id);
		return ResponseEntity.status(HttpStatus.OK).body(disa);
	}
	
	@ApiOperation(value = "Get one Disability Type")
	@GetMapping("/disabilities/type/{id}")
	public ResponseEntity<DisabilityType> getDisabilityTypeId(@PathVariable("id") Long id){
		DisabilityType disa = disabilityServ.findDisabilityTypeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(disa);
	}
	
	@ApiOperation(value = "Create a Disability")
	@PostMapping("/disabilities")
	public ResponseEntity<Disability> createDisability(@RequestBody Disability collaborator,@RequestBody DisabilityType type){
		Disability disa = disabilityServ.createDisability(collaborator,type);
		return ResponseEntity.status(HttpStatus.CREATED).body(disa);
	}
	
	@ApiOperation(value = "Update a Disability")
	@PatchMapping("/disabilities/{id}")
	public ResponseEntity<Disability> updateDisability(@PathVariable("id") Long id, @RequestBody Disability collaborator){
		Disability disa = disabilityServ.updateDisability(collaborator, id);
		return ResponseEntity.status(HttpStatus.OK).body(disa);
	}
	
	@ApiOperation(value = "Delete a Disability")
	@DeleteMapping("/disabilities/{id}")
	public ResponseEntity<?> deleteDisability(@PathVariable("id") Long id){
		disabilityServ.deleteDisability(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Disability with ID: " + id);
	}
	
	@ApiOperation(value = "Delete a Disability Type")
	@DeleteMapping("/disabilities/type/{id}")
	public ResponseEntity<?> deleteDisabilityType(@PathVariable("id") Long id){
		disabilityServ.deleteDisabilityType(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Disability Type with ID: " + id);
	}
}
