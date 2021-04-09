package org.mongen.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mongen.core.models.Country;
import org.mongen.core.models.Donor;
import org.mongen.core.models.Organization;
import org.mongen.core.models.payloads.DonorPayload;
import org.mongen.core.repository.CountryRepository;
import org.mongen.core.repository.DonorRepository;
import org.mongen.core.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorService {
	@Autowired
	DonorRepository donorRepo;
	@Autowired
	CountryRepository countryRepo;
	@Autowired
	OrganizationRepository organizationRepo;
	
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
	
	public Donor createDonor(DonorPayload donor_payload) {
		Country country = countryRepo.findByCountryISO(donor_payload.getCountry_iso());
		List<Organization> org_list = new ArrayList<>();
		Optional<Organization> organization = organizationRepo.findById(donor_payload.getOrganization_id());
		org_list.add(organization.get());
		Donor new_donor = new Donor(donor_payload.getFirst_name(), donor_payload.getLast_name(), donor_payload.getAddress(), country, org_list);
		return donorRepo.save(new_donor);
	}
	
	public Donor updateDonor(Donor nuevo,Long id) {
		nuevo.setId(id);
		return donorRepo.save(nuevo);
	}
	
	public void deleteDonor(Long id) {
		donorRepo.deleteById(id);
	}
}
