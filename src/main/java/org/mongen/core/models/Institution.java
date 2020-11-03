package org.mongen.core.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="institution")
public class Institution {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Column(updatable=false)
	private Date created;
	private Date updated;
	
	@ManyToOne
	@JoinColumn(name="country_code")
	private Country countryInstitution;
	
	public Institution() {
		
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

	public Country getCountryInstitution() {
		return countryInstitution;
	}

	public void setCountryInstitution(Country countryInstitution) {
		this.countryInstitution = countryInstitution;
	}
	
}
