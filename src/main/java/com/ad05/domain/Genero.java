package com.ad05.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="genero")
public class Genero {

	@Id
	@SequenceGenerator(name = "col_gen2", sequenceName = "col_sqe2",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen2")
	private Long id;
	
	@Column(name="genero")
	private String genero;	
	
	@OneToMany (mappedBy = "genero",cascade = CascadeType.ALL)
	List <Libro> libros = new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Genero(String genero) {
		this.genero = genero;

	}

	public Genero() {
	}
}
