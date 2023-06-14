package com.springboot.practicaApi.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springboot.practicaApi.Entity.Domicilio;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDto {

    private Integer id;
    private String nombre;
    private String apellido;

    private DomicilioDto domicilio;


    public UsuarioDto() {
    }

    public UsuarioDto(Integer id, String nombre, String apellido,DomicilioDto domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
    }

    public DomicilioDto getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(DomicilioDto domicilio) {
        this.domicilio = domicilio;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}


