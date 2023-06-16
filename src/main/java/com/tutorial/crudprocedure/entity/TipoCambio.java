
package com.tutorial.crudprocedure.entity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "tipocambio")
@EntityListeners(AuditingEntityListener.class)
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Transient
    private String origen;
    
    @Transient
    private String strmonedadestino;
    public String getStrMonedaDestino() {
        return strmonedadestino;
    }

    public void setStrMonedaDestino(String strmonedadestino) {
     
        this.strmonedadestino = strmonedadestino;
    }
    @Transient
    private String ultimousuariomodificacion;
    public String getUltimoUsuarioModificacion() {
        return ultimousuariomodificacion;
    }

    public void setUsuarioModificacion(String ultimousuariomodificacion) {
        this.ultimousuariomodificacion = ultimousuariomodificacion;
    }

    @Transient
    private String usuariocreacion;
    public String getUsuarioCreacion() {
        return usuariocreacion;
    }

    public void setUsuarioCreacion(String usuariocreacion) {
        this.usuariocreacion = usuariocreacion;
    }
    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "monedaorigen", nullable = false)
    private int monedaorigen ;
 
    @Column(name = "monedadestino", nullable = false)
    private int monedaDestino ;

    @Column(name = "idusuario", nullable = false)
    private int idusuario;
    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    @Column(name = "idusuariomodificacion", nullable = true)
    private int usuariomodificacion;



    @Column(name = "fecharegistro", nullable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fecharegistro;



    @Column(name = "fechamodificacion", nullable =true ,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fechamodificacion;


    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
   
    public int getIdUsuariomodificacion() {
        return usuariomodificacion;
    }

    public void setIdUsuariomodificacion(int usuariomodificacion) {
        this.usuariomodificacion = usuariomodificacion;
    }
    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }
    public int getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(int monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

        public int getMonedaOrigen() {
        return monedaorigen;
    }

    public void setMonedaOrigen(int temp) {
        this.monedaorigen = temp;
    }

    //monedaorigen
}
