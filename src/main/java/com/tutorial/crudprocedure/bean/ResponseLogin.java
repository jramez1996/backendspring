package com.tutorial.crudprocedure.bean;
public class ResponseLogin {
//    private String token;
    private String token;
    private int id;
    private String nombreCompletos;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public String getNombreCompletos() {
        return this.nombreCompletos;
    }

    public void setnombreCompletos(String nombreCompletos) {
        this.nombreCompletos = nombreCompletos;
    }



    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

