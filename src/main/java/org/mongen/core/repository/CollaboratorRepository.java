package org.mongen.core.repository;

import java.util.List;

import org.mongen.core.models.Collaborator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboratorRepository extends CrudRepository<Collaborator,Long>{
	List<Collaborator> findAll();
}
