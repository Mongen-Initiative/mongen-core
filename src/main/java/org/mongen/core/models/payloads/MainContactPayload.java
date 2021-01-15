package org.mongen.core.models.payloads;

import lombok.Data;

@Data
public class MainContactPayload {

	private String first_name;
	private String last_name;
	private String country_iso;
	private String type;
	private String photo_id_url;
	private String verification_selfie_url;
}