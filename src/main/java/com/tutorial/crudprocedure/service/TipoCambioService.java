package com.tutorial.crudprocedure.service;
import com.tutorial.crudprocedure.entity.*;
import com.tutorial.crudprocedure.entity.TipoCambio;
import com.tutorial.crudprocedure.entity.TipoCambioDto;
import com.tutorial.crudprocedure.repository.TipoCambioRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.tutorial.crudprocedure.repository.MonedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TipoCambioService {
    @Autowired
    MonedaRepository monedaRepository;

    @Autowired
    TipoCambioRepository tipoCambioRepository;
    private TipoCambio entidadExistente;
    public List<TipoCambio> listar(){
        List<Moneda> datoss=monedaRepository.obtenerMonedas();
        List<TipoCambio> entidadExistenteBus= tipoCambioRepository.listado();
        if(entidadExistenteBus.size()>0){
           
            for(TipoCambio item : entidadExistenteBus) {
                List<Moneda> filteredUsers = datoss.stream()
                .filter(mod -> mod.getId() ==item.getMonedaOrigen())
                .collect(Collectors.toList());
                List<Moneda> monedaDestinos = datoss.stream()
                .filter(mod -> mod.getId() ==item.getMonedaDestino())
                .collect(Collectors.toList());

                if(filteredUsers.size()>0){
                    item.setOrigen(filteredUsers.get(0).getNombre());

                }
                if(monedaDestinos.size()>0){
                    item.setStrMonedaDestino(monedaDestinos.get(0).getNombre());

                }
            }

        }
        return entidadExistenteBus;

    }
    
   
    public TipoCambio save(TipoCambio ent){
        List<TipoCambio> entidadExistenteBus= tipoCambioRepository.buscarTipoCambio(ent.getMonedaOrigen(), ent.getMonedaDestino());
        TipoCambio resTipoCambioRes=new TipoCambio();
        resTipoCambioRes.setId(Long.valueOf(1));
        if(entidadExistenteBus==null){
            tipoCambioRepository.save(ent);

            return resTipoCambioRes;
        }
        if(entidadExistenteBus.size()==0){
            tipoCambioRepository.save(ent);
            return resTipoCambioRes;
        }
        return null;

    }
    
    public void actualizarTipoCambio(TipoCambio ent){
        System.out.println("ent.getId():"+ent.getId());
        entidadExistente = tipoCambioRepository.findById(ent.getId()).orElse(null);
        System.out.println("ent.entidadExistente():"+entidadExistente);
        if(entidadExistente!=null){
            entidadExistente.setValor(ent.getValor());
            entidadExistente.setFecharegistro(entidadExistente.getFecharegistro());
            entidadExistente.setFechamodificacion(new Date());
            entidadExistente.setIdUsuariomodificacion(ent.getIdUsuariomodificacion());
            entidadExistente.setId(entidadExistente.getId());
            entidadExistente.setIdUsuariomodificacion(entidadExistente.getIdUsuariomodificacion());
            entidadExistente.setIdusuario(entidadExistente.getIdusuario());
            tipoCambioRepository.save(entidadExistente);
        }
    }
}
