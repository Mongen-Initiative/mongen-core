package org.mongen.core.controller;

import java.util.List;

import org.mongen.core.models.Supporter;
import org.mongen.core.service.SupporterService;
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
public class SupporterController {
	
	@Autowired
	SupporterService supporterServ;
	
	@ApiOperation(value = "Get All the Supporters")
	@GetMapping("/supporters")
	public ResponseEntity<List<Supporter>> getSupporters(){
		List<Supporter> supp = supporterServ.getSupporters();
		return ResponseEntity.status(HttpStatus.OK).body(supp);
	}
	
	@ApiOperation(value = "Get one Supporter")
	@GetMapping("/supporters/{id}")
	public ResponseEntity<Supporter> getSupporterId(@PathVariable("id") Long id){
		Supporter supp = supporterServ.findSupporterById(id);
		return ResponseEntity.status(HttpStatus.OK).body(supp);
	}
	
	@ApiOperation(value = "Create a Supporter")
	@PostMapping("/supporters")
	public ResponseEntity<Supporter> createSupporter(@RequestBody Supporter supporter){
		Supporter supp = supporterServ.createSupporter(supporter);
		return ResponseEntity.status(HttpStatus.CREATED).body(supp);
	}
	
	@ApiOperation(value = "Update a Supporter")
	@PatchMapping("/supporters/{id}")
	public ResponseEntity<Supporter> updateSupporter(@PathVariable("id") Long id, @RequestBody Supporter supporter){
		Supporter supp = supporterServ.updateSupporter(supporter, id);
		return ResponseEntity.status(HttpStatus.OK).body(supp);
	}
	
	@ApiOperation(value = "Delete a Supporter")
	@DeleteMapping("/supporters/{id}")
	public ResponseEntity<?> deleteSupporter(@PathVariable("id") Long id){
		supporterServ.deleteSupporter(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Supporter with ID: " + id);
	}
}
