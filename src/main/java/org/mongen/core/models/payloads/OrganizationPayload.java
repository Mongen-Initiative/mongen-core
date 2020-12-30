package org.mongen.core.models.payloads;

import lombok.Data;

@Data
public class OrganizationPayload {

	private String name;
	private String address;
	private String mission;
	private String vision;
	private String country_iso;
	private Long contact_id;

}
