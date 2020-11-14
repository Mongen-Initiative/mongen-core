package org.mongen.core.repository;

import java.util.List;

import org.mongen.core.models.Donor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends CrudRepository<Donor,Long>{
	List<Donor> findAll();
}
