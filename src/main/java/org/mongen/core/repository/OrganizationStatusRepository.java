package org.mongen.core.repository;

import org.mongen.core.models.OrganizationStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationStatusRepository extends CrudRepository<OrganizationStatus,Long>{
	List<OrganizationStatus> findAll();

	OrganizationStatus findByName(String name);
}
