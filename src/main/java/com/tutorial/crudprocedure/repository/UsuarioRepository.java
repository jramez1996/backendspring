package com.tutorial.crudprocedure.repository;

import com.tutorial.crudprocedure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tutorial.crudprocedure.entity.Usuario;
import com.tutorial.crudprocedure.bean.LoginResultDTO ;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "{call LoginProcedure(:p_username,:p_password)}", nativeQuery = true)
    int   login(@Param("p_username") String usuario,@Param("p_password") String pass);
}
