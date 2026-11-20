package com.ad05.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="libro")
public class Libro {


	@Id
	@SequenceGenerator(name = "col_gen", sequenceName = "col_sqe",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen")
	private Long id;
	
	@Column(name="titulo")
	private String titulo;

	@Column(name="autor")
	private String autor;
	
	@Column(name="editorial")
	private String editorial;
	
	@Column(name="anoPublicacion")
	private int anoPublicacion;
	
	@ManyToOne
	@JoinColumn (name = "genero")
	private Genero genero;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getAnoPublicacion() {
		return anoPublicacion;
	}

	public void setAnoPublicacion(int anoPublicacion) {
		this.anoPublicacion = anoPublicacion;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public Libro (String titulo, String autor, String editorial, int anoPublicacion, Genero genero) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.anoPublicacion = anoPublicacion;
		this.genero = genero;
	}
	
	public Libro() {
		
	}
}


