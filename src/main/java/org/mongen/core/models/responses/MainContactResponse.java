package org.mongen.core.models.responses;

import lombok.Data;
import org.mongen.core.models.Collaborator;

import java.util.Date;

@Data
public class MainContactResponse {

	private Long id;
	private String first_name;
	private String last_name;
	private String email;
	private String user_type;
	private String photo_id_url;
	private Date created;
	private Date updated;
	private String nationality;

	public MainContactResponse(Collaborator collaborator){
		this.id = collaborator.getId();
		this.first_name = collaborator.getFirstName();
		this.last_name = collaborator.getLastName();
		this.email = collaborator.getEmail();
		this.user_type = collaborator.getType().getName();
		this.photo_id_url = collaborator.getPhotoIdURL();
		this.nationality = collaborator.getCountryCollaborator().getName();
		this.created = collaborator.getCreated();
		this.updated = collaborator.getUpdated();
	}
}
