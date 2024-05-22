package com.ozgur.PortPriceTracker.repository;

import com.ozgur.PortPriceTracker.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
    @Override
    Optional<Country> findById(Long aLong);

    @Override
    List<Country> findAll();

    @Override
    <S extends Country> S save(S entity);

    @Override
    void delete(Country entity);

    Optional<Country> findByName(String name);
}
