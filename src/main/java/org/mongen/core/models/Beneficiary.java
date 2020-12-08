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

@Entity
@Table(name="beneficiary")
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
	private Date birth;
	private Integer height;
	private Integer weight;
	private String address;
	
	@ApiModelProperty(hidden=true)
	@Column(updatable=false)
	private Date created;
	@ApiModelProperty(hidden=true)
	private Date updated;
	
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
	
	@JsonIgnoreProperties(value={"beneficiaries","created","id","updated","donors","institution","colaborators","supporters"})
	@ManyToOne
	@JoinColumn(name="country_code")
	private Country country;

	@ManyToOne
	@JoinColumn(name="street_situation")
	private StreetSituation street_situation;

	public Beneficiary() {

	}
	
	@PrePersist
    protected void onCreate(){
        this.created = new Date();
    }
	
	@PreUpdate
    protected void onUpdate(){
        this.updated = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<Institution> getInstitutions() {
		return institutions;
	}

	public void setInstitutions(List<Institution> institutions) {
		this.institutions = institutions;
	}

	public List<Disability> getDisabilities() {
		return disabilities;
	}

	public void setDisabilities(List<Disability> disabilities) {
		this.disabilities = disabilities;
	}

	public List<Donor> getDonors() {
		return donors;
	}

	public void setDonors(List<Donor> donors) {
		this.donors = donors;
	}

	public StreetSituation getStreet_situation() {
		return street_situation;
	}

	public void setStreet_situation(StreetSituation street_situation) {
		this.street_situation = street_situation;
	}
}
