package com.edsonsuarez.serviceseurekaalumnomysql.repository;

import com.edsonsuarez.serviceseurekaalumnomysql.Entity.AlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoEntity,Serializable> {

}
