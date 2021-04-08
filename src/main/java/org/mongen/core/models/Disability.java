package org.mongen.core.models;

import lombok.Data;

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

@Entity
@Table(name="disability")
@Data
public class Disability implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=300)
	private String name;
	@Column(length=2000)
	private String description;
	@Column(updatable=false)
	private Date created;
	private Date updated;
	
	@ManyToMany
    @JoinTable(
        name = "beneficiary_disabilities", 
        joinColumns = @JoinColumn(name = "disability_id"), 
        inverseJoinColumns = @JoinColumn(name = "beneficiary_id")
    )
    private List<Beneficiary> beneficiaries;
	
	@ManyToOne
	@JoinColumn(name="type")
	private DisabilityType type;
	
	public Disability() {
		
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
