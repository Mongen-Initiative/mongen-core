package org.mongen.core.models.payloads;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class DonorPayload {
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String address;
	@NotBlank
	private String countryIso;
	@NotNull
	private Long organizationId;
}
