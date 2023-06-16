package com.tutorial.crudprocedure.bean;

import java.util.Optional;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TipoCambioBean {
    private String id;
    private Double valor;
    private int monedaDestino;
    private int   monedaOrigen ;

    public String getId() {
        return id;
    }  
    public void setId(String id) {
        this.id = id;
    }
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    public int  getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(int monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    /**
     * @return
     */
    public int  getMonedaDestino() {
        return this.monedaDestino;
    }

    /**
     * 
     */
    public void setMonedaDestino(int  monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    //monedaorigen
}
