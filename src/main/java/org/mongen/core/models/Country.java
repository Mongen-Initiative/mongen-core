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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="code")
	private Long id;
	private String name;
	@Column(name="continent_name")
	private String continentName;
	@Column(updatable=false)
	private Date created;
	private Date updated;
	
	@OneToMany(mappedBy="country")
	private List<Donor> donors;
	
	@OneToMany(mappedBy="countryColaborator")
	private List<Collaborator> colaborators;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinentName() {
		return continentName;
	}
	public void setContinentName(String continentName) {
		this.continentName = continentName;
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
	public List<Collaborator> getColaborators() {
		return colaborators;
	}
	public void setColaborators(List<Collaborator> colaborators) {
		this.colaborators = colaborators;
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
}
