package com.tutorial.crudprocedure.repository;

import com.tutorial.crudprocedure.entity.Coche;
import com.tutorial.crudprocedure.entity.TipoCambio;
import com.tutorial.crudprocedure.entity.TipoCambioDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, Long> {
    @Query(value = "{call buscartipocambioexistente(:p0,:p1)}", nativeQuery = true)
    List<TipoCambio> buscarTipoCambio(@Param("p0") int p0,@Param("p1") int p1);

    @Query(value="SELECT t.*,m.* FROM tipocambio2 as t inner join moneda m on m.id=t.monedaorigen ", nativeQuery = true)
    List<TipoCambio> listado();

}
