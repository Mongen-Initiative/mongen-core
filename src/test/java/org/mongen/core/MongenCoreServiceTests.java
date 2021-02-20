package org.mongen.core;

import org.junit.jupiter.api.Test;
import org.mongen.core.controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MongenCoreServiceTests {

	@Autowired
	private OrganizationController organizationController;
	@Autowired
	private CollaboratorController collaboratorController;
	@Autowired
	private BeneficiaryController beneficiaryController;
	@Autowired
	private CountryController countryController;
	@Autowired
	private DisabilityController disabilityController;
	@Autowired
	private DonorController donorController;
	@Autowired
	private InstitutionController institutionController;
	@Autowired
	private StreetLocationsController streetLocationsController;
	@Autowired
	private StreetSituationController streetSituationController;
	@Autowired
	private SupporterController supporterController;

	@Test
	public void contextLoads() {
	}

	@Test
	public void checkOrganizationController() throws Exception {
		assertThat(organizationController).isNotNull();
	}

	@Test
	public void checkCollaboratorController() throws Exception {
		assertThat(collaboratorController).isNotNull();
	}

	@Test
	public void checkBeneficiaryController() throws Exception {
		assertThat(beneficiaryController).isNotNull();
	}

	@Test
	public void checkCountryController() throws Exception {
		assertThat(countryController).isNotNull();
	}

	@Test
	public void checkDisabilityController() throws Exception {
		assertThat(disabilityController).isNotNull();
	}

	@Test
	public void checkDonorController() throws Exception {
		assertThat(donorController).isNotNull();
	}

	@Test
	public void checkInstitutionController() throws Exception {
		assertThat(institutionController).isNotNull();
	}

	@Test
	public void checkStreetLocationsController() throws Exception {
		assertThat(streetLocationsController).isNotNull();
	}

	@Test
	public void checkStreetSituationController() throws Exception {
		assertThat(streetSituationController).isNotNull();
	}

	@Test
	public void checkSupporterController() throws Exception {
		assertThat(supporterController).isNotNull();
	}
}
