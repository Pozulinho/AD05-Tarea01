package com.ad05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ad05.domain.Genero;
import com.ad05.domain.Libro;
import com.ad05.repository.GeneroRepository;
import com.ad05.repository.LibroRepository;

@Controller
@RequestMapping ("/libros")
public class LibroController {
	@Autowired
	LibroRepository libroRepository;
	
	@Autowired
	GeneroRepository generoRepository;
	
	
	@PostMapping("/delete/{id}")
	public String borrarLibro(@PathVariable("id") Long id) {
		libroRepository.deleteById(id);
		return "redirect:/libros";
	}
	
	@GetMapping("/new")
	public String nuevoLibroForm(Model model) {
		
	    List<Genero> generos = generoRepository.findAll();

	    if (generos.isEmpty()) {
	        model.addAttribute("mensaje",
	            "Primero debes crear un género antes de añadir libros.");
	        return "librosForm";
	    }
		
		Libro libro = new Libro();
		model.addAttribute("libro", libro);
		model.addAttribute("generos", generoRepository.findAll());
		return "librosForm";
	}
	
	@PostMapping("/new/submit")
	public String submitNuevoLibroForm(@ModelAttribute Libro libro) {
		libroRepository.save(libro);
		return "redirect:/libros";
	}
	
	@GetMapping("/edit/{id}")
	public String editarLibroForm(@PathVariable("id") Long id, Model model) {
	    Libro libro = libroRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
		
		model.addAttribute("libro", libro);
		model.addAttribute("generos", generoRepository.findAll());
		return "librosForm";
	}
}

