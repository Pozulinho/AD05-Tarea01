package com.ad05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ad05.repository.GeneroRepository;
import com.ad05.repository.LibroRepository;


@Controller
public class MainController {
	
	@Autowired
   	private LibroRepository libroRepository;
	@Autowired
   	private GeneroRepository generoRepository;
	
	@GetMapping ({"/"})
	public String inicio() {
		return "index";
	}
	
	@GetMapping ({"/libros"})
	public String getLibros(Model model) {
		model.addAttribute("libros", libroRepository.findAll());
		return "libros";
	}
	
	@GetMapping ({"/genero"})
	public String getTeams(Model model) {
		model.addAttribute("generos", generoRepository.findAll());
		return "genero";
	}

}
