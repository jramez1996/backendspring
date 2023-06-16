package com.tutorial.crudprocedure.bean;
public class LoginResultDTO  {
    public LoginResultDTO(){
        
    }
    private int id;
    private int loginResult;
    private String nombreCompletos;
        public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getLoginResult() {
        return this.loginResult;
    }

    public void setLoginResult(int loginResult) {
        this.loginResult = loginResult;
    }


    public String getNombreCompletos() {
        return this.nombreCompletos;
    }

    public void setnombreCompletos(String nombreCompletos) {
        this.nombreCompletos = nombreCompletos;
    }
}

