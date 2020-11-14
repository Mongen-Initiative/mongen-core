package org.mongen.core.service;

import java.util.List;
import java.util.Optional;

import org.mongen.core.models.Disability;
import org.mongen.core.models.DisabilityType;
import org.mongen.core.repository.DisabilityRepository;
import org.mongen.core.repository.DisabilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisabilityService {
	@Autowired
	DisabilityRepository disabilityRepo;
	
	@Autowired
	DisabilityTypeRepository typeRepo;
	
	public List<Disability> getDisabilities(){
		return disabilityRepo.findAll();
	}
	
	public List<DisabilityType> getDisabilityTypes(){
		return typeRepo.findAll();
	}
	
	public Disability findDisabilityById(Long id) {
		Optional<Disability> temp = disabilityRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public DisabilityType findDisabilityTypeById(Long id) {
		Optional<DisabilityType> temp = typeRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public Disability createDisability(Disability nuevo, DisabilityType nuevoType) {
		String nametype = nuevoType.getName();
		if (nametype != null && !nametype.isEmpty()) {
			nametype = nametype.substring(0, 1).toUpperCase() + nametype.substring(1).toLowerCase();
			DisabilityType type = typeRepo.findByName(nametype);
			if (null != type) {
				nuevo.setType(type);
			} else {
				nuevoType.setName(nametype);
				nuevo.setType(typeRepo.save(nuevoType));
			}
		}
		return disabilityRepo.save(nuevo);
	}
	
	public Disability updateDisability(Disability nuevo,Long id) {
		nuevo.setId(id);
		return disabilityRepo.save(nuevo);
	}
	
	public void deleteDisability(Long id) {
		disabilityRepo.deleteById(id);
	}
	
	public void deleteDisabilityType(Long id) {
		typeRepo.deleteById(id);
	}
}
