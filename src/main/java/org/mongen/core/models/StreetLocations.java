package org.mongen.core.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="street_locations")
@Data
public class StreetLocations implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String name;
	@Column(length = 2000)
	private String address;

	@Column(updatable=false)
	private Date created;
	private Date updated;

	public StreetLocations() {
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
