package org.mongen.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

@Entity
@Table(name="collaborator")
@Data
public class Collaborator implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String email;
	@Column(name="photo_id_url")
	private String photoIdURL;
	@JsonIgnore
	@Column(updatable=false)
	private Date created;
	@JsonIgnore
	private Date updated;
	
	@ManyToOne
	@JoinColumn(name="country_iso")
	private Country countryCollaborator;

	@ManyToOne
	@JoinColumn(name="type")
	private CollaboratorType type;

	@ManyToMany(mappedBy = "collaborators")
	private List<Organization> organizations;

	public Collaborator() {
		
	}

	public Collaborator(String first_name, String last_name, String email, CollaboratorType type, Country country, List<Organization> organizations) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.type = type;
		this.countryCollaborator = country;
		this.organizations = organizations;
	}

	public Collaborator(String first_name, String last_name, String email, String photo_id_url, CollaboratorType type, Country country) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
		this.photoIdURL = photo_id_url;
		this.type = type;
		this.countryCollaborator = country;
	}

	@PrePersist
    protected void onCreate(){
        this.created = new Date();
    }
	
	@PreUpdate
    protected void onUpdate(){
        this.updated = new Date();
    }

}
