package org.mongen.core.controller;

import io.swagger.annotations.ApiOperation;
import org.mongen.core.models.StreetLocations;
import org.mongen.core.service.StreetLocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StreetLocationsController {
	
	@Autowired
	StreetLocationsService streetLocationsServ;
	
	@ApiOperation(value = "Get All the Street Locations")
	@GetMapping("/street_locations")
	public ResponseEntity<List<StreetLocations>> getStreetLocations(){
		List<StreetLocations> cola = streetLocationsServ.getStreetLocations();
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Get one StreetLocation")
	@GetMapping("/street_location/{id}")
	public ResponseEntity<StreetLocations> getStreetLocationById(@PathVariable("id") Long id){
		StreetLocations cola = streetLocationsServ.findStreetLocationById(id);
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Create a StreetLocation")
	@PostMapping("/street_location")
	public ResponseEntity<StreetLocations> createStreetLocation(@RequestBody StreetLocations streetLocation){
		StreetLocations cola = streetLocationsServ.createStreetLocation(streetLocation);
		return ResponseEntity.status(HttpStatus.CREATED).body(cola);
	}
	
	@ApiOperation(value = "Update a StreetLocation")
	@PatchMapping("/street_location/{id}")
	public ResponseEntity<StreetLocations> updateStreetLocation(@PathVariable("id") Long id, @RequestBody StreetLocations streetLocation){
		StreetLocations cola = streetLocationsServ.updateStreetLocation(streetLocation, id);
		return ResponseEntity.status(HttpStatus.OK).body(cola);
	}
	
	@ApiOperation(value = "Delete a StreetLocation")
	@DeleteMapping("/street_location/{id}")
	public ResponseEntity<?> deleteStreetLocation(@PathVariable("id") Long id){
		streetLocationsServ.deleteStreetLocation(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete StreetLocation with ID: " + id);
	}
}
