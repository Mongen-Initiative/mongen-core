package org.mongen.core.controller;

import java.util.List;

import org.mongen.core.models.Beneficiary;
import org.mongen.core.service.BeneficiaryService;
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
@RequestMapping("/api/v1")
public class BeneficiaryController {
	@Autowired
	BeneficiaryService beneficiaryServ;
	
	@ApiOperation(value = "Get All the Beneficiaries")
	@GetMapping("/beneficiaries")
	public ResponseEntity<List<Beneficiary>> getBeneficiaries(){
		List<Beneficiary> bene = beneficiaryServ.getBeneficiaries();
		return ResponseEntity.status(HttpStatus.OK).body(bene);
	}
	
	@ApiOperation(value = "Get one Beneficiary")
	@GetMapping("/beneficiaries/{id}")
	public ResponseEntity<Beneficiary> getBeneficiaryId(@PathVariable("id") Long id){
		Beneficiary bene = beneficiaryServ.findBeneficiaryById(id);
		return ResponseEntity.status(HttpStatus.OK).body(bene);
	}
	
	@ApiOperation(value = "Create a Beneficiary")
	@PostMapping("/beneficiaries")
	public ResponseEntity<Beneficiary> createBeneficiary(@RequestBody Beneficiary beneficiary){
		Beneficiary bene = beneficiaryServ.createBeneficiary(beneficiary);
		return ResponseEntity.status(HttpStatus.CREATED).body(bene);
	}
	
	@ApiOperation(value = "Update a Beneficiary")
	@PatchMapping("/beneficiaries/{id}")
	public ResponseEntity<Beneficiary> updateBeneficiary(@PathVariable("id") Long id, @RequestBody Beneficiary beneficiary){
		Beneficiary bene = beneficiaryServ.updateBeneficiary(beneficiary, id);
		return ResponseEntity.status(HttpStatus.OK).body(bene);
	}
	
	@ApiOperation(value = "Delete a Beneficiary")
	@DeleteMapping("/beneficiaries/{id}")
	public ResponseEntity<?> deleteBeneficiary(@PathVariable("id") Long id){
		beneficiaryServ.deleteBeneficiary(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Beneficiary with ID: " + id);
	}
	
}
