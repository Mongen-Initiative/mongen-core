package org.mongen.core.service;

import java.util.List;
import java.util.Optional;

import org.mongen.core.models.Country;
import org.mongen.core.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
	@Autowired
	CountryRepository countryRepo;
	
	public List<Country> getCountries(){
		return countryRepo.findAll();
	}
	
	public Country findCountryById(String countryISO) {
		Optional<Country> temp = Optional.ofNullable(countryRepo.findByCountryISO(countryISO));
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public Country createCountry(Country nuevo) {
		return countryRepo.save(nuevo);
	}
	
	public Country updateCountry(Country nuevo,String countryISO) {
		nuevo.setCountryISO(countryISO);
		return countryRepo.save(nuevo);
	}
	
	public void deleteCountry(String countryISO) {
		countryRepo.deleteByCountryISO(countryISO);
	}
}
