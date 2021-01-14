package org.mongen.core.service;

import java.util.List;
import java.util.Optional;

import org.mongen.core.models.Collaborator;
import org.mongen.core.models.CollaboratorType;
import org.mongen.core.models.Country;
import org.mongen.core.models.payloads.CollaboratorPayload;
import org.mongen.core.models.payloads.MainContactPayload;
import org.mongen.core.repository.CollaboratorRepository;
import org.mongen.core.repository.CollaboratorTypeRepository;
import org.mongen.core.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollaboratorService {
	@Autowired
	CollaboratorRepository collaboratorRepo;
	@Autowired
	CollaboratorTypeRepository collaboratorTypeRepo;
	@Autowired
	CountryRepository countryRepo;
	
	public List<Collaborator> getCollaborators(){
		return collaboratorRepo.findAll();
	}
	
	public Collaborator findCollaboratorById(Long id) {
		Optional<Collaborator> temp = collaboratorRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public Collaborator createCollaborator(CollaboratorPayload collaborator_payload) {
		Country country = countryRepo.findByCountryISO(collaborator_payload.getCountry_iso());
		CollaboratorType type = collaboratorTypeRepo.findByName(collaborator_payload.getType());
		Collaborator new_collaborator = new Collaborator(collaborator_payload.getFirst_name(), collaborator_payload.getLast_name(), type, country);
		return collaboratorRepo.save(new_collaborator);
	}

	public Collaborator createMainContact(MainContactPayload main_contact_payload) {
		Country country = countryRepo.findByCountryISO(main_contact_payload.getCountry_iso());
		CollaboratorType type = collaboratorTypeRepo.findByName(main_contact_payload.getType());
		Collaborator new_collaborator = new Collaborator(main_contact_payload.getFirst_name(), main_contact_payload.getLast_name(), main_contact_payload.getPhoto_id_url(), main_contact_payload.getVerification_selfie_url(), type, country);
		return collaboratorRepo.save(new_collaborator);
	}
	
	public Collaborator updateCollaborator(Collaborator nuevo,Long id) {
		nuevo.setId(id);
		return collaboratorRepo.save(nuevo);
	}
	
	public void deleteCollaborator(Long id) {
		collaboratorRepo.deleteById(id);
	}

	public List<CollaboratorType> getCollaboratorTypes() {
		return collaboratorTypeRepo.findAll();
	}
}
