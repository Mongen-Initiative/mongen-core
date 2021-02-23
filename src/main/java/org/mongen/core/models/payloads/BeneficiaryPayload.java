package org.mongen.core.models.payloads;

import lombok.Data;

import java.util.Date;

@Data
public class BeneficiaryPayload {
	private String first_name;
	private String last_name;
	private String gender;
	private Date date_of_birth;
	private Integer height;
	private Integer weight;
	private String address;
//	Integer[] disability_ids;
	private String country_iso;
//	private Integer street_situation_id;
	private Long organization_id;
}
