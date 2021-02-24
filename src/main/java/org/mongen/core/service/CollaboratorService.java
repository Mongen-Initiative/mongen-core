package org.mongen.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mongen.core.models.Collaborator;
import org.mongen.core.models.CollaboratorType;
import org.mongen.core.models.Country;
import org.mongen.core.models.Organization;
import org.mongen.core.models.payloads.CollaboratorPayload;
import org.mongen.core.models.payloads.MainContactPayload;
import org.mongen.core.models.responses.CollaboratorResponse;
import org.mongen.core.models.responses.OrganizationResponse;
import org.mongen.core.repository.CollaboratorRepository;
import org.mongen.core.repository.CollaboratorTypeRepository;
import org.mongen.core.repository.CountryRepository;
import org.mongen.core.repository.OrganizationRepository;
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
	@Autowired
	OrganizationRepository organizationRepo;
	
	public List<Collaborator> getCollaborators(){
		return collaboratorRepo.findAll();
	}

	public List<Collaborator> getCollaboratorsByOrganization(Long org_id){
		List<Collaborator> collaborators = organizationRepo.findById(org_id).get().getCollaborators();
		return collaborators;
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
		List<Organization> org_list = new ArrayList<>();
		Country country = countryRepo.findByCountryISO(collaborator_payload.getCountry_iso());
		CollaboratorType type = collaboratorTypeRepo.findByName(collaborator_payload.getType());
		Optional<Organization> organization = organizationRepo.findById(collaborator_payload.getOrganization_id());
		org_list.add(organization.get());
		Collaborator new_collaborator = new Collaborator(collaborator_payload.getFirst_name(), collaborator_payload.getLast_name(), collaborator_payload.getEmail(), type, country, org_list);
		return collaboratorRepo.save(new_collaborator);
	}

	public Collaborator createMainContact(MainContactPayload main_contact_payload) {
		Country country = countryRepo.findByCountryISO(main_contact_payload.getCountry_iso());
		CollaboratorType type = collaboratorTypeRepo.findByName(main_contact_payload.getType());
		Collaborator new_collaborator = new Collaborator(main_contact_payload.getFirst_name(), main_contact_payload.getLast_name(), main_contact_payload.getEmail(), main_contact_payload.getPhoto_id_url(), type, country);
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

	public CollaboratorResponse generateCollaboratorResponse(Collaborator collaborator){
		CollaboratorResponse collaborator_resp = new CollaboratorResponse(
				collaborator.getId(),
				collaborator.getFirstName(),
				collaborator.getLastName(),
				collaborator.getEmail(),
				collaborator.getType().getName(),
				collaborator.getCreated(),
				collaborator.getUpdated(),
				collaborator.getCountryCollaborator().getName());
		return collaborator_resp;
	}

	public List<CollaboratorResponse> generateListCollaboratorResponse(List<Collaborator> collaborators){

		List<CollaboratorResponse> collaborators_response = collaborators.stream()
				.map(element-> this.generateCollaboratorResponse(element))
				.collect(Collectors.toList());

		return collaborators_response;
	}
}
