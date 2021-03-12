package org.mongen.core.repository;

import org.mongen.core.models.Organization;
import org.mongen.core.models.OrganizationStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization,Long>{
	List<Organization> findAll();

	Organization findBySeoName(String SeoName);

	List<Organization> findByStatusIs(OrganizationStatus status);
}
