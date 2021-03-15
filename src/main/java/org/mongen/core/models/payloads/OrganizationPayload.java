package org.mongen.core.models.payloads;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
public class OrganizationPayload {

	@NotBlank
	private String name;
	@NotBlank
	private String seo_name;
	private String logo_url;
	@NotBlank
	private String address;
	@NotBlank
	private String social_network_url;
	@NotBlank
	private String story;
	private String tagline;
	@NotBlank
	private String mission;
	@NotBlank
	private String vision;
	@NotBlank
	private String country_iso;
	@NotNull
	private Long contact_id;
//	private ArrayList<SocialMediaPayload> social_media;
}
