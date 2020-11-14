package org.mongen.core.repository;

import java.util.List;

import org.mongen.core.models.Institution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends CrudRepository<Institution,Long>{
	List<Institution> findAll();
}
