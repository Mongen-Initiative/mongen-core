package org.mongen.core.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="collaborator_type")
public class CollaboratorType implements Serializable{

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
	@OneToMany(mappedBy="type")
	private List<Collaborator> collaborators;

	public CollaboratorType() {
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
	public List<Collaborator> getCollaborators() {
		return collaborators;
	}
	public void setCollaborators(List<Collaborator> collaborators) {
		this.collaborators = collaborators;
	}
}

