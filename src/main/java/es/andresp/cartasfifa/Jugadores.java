/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.andresp.cartasfifa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "JUGADORES")
@NamedQueries({
    @NamedQuery(name = "Jugadores.findAll", query = "SELECT j FROM Jugadores j"),
    @NamedQuery(name = "Jugadores.findById", query = "SELECT j FROM Jugadores j WHERE j.id = :id"),
    @NamedQuery(name = "Jugadores.findByNombre", query = "SELECT j FROM Jugadores j WHERE j.nombre = :nombre"),
    @NamedQuery(name = "Jugadores.findByApellidos", query = "SELECT j FROM Jugadores j WHERE j.apellidos = :apellidos"),
    @NamedQuery(name = "Jugadores.findByFechaNacimiento", query = "SELECT j FROM Jugadores j WHERE j.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Jugadores.findByValoracion", query = "SELECT j FROM Jugadores j WHERE j.valoracion = :valoracion"),
    @NamedQuery(name = "Jugadores.findByPrecioCarta", query = "SELECT j FROM Jugadores j WHERE j.precioCarta = :precioCarta"),
    @NamedQuery(name = "Jugadores.findByRetirado", query = "SELECT j FROM Jugadores j WHERE j.retirado = :retirado"),
    @NamedQuery(name = "Jugadores.findByLiga", query = "SELECT j FROM Jugadores j WHERE j.liga = :liga"),
    @NamedQuery(name = "Jugadores.findByFoto", query = "SELECT j FROM Jugadores j WHERE j.foto = :foto")})
public class Jugadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "VALORACION")
    private Short valoracion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_CARTA")
    private BigDecimal precioCarta;
    @Column(name = "RETIRADO")
    private Boolean retirado;
    @Column(name = "LIGA")
    private String liga;
    @Column(name = "FOTO")
    private String foto;
    @JoinColumn(name = "NACIONALIDAD", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Nacionalidad nacionalidad;

    public Jugadores() {
    }

    public Jugadores(Integer id) {
        this.id = id;
    }

    public Jugadores(Integer id, String nombre, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Short getValoracion() {
        return valoracion;
    }

    public void setValoracion(Short valoracion) {
        this.valoracion = valoracion;
    }

    public BigDecimal getPrecioCarta() {
        return precioCarta;
    }

    public void setPrecioCarta(BigDecimal precioCarta) {
        this.precioCarta = precioCarta;
    }

    public Boolean getRetirado() {
        return retirado;
    }

    public void setRetirado(Boolean retirado) {
        this.retirado = retirado;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugadores)) {
            return false;
        }
        Jugadores other = (Jugadores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.andresp.cartasfifa.Jugadores[ id=" + id + " ]";
    }
    
}
