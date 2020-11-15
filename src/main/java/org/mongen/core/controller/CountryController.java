package org.mongen.core.controller;

import java.util.List;

import org.mongen.core.models.Country;
import org.mongen.core.service.CountryService;
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
public class CountryController {
	@Autowired
	CountryService countryServ;
	
	@ApiOperation(value = "Get All the Countries")
	@GetMapping("/countries")
	public ResponseEntity<List<Country>> getCountries(){
		List<Country> coun = countryServ.getCountries();
		return ResponseEntity.status(HttpStatus.OK).body(coun);
	}
	
	@ApiOperation(value = "Get one Country")
	@GetMapping("/countries/{id}")
	public ResponseEntity<Country> getCountryId(@PathVariable("id") Long id){
		Country coun = countryServ.findCountryById(id);
		return ResponseEntity.status(HttpStatus.OK).body(coun);
	}
	
	@ApiOperation(value = "Create a Country")
	@PostMapping("/countries")
	public ResponseEntity<Country> createCountry(@RequestBody Country country){
		Country coun = countryServ.createCountry(country);
		return ResponseEntity.status(HttpStatus.CREATED).body(coun);
	}
	
	@ApiOperation(value = "Update a Country")
	@PatchMapping("/countries/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable("id") Long id, @RequestBody Country country){
		Country coun = countryServ.updateCountry(country, id);
		return ResponseEntity.status(HttpStatus.OK).body(coun);
	}
	
	@ApiOperation(value = "Delete a Country")
	@DeleteMapping("/countries/{id}")
	public ResponseEntity<?> deleteCountry(@PathVariable("id") Long id){
		countryServ.deleteCountry(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Country with ID: " + id);
	}
}
