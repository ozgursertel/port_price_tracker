package com.ozgur.PortPriceTracker.repository;

import com.ozgur.PortPriceTracker.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    @Override
    List<City> findAll();
    @Override
    Optional<City> findById(Long aLong);

    @Override
    <S extends City> S save(S entity);

    @Override
    void delete(City entity);

    Optional<City> findByName(String name);
}
