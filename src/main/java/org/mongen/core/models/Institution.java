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
@Table(name="institution")
@Data
public class Institution implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=300)
	private String name;
	@Column(updatable=false)
	private Date created;
	private Date updated;
	
	@ManyToMany
    @JoinTable(
        name = "beneficiary_institutions", 
        joinColumns = @JoinColumn(name = "institution_id"), 
        inverseJoinColumns = @JoinColumn(name = "beneficiary_id")
    )
    private List<Beneficiary> beneficiaries;
	
	@ManyToOne
	@JoinColumn(name="country_iso")
	private Country countryInstitution;
	
	@ManyToOne
	@JoinColumn(name="institution_type")
	private InstitutionType type;
	
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

}
