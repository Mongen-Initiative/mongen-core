package org.mongen.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

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
	@Column(name="photo_id_url")
	private String photoIdURL;
	@Column(name="verification_selfie_url")
	private String verificationSelfieURL;
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
	
	public Collaborator() {
		
	}

	public Collaborator(String first_name, String last_name, CollaboratorType type, Country country) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.type = type;
		this.countryCollaborator = country;
	}

	public Collaborator(String first_name, String last_name, String photo_id_url, String verification_selfie_url, CollaboratorType type, Country country) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.photoIdURL = photo_id_url;
		this.verificationSelfieURL = verification_selfie_url;
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
