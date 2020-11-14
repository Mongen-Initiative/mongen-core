package org.mongen.core.repository;

import java.util.List;

import org.mongen.core.models.Beneficiary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends CrudRepository<Beneficiary,Long>{
	List<Beneficiary> findAll();
}
