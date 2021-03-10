package org.mongen.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="organization_status")
@Data
public class OrganizationStatus implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@JsonIgnore
	@Column(updatable=false)
	private Date created;
	@JsonIgnore
	private Date updated;

	@JsonIgnore
	@OneToMany(mappedBy="status")
	private List<Organization> organizations;

	public OrganizationStatus() {
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
