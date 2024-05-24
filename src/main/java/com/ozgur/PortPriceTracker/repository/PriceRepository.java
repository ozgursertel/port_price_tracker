package com.ozgur.PortPriceTracker.repository;

import com.ozgur.PortPriceTracker.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price,Long> {
    @Override
    List<Price> findAll();

    @Override
    Optional<Price> findById(Long aLong);

    @Override
    <S extends Price> S save(S entity);

    @Override
    void delete(Price entity);

    @Query("SELECT p FROM Price p WHERE p.portOfLoading.id = :polId AND p.portOfDischarge.id = :podId")
    List<Price> findByPortOfLoadingAndPortOfDischarge(@Param("polId") long polId, @Param("podId") long podId);

    @Query("SELECT p FROM Price p WHERE p.carrier.id = :cId")
    List<Price> findAllByCarrierId(Long cId);
}
