package org.mongen.core.controller;

import java.util.List;

import org.mongen.core.models.Donor;
import org.mongen.core.models.payloads.DonorPayload;
import org.mongen.core.service.DonorService;
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
public class DonorController {
	
	@Autowired
	DonorService donorServ;
	
	@ApiOperation(value = "Get All the Donors")
	@GetMapping("/donors")
	public ResponseEntity<List<Donor>> getDonors(){
		List<Donor> cola = donorServ.getDonors();
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Get one Donor")
	@GetMapping("/donor/{id}")
	public ResponseEntity<Donor> getDonorId(@PathVariable("id") Long id){
		Donor cola = donorServ.findDonorById(id);
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Create a Donor")
	@PostMapping("/donor")
	public ResponseEntity<Donor> createDonor(@RequestBody DonorPayload donor){
		Donor cola = donorServ.createDonor(donor);
		return ResponseEntity.status(HttpStatus.CREATED).body(cola);
	}
	
	@ApiOperation(value = "Update a Donor")
	@PatchMapping("/donor/{id}")
	public ResponseEntity<Donor> updateDonor(@PathVariable("id") Long id, @RequestBody Donor donor){
		Donor cola = donorServ.updateDonor(donor, id);
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Delete a Donor")
	@DeleteMapping("/donor/{id}")
	public ResponseEntity<?> deleteDonor(@PathVariable("id") Long id){
		donorServ.deleteDonor(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Donor with ID: " + id);
	}
}
