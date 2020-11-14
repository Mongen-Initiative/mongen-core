package org.mongen.core.service;

import java.util.List;
import java.util.Optional;

import org.mongen.core.models.Donor;
import org.mongen.core.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorService {
	@Autowired
	DonorRepository donorRepo;
	
	public List<Donor> getDonors(){
		return donorRepo.findAll();
	}
	
	public Donor findDonorById(Long id) {
		Optional<Donor> temp = donorRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public Donor createDonor(Donor nuevo) {
		return donorRepo.save(nuevo);
	}
	
	public Donor updateDonor(Donor nuevo,Long id) {
		nuevo.setId(id);
		return donorRepo.save(nuevo);
	}
	
	public void deleteDonor(Long id) {
		donorRepo.deleteById(id);
	}
}
