package com.edsonsuarez.serviceseurekaalumnomysql.services;

import com.edsonsuarez.serviceseurekaalumnomysql.model.Alumno;

import java.util.List;

public interface AlumnoServ {
    public List<Alumno> findAll();
    public Alumno findById(Long id);
    public Alumno save(Alumno alumno);
    public boolean saveEdit(Alumno alumno);
    public boolean delete(Long id);


}
