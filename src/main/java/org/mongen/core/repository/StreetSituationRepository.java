package org.mongen.core.repository;

import org.mongen.core.models.StreetSituation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetSituationRepository extends CrudRepository<StreetSituation,Long>{
	List<StreetSituation> findAll();
}
