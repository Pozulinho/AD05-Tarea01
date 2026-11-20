package com.ad05.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ad05.domain.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{
	
}
