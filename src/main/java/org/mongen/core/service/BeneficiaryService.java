package org.mongen.core.service;

import java.util.List;
import java.util.Optional;

import org.mongen.core.models.Beneficiary;
import org.mongen.core.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiaryService {
	@Autowired
	BeneficiaryRepository beneficiaryRepo;
	
	public List<Beneficiary> getBeneficiaries(){
		return beneficiaryRepo.findAll();
	}
	
	public Beneficiary findBeneficiaryById(Long id) {
		Optional<Beneficiary> temp = beneficiaryRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public Beneficiary createBeneficiary(Beneficiary nuevo) {
		return beneficiaryRepo.save(nuevo);
	}
	
	public Beneficiary updateBeneficiary(Beneficiary nuevo,Long id) {
		nuevo.setId(id);
		return beneficiaryRepo.save(nuevo);
	}
	
	public void deleteBeneficiary(Long id) {
		beneficiaryRepo.deleteById(id);
	}
}
