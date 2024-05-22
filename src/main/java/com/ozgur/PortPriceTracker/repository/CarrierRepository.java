package com.ozgur.PortPriceTracker.repository;

import com.ozgur.PortPriceTracker.entities.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarrierRepository extends JpaRepository<Carrier,Long> {
    @Override
    List<Carrier> findAll();

    @Override
    Optional<Carrier> findById(Long aLong);

    @Override
    <S extends Carrier> S save(S entity);

    @Override
    void delete(Carrier entity);
}
