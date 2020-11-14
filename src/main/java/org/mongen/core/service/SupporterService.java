package org.mongen.core.service;

import java.util.List;
import java.util.Optional;

import org.mongen.core.models.Supporter;
import org.mongen.core.repository.SupporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupporterService {
	@Autowired
	SupporterRepository supporterRepo;
	
	public List<Supporter> getSupporters(){
		return supporterRepo.findAll();
	}
	
	public Supporter findSupporterById(Long id) {
		Optional<Supporter> temp = supporterRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public Supporter createSupporter(Supporter nuevo) {
		return supporterRepo.save(nuevo);
	}
	
	public Supporter updateSupporter(Supporter nuevo,Long id) {
		nuevo.setId(id);
		return supporterRepo.save(nuevo);
	}
	
	public void deleteSupporter(Long id) {
		supporterRepo.deleteById(id);
	}
}
