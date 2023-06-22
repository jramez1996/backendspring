
package com.tutorial.crudprocedure.entity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "tipocambio2")
@EntityListeners(AuditingEntityListener.class)
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Transient
    private String origen;
    
    @Transient
    private String ultimousuariomodificacion;
    public String getUltimoUsuarioModificacion() {
        return ultimousuariomodificacion;
    }

    public void setUsuarioModificacion(String ultimousuariomodificacion) {
        this.ultimousuariomodificacion = ultimousuariomodificacion;
    }


     @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "monedaorigen", nullable = false)
    private Long monedaorigen ;
 
    @Column(name = "monedadestino", nullable = false)
    private Long monedaDestino ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monedaorigen", referencedColumnName = "id", insertable = false, updatable = false)
    private Moneda monedaDataOrigen ;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monedadestino", referencedColumnName = "id", insertable = false, updatable = false)
    private Moneda monedaDataDestino ;

    public void setMonedaData(Moneda monedaDataOrigen) {
        this.monedaDataOrigen = monedaDataOrigen;
    }

    public Moneda getMonedaDataOrigen() {
        return monedaDataOrigen;
    }

    public Moneda getMonedaDataDestino() {
        return monedaDataDestino;
    }

    public void setMonedaDataDestino(Moneda monedaDataDestino) {
        this.monedaDataDestino = monedaDataDestino;
    }
    //monedaDataDestino
    @Column(name = "idusuario", nullable = false)
    private int idusuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idusuario", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuario usuarioCreacion ;


    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Usuario usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }
    //usuarioCreacion
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
    public Long getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(Long monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

        public Long getMonedaOrigen() {
        return monedaorigen;
    }

    public void setMonedaOrigen(Long temp) {
        this.monedaorigen = temp;
    }

    //monedaorigen
}
