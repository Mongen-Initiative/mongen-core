package org.mongen.core.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
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
	@Column(name="seo_name")
	private String seoName;
	private boolean verified;
	private String address;
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

	@ManyToMany
	@JoinTable(
			name = "organization_collaborators",
			joinColumns = @JoinColumn(name = "organization_id"),
			inverseJoinColumns = @JoinColumn(name = "collaborator_id")
	)
	private List<Beneficiary> collaborators;

	public Organization() {
		
	}

	public Organization(String name, String seo_name, String mission, String vision, String address, Country country, Collaborator contact) {
		this.name = name;
		this.seoName = seo_name;
		this.mission = mission;
		this.vision = vision;
		this.address = address;
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
