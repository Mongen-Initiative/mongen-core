package org.mongen.core.models.payloads;

import lombok.Data;

@Data
public class CollaboratorPayload{

	private String first_name;
	private String last_name;
	private String email;
	private String country_iso;
	private String type;
	private Long organization_id;
}
