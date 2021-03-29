package org.mongen.core.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="supporter")
@Data
public class Supporter implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 300)
	private String name;
	@Column(name="last_name", length = 300)
	private String lastName;
	@Column(updatable=false)
	private Date created;
	private Date updated;
	
	@ManyToOne
	@JoinColumn(name="country_iso")
	private Country countrySupporter;
	
	public Supporter() {
		
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
