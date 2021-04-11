package org.mongen.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
	@Column(name="name", length = 50)
	@Size(min = 3, max = 50)
	private String name;
	@Column(name="logo_url", length = 2000)
	private String logoUrl;
	@Column(name="seo_name", length = 50)
	@Size(min = 3, max = 50)
	private String seoName;
	@Column(length = 2000)
	private String address;
	@Column(name="social_network_url", length = 2000)
	private String socialNetworkUrl;
	@Column(length = 3000)
	private String story;
	@Column(length = 3000)
	private String mission;
	@Column(length = 3000)
	private String vision;
	@Column(length = 3000)
	private String tagline;


	@JsonIgnore
	@ApiModelProperty(hidden=true)
	@Column(updatable=false)
	private Date created;
	@JsonIgnore
	@ApiModelProperty(hidden=true)
	private Date updated;

	@ManyToOne
	@JoinColumn(name="country_iso")
	private Country country;

	@ManyToOne
	@JoinColumn(name="contact")
	private Collaborator main_contact;

	@ManyToOne
	@JoinColumn(name="status")
	private OrganizationStatus status;

//	@OneToMany
//	@JoinColumn(name="social_media")
//	private Collection<SocialMedia> social_media;

	@JsonIgnore
	@ManyToMany(mappedBy = "organizations")
	private List<Collaborator> collaborators;

	@JsonIgnore
	@ManyToMany(mappedBy = "organizations")
	private List<Beneficiary> beneficiaries;

	@JsonIgnoreProperties(value={"organizations", "beneficiaries", "created","id","updated","country"})
	@ManyToMany
	@JoinTable(
			name = "organization_donors",
			joinColumns = @JoinColumn(name = "organization_id"),
			inverseJoinColumns = @JoinColumn(name = "donor_id")
	)
	private List<Donor> donors;

	public Organization() {
		
	}

	public Organization(String name, String seo_name, String logo_url, String story, String tagline, String mission, String vision, String address, String social_network_url, Country country, Collaborator contact, OrganizationStatus status) {
		this.name = name;
		this.seoName = seo_name;
		this.logoUrl = logo_url;
		this.story = story;
		this.tagline = tagline;
		this.mission = mission;
		this.vision = vision;
		this.address = address;
		this.socialNetworkUrl = social_network_url;
		this.country = country;
		this.main_contact = contact;
		this.status = status;
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
