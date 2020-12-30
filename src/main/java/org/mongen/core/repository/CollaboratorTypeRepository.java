package org.mongen.core.repository;

import org.mongen.core.models.CollaboratorType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaboratorTypeRepository extends CrudRepository<CollaboratorType,Long>{
	List<CollaboratorType> findAll();

	CollaboratorType findByName(String name);
}
