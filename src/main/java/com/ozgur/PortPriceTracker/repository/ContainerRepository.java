package com.ozgur.PortPriceTracker.repository;

import com.ozgur.PortPriceTracker.entities.Container;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContainerRepository extends JpaRepository<Container,Long> {
    @Override
    Optional<Container> findById(Long aLong);

    @Override
    List<Container> findAll();
}
