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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="genero")
public class Genero {
	@Id
	@SequenceGenerator(name = "col_gen2", sequenceName = "col_sqe2",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen2")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;	
	
	@OneToMany (mappedBy = "genero",cascade = CascadeType.ALL)
	List <Libro> libros = new ArrayList<>();

	public Genero(String nombre) {
		this.nombre = nombre;

	}

	public Genero() {
	}
}
