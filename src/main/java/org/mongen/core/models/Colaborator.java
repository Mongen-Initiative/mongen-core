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
@Table(name="colaborator")
public class Colaborator implements java.io.Serializable{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@Column(name="last_name")
	private String lastName;
	@Column(updatable=false)
	private Date created;
	private Date updated;
	
	@ManyToOne
	@JoinColumn(name="country_code")
	private Country countryColaborator;
	
	public Colaborator() {
		
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public Country getCountryColaborator() {
		return countryColaborator;
	}
	public void setCountryColaborator(Country countryColaborator) {
		this.countryColaborator = countryColaborator;
	}
}
