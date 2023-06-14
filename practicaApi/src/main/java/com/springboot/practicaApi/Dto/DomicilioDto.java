package com.springboot.practicaApi.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.repository.query.parser.Part;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioDto {

    private String localidad;


    public DomicilioDto() {
    }

    public DomicilioDto(String localidad) {
        this.localidad = localidad;
    }


    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}


