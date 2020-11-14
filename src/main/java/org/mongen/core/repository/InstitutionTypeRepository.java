package org.mongen.core.repository;

import java.util.List;

import org.mongen.core.models.InstitutionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionTypeRepository extends CrudRepository<InstitutionType,Long>{
	List<InstitutionType> findAll();
	
	InstitutionType findByType(String type);
}
