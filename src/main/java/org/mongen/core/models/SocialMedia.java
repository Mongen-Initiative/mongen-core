package org.mongen.core.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

// Not in use

//@Entity
//@Table(name="social_media")
//@Data
//public class SocialMedia implements Serializable{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	@Column(name="name")
//	private String name;
//	@Column(name="network_name")
//	private String networkName;
//	private String url;
//	@Column(updatable=false)
//	private Date created;
//	private Date updated;
//
//	@ManyToOne
//	@JoinColumn(name="organization_id")
//	private Organization organizationId;
//
//	public SocialMedia(){
//
//	}
//
//	@PrePersist
//    protected void onCreate(){
//        this.created = new Date();
//    }
//
//	@PreUpdate
//    protected void onUpdate(){
//        this.updated = new Date();
//    }
//
//}
