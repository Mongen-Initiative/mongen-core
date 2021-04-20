package org.mongen.core.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

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

@Entity
@Table(name="donor")
@Data
public class Donor implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name", length = 300)
	private String firstName;
	@Column(name="last_name", length = 300)
	private String lastName;
	@Column(length = 2000)
	private String address;
	@Column(updatable=false)
	private Date created;
	private Date updated;
	
	@ManyToOne
	@JoinColumn(name="country_iso")
	private Country country;
	
	@ManyToMany
    @JoinTable(
        name = "beneficiary_donors", 
        joinColumns = @JoinColumn(name = "donor_id"), 
        inverseJoinColumns = @JoinColumn(name = "beneficiary_id")
    )
    private List<Beneficiary> beneficiaries;

	@JsonIgnoreProperties(value={"donors","beneficiaries", "collaborators", "created","id","updated","country"})
	@ManyToMany
	@JoinTable(
			name = "organization_donors",
			joinColumns = @JoinColumn(name = "donor_id"),
			inverseJoinColumns = @JoinColumn(name = "organization_id")
	)
	private List<Organization> organizations;
	
	public Donor(){
		
	}

	public Donor(String firstName, String lastName, String address, Country country, List<Organization> organizations){
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.country = country;
		this.organizations = organizations;
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
