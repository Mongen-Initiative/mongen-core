package org.mongen.core.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="street_situation")
@Data
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

}
