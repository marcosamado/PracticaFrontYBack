package com.springboot.practicaApi.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String calle;
    private String localidad;
    private String provincia;

    public Domicilio(String calle, String localidad, String provincia) {
        this.calle = calle;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio() {
    }

    public Integer getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
