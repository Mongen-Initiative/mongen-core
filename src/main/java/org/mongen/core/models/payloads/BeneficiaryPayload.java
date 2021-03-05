package org.mongen.core.models.payloads;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class BeneficiaryPayload {
	@NotBlank
	private String first_name;
	@NotBlank
	private String last_name;
	@NotBlank
	private String gender;
	@NotBlank
	private Date date_of_birth;
	@NotBlank
	private Integer height;
	@NotBlank
	private Integer weight;
	@NotBlank
	private String address;
//	Integer[] disability_ids;
	@NotBlank
	private String country_iso;
//	private Integer street_situation_id;
	@NotNull
	private Long organization_id;
}
