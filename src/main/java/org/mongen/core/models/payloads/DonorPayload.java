package org.mongen.core.models.payloads;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class DonorPayload {
	@NotBlank
	private String first_name;
	@NotBlank
	private String last_name;
	@NotBlank
	private String address;
	@NotBlank
	private String country_iso;
	@NotNull
	private Long organization_id;
}
