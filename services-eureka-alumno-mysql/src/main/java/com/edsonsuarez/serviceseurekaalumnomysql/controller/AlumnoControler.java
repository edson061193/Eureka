package com.edsonsuarez.serviceseurekaalumnomysql.controller;

import com.edsonsuarez.serviceseurekaalumnomysql.model.Alumno;
import com.edsonsuarez.serviceseurekaalumnomysql.services.AlumnoServImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/alumno")
public class AlumnoControler {

    @Autowired
    private AlumnoServImpl alumnoServ;

    @GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
    public String getHealthCheck()
    {
        return "{ \"todoOk\" : true }";
    }

    @HystrixCommand(fallbackMethod = "metodoAlternativo")
    @GetMapping(value = "/listar")
    public List<Alumno> listar(){
        return alumnoServ.findAll();
    }

    @HystrixCommand(fallbackMethod = "metodoAlternativo")
    @GetMapping(value = "/listar/{id}")
    public Alumno listarId(@PathVariable long id){
        return consultarId(id);
    }

    public Alumno consultarId(long id){
        return alumnoServ.findById(id);
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public Alumno eliminar(@PathVariable long id){
        Alumno alumno = consultarId(id);
        if(alumno!=null){
            alumnoServ.delete(alumno.getId());
            return alumno;
        }else {
          return  new Alumno();
        }
    }

    @PostMapping(value = "/registrar")
    public Alumno registrar(@Valid @RequestBody Alumno alumno){
        return alumnoServ.save(alumno);
    }

    @PutMapping(value = "/modificar")
    public Alumno modificar(@Valid @RequestBody Alumno alumno){
        if(alumnoServ.saveEdit(alumno)) {
            return alumno;
        } else {
            return new Alumno();
        }
    }

    public Alumno metodoAlternativo() {
        Alumno alumno = new Alumno();
        alumno.setApellidos("");
        alumno.setEdad(0);
        alumno.setId(0);
        alumno.setNombres("");
        alumno.setSexo("");
        return alumno;
    }
}
