package com.tutorial.crudprocedure.service;


import com.tutorial.crudprocedure.entity.AuthRequest;
import com.tutorial.crudprocedure.entity.Coche;
import com.tutorial.crudprocedure.entity.Usuario;
import com.tutorial.crudprocedure.bean.LoginResultDTO;
import com.tutorial.crudprocedure.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    UsuarioRepository usuarioRepository;
    public int login(AuthRequest authRequest){
       return usuarioRepository.login(authRequest.getUserName(), authRequest.getPassword());
    }
}
