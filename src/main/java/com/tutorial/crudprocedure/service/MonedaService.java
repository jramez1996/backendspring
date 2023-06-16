package com.tutorial.crudprocedure.service;

import com.tutorial.crudprocedure.entity.Coche;
import com.tutorial.crudprocedure.entity.Moneda;
import com.tutorial.crudprocedure.entity.Usuario;
import com.tutorial.crudprocedure.bean.LoginResultDTO;
import com.tutorial.crudprocedure.repository.CocheRepository;
import com.tutorial.crudprocedure.repository.MonedaRepository;
import com.tutorial.crudprocedure.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonedaService {

    @Autowired
    MonedaRepository monedaRepository;

    public List<Moneda> obtenerMonedas(){
        return monedaRepository.obtenerMonedas();
    }

}
