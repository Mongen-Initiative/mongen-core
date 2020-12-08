package org.mongen.core.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="street_situation")
public class StreetSituation implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private boolean living_in_street;
    private Date start_date;
    private Date end_date;
	@Column(updatable=false)
	private Date created;
	private Date updated;

	@ManyToMany
    @JoinTable(
        name = "street_situation_street_locations",
        joinColumns = @JoinColumn(name = "street_situation_id"),
        inverseJoinColumns = @JoinColumn(name = "street_location_id")
    )
    private List<Beneficiary> street_locations;

	public StreetSituation() {
		
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

	public List<Beneficiary> getStreet_locations() {
		return street_locations;
	}

	public void setStreet_locations(List<Beneficiary> street_locations) {
		this.street_locations = street_locations;
	}

	public boolean isLiving_in_street() {
		return living_in_street;
	}

	public void setLiving_in_street(boolean living_in_street) {
		this.living_in_street = living_in_street;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
}
