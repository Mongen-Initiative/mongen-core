package org.mongen.core.models.payloads;

import lombok.Data;

import java.util.Date;

@Data
public class BeneficiaryPayload {
	String first_name;
	String last_name;
	String gender;
	Date date_of_birth;
	Integer height;
	Integer weight;
	String address;
//	Integer[] disability_ids;
	String country_iso;
//	Integer street_situation_id;
//	Integer organization_id;
}
