package org.mongen.core.controller;

import io.swagger.annotations.ApiOperation;
import org.mongen.core.models.StreetSituation;
import org.mongen.core.service.StreetSituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StreetSituationController {
	
	@Autowired
	StreetSituationService streetSituationServ;
	
	@ApiOperation(value = "Get All the Street Situations")
	@GetMapping("/street_situations")
	public ResponseEntity<List<StreetSituation>> getDonors(){
		List<StreetSituation> cola = streetSituationServ.getStreetSituations();
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Get one StreetSituation")
	@GetMapping("/street_situation/{id}")
	public ResponseEntity<StreetSituation> getDonorId(@PathVariable("id") Long id){
		StreetSituation cola = streetSituationServ.findStreetSituationById(id);
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Create a StreetSituation")
	@PostMapping("/street_situation")
	public ResponseEntity<StreetSituation> createDonor(@RequestBody StreetSituation streetSituation){
		StreetSituation cola = streetSituationServ.createStreetSituation(streetSituation);
		return ResponseEntity.status(HttpStatus.CREATED).body(cola);
	}
	
	@ApiOperation(value = "Update a StreetSituation")
	@PatchMapping("/street_situation/{id}")
	public ResponseEntity<StreetSituation> updateDonor(@PathVariable("id") Long id, @RequestBody StreetSituation streetSituation){
		StreetSituation cola = streetSituationServ.updateStreetSituation(streetSituation, id);
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Delete a StreetSituation")
	@DeleteMapping("/street_situation/{id}")
	public ResponseEntity<?> deleteDonor(@PathVariable("id") Long id){
		streetSituationServ.deleteStreetSituation(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete StreetSituation with ID: " + id);
	}
}
