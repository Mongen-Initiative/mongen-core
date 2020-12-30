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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name="country")
@Data
public class Country implements Serializable{
	@Id
	@Column(name="country_iso")
	private String countryISO;
	@Column(name="country_iso3")
	private String countryISO3;
	@Column(name="calling_code")
	private String callingCode;
	private String name;
	@JsonIgnore
	@ApiModelProperty(hidden=true)
	@Column(updatable=false)
	private Date created;
	@JsonIgnore
	@ApiModelProperty(hidden=true)
	private Date updated;

	@JsonIgnore
	@OneToMany(mappedBy="country")
	private List<Donor> donors;

	@JsonIgnore
	@OneToMany(mappedBy="countryCollaborator")
	private List<Collaborator> collaborators;

	@JsonIgnore
	@OneToMany(mappedBy="countrySupporter")
	private List<Supporter> supporters;

	@JsonIgnore
	@JsonIgnoreProperties("country")
	@OneToMany(mappedBy="country")
	private List<Beneficiary> beneficiaries;

	@JsonIgnore
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

}
