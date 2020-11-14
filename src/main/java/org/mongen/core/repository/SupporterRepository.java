package org.mongen.core.repository;

import java.util.List;

import org.mongen.core.models.Supporter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupporterRepository extends CrudRepository<Supporter,Long>{
	List<Supporter> findAll();
}
