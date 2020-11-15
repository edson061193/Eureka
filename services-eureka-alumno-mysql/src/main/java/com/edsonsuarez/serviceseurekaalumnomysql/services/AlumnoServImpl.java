package com.edsonsuarez.serviceseurekaalumnomysql.services;

import com.edsonsuarez.serviceseurekaalumnomysql.Entity.AlumnoEntity;
import com.edsonsuarez.serviceseurekaalumnomysql.mapper.AlumnoMap;
import com.edsonsuarez.serviceseurekaalumnomysql.model.Alumno;
import com.edsonsuarez.serviceseurekaalumnomysql.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServImpl implements AlumnoServ{

   @Autowired
    private AlumnoRepository alumnoRepository;

    private AlumnoMap alumnoMap = new AlumnoMap();

    @Override
    public List<Alumno> findAll() {
        return alumnoMap.convert(alumnoRepository.findAll());
    }

    @Override
    public Alumno findById(Long id) {
        AlumnoEntity entity = alumnoRepository.findById(id).orElse(null);
        return alumnoMap.convertEntityModel(entity);
    }

    @Override
    public Alumno save(Alumno alumno) {
        AlumnoEntity entity = alumnoMap.convertModelEntity(alumno);
        alumnoRepository.save(entity);
        alumno.setId(entity.getId());
        return alumno;
    }

    @Override
    public boolean saveEdit(Alumno alumno) {
        try {
            AlumnoEntity entity = alumnoMap.convertModelEntity(alumno);
            alumnoRepository.save(entity);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {
       try {
           AlumnoEntity entity = alumnoRepository.findById(id).orElse(null);
            alumnoRepository.delete(entity);
            return true;
       }catch (Exception e){
           return false;
       }
    }
}
