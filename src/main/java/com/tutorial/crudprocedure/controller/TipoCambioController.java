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
import com.tutorial.crudprocedure.entity.TipoCambioDto;
import com.tutorial.crudprocedure.entity.Usuario;
import com.tutorial.crudprocedure.service.AuthService;
import com.tutorial.crudprocedure.service.TipoCambioService;
import com.tutorial.crudprocedure.repository.CocheRepository;
import com.tutorial.crudprocedure.repository.MonedaRepository;
import com.tutorial.crudprocedure.repository.TipoCambioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tipoCambio")
public class TipoCambioController {
    @Autowired
    private JwtUtil jwtUtil;


    @Autowired
    private TipoCambioService tipoCambioService;
    @Autowired
    AuthService cocheService;
    @GetMapping("/listado")
    public ResponseEntity<?> listado(HttpServletRequest requestT){
        
        List<TipoCambio> res=tipoCambioService.listar();
        Map resspo=new HashMap<>();
        if(res!=null){
            resspo.put("status",true);
            resspo.put("data",res);
        }else{
            resspo.put("status",false);
            resspo.put("mensaje","El tipo de cambio ya se registro");
        }
        return new ResponseEntity(resspo, HttpStatus.CREATED);

    }
    


    @PostMapping("/nuevoTipoCambio")
    public ResponseEntity<?> saveTipoCambio(HttpServletRequest requestT,@RequestBody TipoCambioBean tip){
        TipoCambio tipDat=new TipoCambio();
        String header = requestT.getHeader("Authorization");
        String token = header.substring(7); // Eliminar el prefijo "Bearer " para obtener solo el token
        String datUser= jwtUtil.extractUsername(token);
        tipDat.setIdusuario(Integer.parseInt(datUser));
        tipDat.setIdUsuariomodificacion(Integer.parseInt(datUser));
        tipDat.setValor(tip.getValor());
        tipDat.setFechamodificacion(new Date());
        tipDat.setFecharegistro(new Date());
        tipDat.setMonedaDestino(tip.getMonedaDestino());
        tipDat.setMonedaOrigen(tip.getMonedaOrigen());
        TipoCambio res=tipoCambioService.save(tipDat);
        Map resspo=new HashMap<>();
        if(res!=null){
            resspo.put("status",true);
            resspo.put("mensaje","Se registro con exito");
        }else{
            resspo.put("status",false);
            resspo.put("mensaje","El tipo de cambio ya se registro");
        }
        return new ResponseEntity(resspo, HttpStatus.CREATED);

    }
    @PutMapping("/actualizarTipoCambio")
    public ResponseEntity<?> actualizarTipoCambio(HttpServletRequest requestT,@RequestBody TipoCambioBean tip){
        TipoCambio tipDat=new TipoCambio();
        String header = requestT.getHeader("Authorization");
        String token = header.substring(7); // Eliminar el prefijo "Bearer " para obtener solo el token
        String datUser= jwtUtil.extractUsername(token);
        tipDat.setId((Long.valueOf(tip.getId())));
        tipDat.setIdusuario(Integer.parseInt(datUser));
        tipDat.setIdUsuariomodificacion(Integer.parseInt(datUser));
        tipDat.setValor(tip.getValor());
        tipDat.setFechamodificacion(new Date());
        tipDat.setMonedaDestino(tip.getMonedaDestino());
        tipDat.setMonedaOrigen(tip.getMonedaOrigen());
        tipoCambioService.actualizarTipoCambio(tipDat);
        Map resspo=new HashMap<>();
        resspo.put("status",true);
        resspo.put("mensaje","Se actualizo con exito");

        return new ResponseEntity(resspo, HttpStatus.CREATED);
    }
  
}
