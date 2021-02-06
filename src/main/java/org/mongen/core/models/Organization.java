package org.mongen.core.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="organization")
@Data
public class Organization implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden=true)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="logo_url")
	private String logoUrl;
	@Column(name="seo_name")
	private String seoName;
	private boolean verified;
	private String address;
	@Column(name="social_network_url")
	private String socialNetworkUrl;
	private String story;
	private String mission;
	private String vision;


	@ApiModelProperty(hidden=true)
	@Column(updatable=false)
	private Date created;
	@ApiModelProperty(hidden=true)
	private Date updated;

	@ManyToOne
	@JoinColumn(name="country_iso")
	private Country country;

	@ManyToOne
	@JoinColumn(name="contact")
	private Collaborator collaborator;

//	@OneToMany
//	@JoinColumn(name="social_media")
//	private Collection<SocialMedia> social_media;

	@ManyToMany
	@JoinTable(
			name = "organization_collaborators",
			joinColumns = @JoinColumn(name = "organization_id"),
			inverseJoinColumns = @JoinColumn(name = "collaborator_id")
	)
	private List<Collaborator> collaborators;

	@ManyToMany
	@JoinTable(
			name = "organization_beneficiaries",
			joinColumns = @JoinColumn(name = "organization_id"),
			inverseJoinColumns = @JoinColumn(name = "beneficiary_id")
	)
	private List<Beneficiary> beneficiaries;

	public Organization() {
		
	}

	public Organization(String name, String seo_name, String logo_url, String story, String mission, String vision, String address, String social_network_url, Country country, Collaborator contact) {
		this.name = name;
		this.seoName = seo_name;
    this.logoUrl = logo_url;
		this.story = story;
		this.mission = mission;
		this.vision = vision;
		this.address = address;
		this.socialNetworkUrl = social_network_url;
		this.country = country;
		this.collaborator = contact;
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
