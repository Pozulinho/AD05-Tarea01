package com.ad05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	@GetMapping("/delete/{id}")
	public String borrarLibro(@PathVariable("id") Long id) {
		libroRepository.deleteById(id);
		return "redirect:/libros";
	}
	
	@GetMapping("/new")
	public String nuevoLibroForm(Model model) {
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
		model.addAttribute("libro", libroRepository.findById(id));
		model.addAttribute("generos", generoRepository.findAll());
		return "librosForm";
	}
}

