package org.mongen.core.repository;

import org.mongen.core.models.StreetLocations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetLocationsRepository extends CrudRepository<StreetLocations,Long>{
	List<StreetLocations> findAll();
}
