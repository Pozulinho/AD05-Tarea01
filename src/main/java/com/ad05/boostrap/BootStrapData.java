/*package com.ad05.boostrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ad05.domain.Genero;
import com.ad05.domain.Libro;
import com.ad05.repository.GeneroRepository;
import com.ad05.repository.LibroRepository;

@Component
public class BootStrapData implements CommandLineRunner{
	@Autowired
	private GeneroRepository generoRepository;
	
	@Autowired
	private LibroRepository libroRepository;	

	public void run(String... arg0) throws Exception {
		Genero genero1 = new Genero("Fantasia");
		Genero genero2 = new Genero("Terror");
		Genero genero3 = new Genero("Policiaca");
		generoRepository.save(genero1);
		generoRepository.save(genero2);
		generoRepository.save(genero3);
		Genero genero01 = generoRepository.findById(1L).orElse(null);
		Libro libro1 = new Libro ("El señor de los Anillos", "J.R.R. Tolkien", "Alfaguara", 1938, genero01);
		Libro libro2 = new Libro ("Harry Potter", "J.K. Rowling", "Barco de Vapor", 1998, genero01);
		Genero genero02 = generoRepository.findById(2L).orElse(null);
		Libro libro3 = new Libro ("Pesadillas", "Paco Perez", "Terrorifica", 1988, genero02);
		Libro libro4 = new Libro ("Pajaros", "Maria Ferraro", "Terrorifica", 1992, genero02);
		Genero genero03 = generoRepository.findById(3L).orElse(null);
		Libro libro5 = new Libro ("Reina Roja", "Juan Gomez Jurado", "Alfaguara", 2023, genero03);
		libroRepository.save(libro1);
		libroRepository.save(libro2);
		libroRepository.save(libro3);
		libroRepository.save(libro4);
		libroRepository.save(libro5);
	}
}*/
