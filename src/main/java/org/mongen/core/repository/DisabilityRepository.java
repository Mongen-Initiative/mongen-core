package org.mongen.core.repository;

import java.util.List;

import org.mongen.core.models.Disability;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisabilityRepository extends CrudRepository<Disability,Long>{
	List<Disability> findAll();
}
