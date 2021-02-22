package org.mongen.core.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name="beneficiary")
@Data
public class Beneficiary implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden=true)
	private Long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String gender;
	private Integer age;
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	private Integer height;
	private Integer weight;
	private String address;
	
	@ApiModelProperty(hidden=true)
	@Column(updatable=false)
	private Date created;
	@ApiModelProperty(hidden=true)
	private Date updated;

	@ManyToMany
	@JoinTable(
			name = "beneficiary_organization",
			joinColumns = @JoinColumn(name = "beneficiary_id"),
			inverseJoinColumns = @JoinColumn(name = "organization_id")
	)
	List<Organization> organizations;
	
	@JsonIgnoreProperties(value={"beneficiaries","created","id","updated"})
	@ManyToMany
    @JoinTable(
        name = "beneficiary_institutions", 
        joinColumns = @JoinColumn(name = "beneficiary_id"), 
        inverseJoinColumns = @JoinColumn(name = "institution_id")
    )
    private List<Institution> institutions;
	
	@JsonIgnoreProperties(value={"beneficiaries","created","id","updated","country"})
	@ManyToMany
    @JoinTable(
        name = "beneficiary_donors", 
        joinColumns = @JoinColumn(name = "beneficiary_id"), 
        inverseJoinColumns = @JoinColumn(name = "donor_id")
    )
    private List<Donor> donors;
	
	@JsonIgnoreProperties(value={"beneficiaries","created","id","updated"})
	@ManyToMany
    @JoinTable(
        name = "beneficiary_disabilities", 
        joinColumns = @JoinColumn(name = "beneficiary_id"), 
        inverseJoinColumns = @JoinColumn(name = "disability_id")
    )
    private List<Disability> disabilities;
	
	@JsonIgnoreProperties(value={"beneficiaries","created","id","updated","donors","institution","collaborators","supporters"})
	@ManyToOne
	@JoinColumn(name="country_iso")
	private Country country;

	@ManyToOne
	@JoinColumn(name="street_situation")
	private StreetSituation street_situation;

	public Beneficiary() {

	}

	public Beneficiary(
			String first_name,
			String last_name,
			String gender,
			Date date_of_birth,
			Integer height,
			Integer weight,
			String address,
//			Integer[] disability_ids,
//			Integer street_situation_id,
		    Country country,
			List<Organization> organizations
	) {

		this.firstName = first_name;
		this.lastName = last_name;
		this.gender = gender;
		this.dateOfBirth = date_of_birth;
		this.height = height;
		this.weight = weight;
		this.address = address;
		this.country = country;
		this.organizations = organizations;
//		this.street_situation = street_situation_id;
//		this.disabilities = disability_ids;
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
