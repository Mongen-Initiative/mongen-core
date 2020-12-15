package org.mongen.core.repository;

import java.util.List;
import java.util.Optional;

import org.mongen.core.models.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long>{
	List<Country> findAll();

	Optional<Country> findByCountryISO(String countryISO);

	void deleteByCountryISO(String countryISO);
}
