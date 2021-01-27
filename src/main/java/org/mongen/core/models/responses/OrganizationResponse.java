package org.mongen.core.models.responses;

import lombok.Data;
import org.mongen.core.models.Collaborator;
import org.mongen.core.models.Organization;

import java.util.Date;

@Data
public class OrganizationResponse {

	private Long id;
	private String name;
	private String seo_name;
	private String address;
	private String mission;
	private String vision;
	private Collaborator main_contact;
	private boolean verified;
	private Date created;
	private Date updated;
	private String country;

	public OrganizationResponse(Organization org){
		this.id = org.getId();
		this.name = org.getName();
		this.seo_name = org.getSeoName();
		this.address = org.getAddress();
		this.mission = org.getMission();
		this.vision = org.getVision();
		this.main_contact = org.getCollaborator();
		this.verified = org.isVerified();
		this.created = org.getCreated();
		this.updated = org.getUpdated();
		this.country = org.getCountry().getName();
	}
}
