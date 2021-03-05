package org.mongen.core.models.payloads;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CollaboratorPayload{

	@NotBlank
	private String first_name;
	@NotBlank
	private String last_name;
	@NotBlank
	private String email;
	@NotBlank
	private String country_iso;
	@NotBlank
	private String type;
	@NotNull
	private Long organization_id;
}
