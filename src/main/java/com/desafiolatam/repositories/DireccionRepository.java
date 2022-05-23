package com.desafiolatam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiolatam.models.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
	
}
