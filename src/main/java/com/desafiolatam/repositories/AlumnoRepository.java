package com.desafiolatam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiolatam.models.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
