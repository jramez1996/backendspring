package com.tutorial.crudprocedure.controller;
import com.tutorial.crudprocedure.util.JwtUtil;
import com.tutorial.crudprocedure.entity.AuthRequest;
import com.tutorial.crudprocedure.bean.LoginResultDTO;
import com.tutorial.crudprocedure.bean.ResponseLogin;
import com.tutorial.crudprocedure.bean.TipoCambioBean;
import com.tutorial.crudprocedure.bean.LoginResultDTO;
import com.tutorial.crudprocedure.entity.Coche;
import com.tutorial.crudprocedure.entity.Moneda;
import com.tutorial.crudprocedure.entity.TipoCambio;
import com.tutorial.crudprocedure.entity.Usuario;
import com.tutorial.crudprocedure.service.AuthService;
import com.tutorial.crudprocedure.service.TipoCambioService;
import com.tutorial.crudprocedure.repository.MonedaRepository;
import com.tutorial.crudprocedure.repository.TipoCambioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/moneda")
public class MonedaController {
    private JwtUtil jwtUtil;

    @Autowired
    private MonedaRepository monedaRepository;
    @Autowired
    AuthService cocheService;
    @GetMapping("/obtenerMonedas")
    public List<Moneda>  obtenerMonedas(){
         return monedaRepository.obtenerMonedas();
    }

}
