package org.mongen.core.models.payloads;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MainContactPayload {
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
	@NotBlank
	private String photo_id_url;
}
