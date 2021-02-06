package org.mongen.core.models.payloads;

import lombok.Data;

import java.util.ArrayList;

@Data
public class OrganizationPayload {

	private String name;
	private String seo_name;
	private String logo_url;
	private String address;
	private String social_network_url;
	private String mission;
	private String vision;
	private String country_iso;
	private Long contact_id;
//	private ArrayList<SocialMediaPayload> social_media;
}
