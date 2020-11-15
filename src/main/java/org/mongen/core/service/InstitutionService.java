package org.mongen.core.service;

import java.util.List;
import java.util.Optional;

import org.mongen.core.models.Disability;
import org.mongen.core.models.DisabilityType;
import org.mongen.core.models.Institution;
import org.mongen.core.models.InstitutionType;
import org.mongen.core.repository.InstitutionRepository;
import org.mongen.core.repository.InstitutionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService {
	@Autowired
	InstitutionRepository institutionRepo;
	
	@Autowired
	InstitutionTypeRepository typeRepo;

	public List<Institution> getInstitutions(){
		return institutionRepo.findAll();
	}
	
	public List<InstitutionType> getInstitutionTypes(){
		return typeRepo.findAll();
	}
	
	public Institution findInstitutionById(Long id) {
		Optional<Institution> temp = institutionRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public InstitutionType findInstitutionTypeById(Long id) {
		Optional<InstitutionType> temp = typeRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public Institution createInstitution(Institution nuevo, InstitutionType nuevoType) {
		String nametype = nuevoType.getType();
		if (nametype != null && !nametype.isEmpty()) {
			nametype = nametype.substring(0, 1).toUpperCase() + nametype.substring(1).toLowerCase();
			InstitutionType type = typeRepo.findByType(nametype);
			if (null != type) {
				nuevo.setType(type);
			} else {
				nuevoType.setType(nametype);
				nuevo.setType(typeRepo.save(nuevoType));
			}
		}
		return institutionRepo.save(nuevo);
	}
	
	public Institution updateInstitution(Institution nuevo,Long id) {
		nuevo.setId(id);
		return institutionRepo.save(nuevo);
	}
	
	public void deleteInstitution(Long id) {
		institutionRepo.deleteById(id);
	}
	
	public void deleteInstitutionType(Long id) {
		typeRepo.deleteById(id);
	}
}
