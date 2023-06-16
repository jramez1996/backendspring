package com.tutorial.crudprocedure.repository;

import com.tutorial.crudprocedure.entity.Coche;
import com.tutorial.crudprocedure.entity.Moneda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Long> {

    @Query(value = "SELECT * FROM moneda;", nativeQuery = true)
    List<Moneda> obtenerMonedas();

}
