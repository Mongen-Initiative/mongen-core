package org.mongen.core.models.responses;

import lombok.Data;
import org.mongen.core.models.Beneficiary;
import org.mongen.core.models.Collaborator;
import org.mongen.core.models.Organization;
import org.mongen.core.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;



@Data
public class OrganizationResponse {

	@Autowired
	CollaboratorService collaboratorServ;

	private Long id;
	private String name;
	private String seo_name;
	private String logo_url;
	private String address;
	private String social_network_url;
	private String story;
	private String mission;
	private String vision;
	private MainContactResponse main_contact;
	private boolean verified;
	private Date created;
	private Date updated;
	private String country;
	private List<Collaborator> collaborators;
	private List<Beneficiary> beneficiaries;

	public OrganizationResponse(Organization org){
		this.id = org.getId();
		this.name = org.getName();
		this.seo_name = org.getSeoName();
		this.logo_url = org.getLogoUrl();
		this.address = org.getAddress();
		this.social_network_url = org.getSocialNetworkUrl();
		this.story = org.getStory();
		this.mission = org.getMission();
		this.vision = org.getVision();
		this.main_contact = new MainContactResponse(org.getMain_contact()) ;
		this.verified = org.isVerified();
		this.created = org.getCreated();
		this.updated = org.getUpdated();
		this.country = org.getCountry().getName();
		this.collaborators = org.getCollaborators();
		this.beneficiaries = org.getBeneficiaries();
	}
}
