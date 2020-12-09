package org.mongen.core.service;

import org.mongen.core.models.StreetLocations;
import org.mongen.core.repository.StreetLocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetLocationsService {
	@Autowired
	StreetLocationsRepository streetLocationsRepo;
	
	public List<StreetLocations> getStreetLocations(){
		return streetLocationsRepo.findAll();
	}
	
	public StreetLocations findStreetLocationById(Long id) {
		Optional<StreetLocations> temp = streetLocationsRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public StreetLocations createStreetLocation(StreetLocations nuevo) {
		return streetLocationsRepo.save(nuevo);
	}
	
	public StreetLocations updateStreetLocation(StreetLocations nuevo,Long id) {
		nuevo.setId(id);
		return streetLocationsRepo.save(nuevo);
	}
	
	public void deleteStreetLocation(Long id) {
		streetLocationsRepo.deleteById(id);
	}
}
