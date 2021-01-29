package org.mongen.core.service;

import org.mongen.core.models.Collaborator;
import org.mongen.core.models.CollaboratorType;
import org.mongen.core.models.Country;
import org.mongen.core.models.Organization;
import org.mongen.core.models.payloads.OrganizationPayload;
import org.mongen.core.models.responses.OrganizationResponse;
import org.mongen.core.repository.CollaboratorRepository;
import org.mongen.core.repository.CountryRepository;
import org.mongen.core.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
	@Autowired
	OrganizationRepository organizationRepo;
	@Autowired
	CountryRepository countryRepo;
	@Autowired
	CollaboratorService collaboratorServ;
	
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

	public Organization findOrganizationBySeoName(String seo_name) {
		Optional<Organization> temp = Optional.ofNullable(organizationRepo.findBySeoName(seo_name));
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public Organization createOrganization(OrganizationPayload org_payload) {
		Country country = countryRepo.findByCountryISO(org_payload.getCountry_iso());
		Collaborator contact = collaboratorServ.findCollaboratorById(org_payload.getContact_id());
		Organization new_org = new Organization(org_payload.getName(), org_payload.getSeo_name(), org_payload.getLogo_url(), org_payload.getMission(), org_payload.getVision(), org_payload.getAddress(), country, contact);
		return organizationRepo.save(new_org);
	}
	
	public Organization updateOrganization(Organization nuevo, Long id) {
		nuevo.setId(id);
		return organizationRepo.save(nuevo);
	}

	public OrganizationResponse generateOrganizationResponse(Organization org){
		OrganizationResponse org_resp = new OrganizationResponse(org);
		return org_resp;
	}
	
	public void deleteOrganization(Long id) {
		organizationRepo.deleteById(id);
	}
}
