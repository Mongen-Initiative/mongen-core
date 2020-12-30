package org.mongen.core.service;

import org.mongen.core.models.StreetSituation;
import org.mongen.core.repository.StreetSituationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreetSituationService {
	@Autowired
	StreetSituationRepository streetSituationRepo;
	
	public List<StreetSituation> getStreetSituations(){
		return streetSituationRepo.findAll();
	}
	
	public StreetSituation findStreetSituationById(Long id) {
		Optional<StreetSituation> temp = streetSituationRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public StreetSituation createStreetSituation(StreetSituation nuevo) {
		return streetSituationRepo.save(nuevo);
	}
	
	public StreetSituation updateStreetSituation(StreetSituation nuevo,Long id) {
		nuevo.setId(id);
		return streetSituationRepo.save(nuevo);
	}
	
	public void deleteStreetSituation(Long id) {
		streetSituationRepo.deleteById(id);
	}
}
