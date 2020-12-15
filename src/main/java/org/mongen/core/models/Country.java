package org.mongen.core.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="country")
public class Country implements Serializable{
	@Id
	@Column(name="country_iso")
	private String countryISO;
	@Column(name="country_iso3")
	private String countryISO3;
	@Column(name="calling_code")
	private String callingCode;
	private String name;
	private Date created;
	private Date updated;
	
	@OneToMany(mappedBy="country")
	private List<Donor> donors;
	
	@OneToMany(mappedBy="countryCollaborator")
	private List<Collaborator> collaborators;
	
	@OneToMany(mappedBy="countrySupporter")
	private List<Supporter> supporters;
	
	@JsonIgnoreProperties("country")
	@OneToMany(mappedBy="country")
	private List<Beneficiary> beneficiaries;
	
	@OneToMany(mappedBy="countryInstitution")
	private List<Institution> institution;
	
	public Country() {
		
	}
	@PrePersist
    protected void onCreate(){
        this.created = new Date();
    }
	
	@PreUpdate
    protected void onUpdate(){
        this.updated = new Date();
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public List<Donor> getDonors() {
		return donors;
	}
	public void setDonors(List<Donor> donors) {
		this.donors = donors;
	}
	public List<Collaborator> getCollaborators() {
		return collaborators;
	}
	public void setCollaborators(List<Collaborator> collaborators) {
		this.collaborators = collaborators;
	}
	public List<Supporter> getSupporters() {
		return supporters;
	}
	public void setSupporters(List<Supporter> supporters) {
		this.supporters = supporters;
	}
	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}
	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}
	public List<Institution> getInstitution() {
		return institution;
	}
	public void setInstitution(List<Institution> institution) {
		this.institution = institution;
	}

	public String getCallingCode() {
		return callingCode;
	}

	public void setCallingCode(String callingCode) {
		this.callingCode = callingCode;
	}

	public String getCountryISO3() {
		return countryISO3;
	}

	public void setCountryISO3(String countryISO3) {
		this.countryISO3 = countryISO3;
	}

	public String getCountryISO() {
		return countryISO;
	}

	public void setCountryISO(String countryISO) {
		this.countryISO = countryISO;
	}
}
