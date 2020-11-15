package com.edsonsuarez.serviceseurekaalumnomysql.mapper;

import com.edsonsuarez.serviceseurekaalumnomysql.Entity.AlumnoEntity;
import com.edsonsuarez.serviceseurekaalumnomysql.model.Alumno;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

public class AlumnoMap {

    ModelMapper modelMapper = new ModelMapper();

    public List<Alumno> convert(List<AlumnoEntity> entityList){
        return  entityList.stream().map(alumno -> modelMapper.map(alumno, Alumno.class)).collect(Collectors.toList());
    }

    public AlumnoEntity convertModelEntity(Alumno model) {
        return modelMapper.map(model,AlumnoEntity.class);
    }

    public Alumno convertEntityModel(AlumnoEntity entity) {
        return modelMapper.map(entity,Alumno.class);
    }
}
