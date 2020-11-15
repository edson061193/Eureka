package com.edsonsuarez.serviceseurekaalumnomysql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Alumno {
    private long id;
    private String apellidos;
    private String nombres;
    private String sexo;
    private int edad;

    public Alumno() {

    }
}
