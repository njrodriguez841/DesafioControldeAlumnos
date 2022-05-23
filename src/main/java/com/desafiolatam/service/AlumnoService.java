package com.desafiolatam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiolatam.models.Alumno;
import com.desafiolatam.repositories.AlumnoRepository;

@Service
public class AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository;
	
	public void save(Alumno alumno) {
		alumnoRepository.save(alumno);
		
	}

	public List<Alumno> findAll() {
		return alumnoRepository.findAll();
	}

}
