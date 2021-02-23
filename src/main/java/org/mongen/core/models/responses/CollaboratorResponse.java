package org.mongen.core.models.responses;

import lombok.Data;
import org.mongen.core.models.Collaborator;
import org.mongen.core.models.Organization;

import java.util.Date;
import java.util.List;

@Data
public class CollaboratorResponse {

	private Long id;
	private String first_name;
	private String last_name;
	private String email;
	private String user_type;
	private Date created;
	private Date updated;
	private String nationality;
	private List<Organization> organizations;

	public CollaboratorResponse(Collaborator collaborator){
		this.id = collaborator.getId();
		this.first_name = collaborator.getFirstName();
		this.last_name = collaborator.getLastName();
		this.email = collaborator.getEmail();
		this.user_type = collaborator.getType().getName();
		this.nationality = collaborator.getCountryCollaborator().getName();
		this.organizations = collaborator.getOrganizations();
		this.created = collaborator.getCreated();
		this.updated = collaborator.getUpdated();
	}
}
