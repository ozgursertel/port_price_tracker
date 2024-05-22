package com.ozgur.PortPriceTracker.repository;

import com.ozgur.PortPriceTracker.entities.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortRepository extends JpaRepository<Port,Long> {
    @Override
    List<Port> findAll();
    @Override
    Optional<Port> findById(Long aLong);

    @Override
    <S extends Port> S save(S entity);

    @Override
    void delete(Port entity);

    Optional<Port> findByName(String name);

}
