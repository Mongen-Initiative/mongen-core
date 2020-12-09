package org.mongen.core.service;

import org.mongen.core.models.Organization;
import org.mongen.core.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
	@Autowired
	OrganizationRepository organizationRepo;
	
	public List<Organization> getOrganizations(){
		return organizationRepo.findAll();
	}
	
	public Organization findOrganizationById(Long id) {
		Optional<Organization> temp = organizationRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public Organization createOrganization(Organization nuevo) {
		return organizationRepo.save(nuevo);
	}
	
	public Organization updateOrganization(Organization nuevo, Long id) {
		nuevo.setId(id);
		return organizationRepo.save(nuevo);
	}
	
	public void deleteOrganization(Long id) {
		organizationRepo.deleteById(id);
	}
}
