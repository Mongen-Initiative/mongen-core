package org.mongen.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.mongen.core.models.Beneficiary;
import org.mongen.core.models.Collaborator;
import org.mongen.core.models.Country;
import org.mongen.core.models.Organization;
import org.mongen.core.models.payloads.BeneficiaryPayload;
import org.mongen.core.repository.BeneficiaryRepository;
import org.mongen.core.repository.CountryRepository;
import org.mongen.core.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeneficiaryService {
	@Autowired
	BeneficiaryRepository beneficiaryRepo;
	@Autowired
	CountryRepository countryRepo;
	@Autowired
	OrganizationRepository organizationRepo;
	
	public List<Beneficiary> getBeneficiaries(){
		return beneficiaryRepo.findAll();
	}

	public List<Beneficiary> getBeneficiariesByOrganization(Long org_id){
		List<Beneficiary> beneficiaries = organizationRepo.findById(org_id).get().getBeneficiaries();
		return beneficiaries;
	}
	
	public Beneficiary findBeneficiaryById(Long id) {
		Optional<Beneficiary> temp = beneficiaryRepo.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	
	public Beneficiary createBeneficiary(BeneficiaryPayload new_beneficiary) {
		Country country = countryRepo.findByCountryISO(new_beneficiary.getCountry_iso());
		List<Organization> org_list = new ArrayList<>();
		Optional<Organization> organization = organizationRepo.findById(new_beneficiary.getOrganization_id());
		org_list.add(organization.get());
		// TODO: Process disabilities and street situations
		Beneficiary beneficiary = new Beneficiary(
				new_beneficiary.getFirst_name(),
				new_beneficiary.getLast_name(),
				new_beneficiary.getGender(),
				new_beneficiary.getDate_of_birth(),
				new_beneficiary.getHeight(),
				new_beneficiary.getWeight(),
				new_beneficiary.getAddress(),
				country,
				org_list
		);

		return beneficiaryRepo.save(beneficiary);
	}
	
	public Beneficiary updateBeneficiary(Beneficiary nuevo,Long id) {
		nuevo.setId(id);
		return beneficiaryRepo.save(nuevo);
	}
	
	public void deleteBeneficiary(Long id) {
		beneficiaryRepo.deleteById(id);
	}
}
