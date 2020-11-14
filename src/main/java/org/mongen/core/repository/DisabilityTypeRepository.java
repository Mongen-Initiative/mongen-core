package org.mongen.core.repository;

import java.util.List;

import org.mongen.core.models.DisabilityType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisabilityTypeRepository extends CrudRepository<DisabilityType,Long>{
	List<DisabilityType> findAll();
	
	DisabilityType findByName(String name);
}
