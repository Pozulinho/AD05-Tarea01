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
import com.ad05.repository.GeneroRepository;


@Controller
@RequestMapping ("/genero")
public class GeneroController {
	@Autowired
	GeneroRepository generoRepository;
		
		@PostMapping("/delete/{id}")
		public String borrarGenero(@PathVariable("id") Long id) {
			generoRepository.deleteById(id);
		return "redirect:/genero";
		}
		
		@GetMapping("/new")
		public String crearGeneroForm(Model model) {
			Genero genero = new Genero();
			model.addAttribute("generoForm", genero);
			return "generoForm";
		}
		
		@PostMapping("/new/submit")
		public String ejecutarGeneroForm(@ModelAttribute ("generoForm") Genero genero) {
			generoRepository.save(genero);
			return "redirect:/genero";
		}
		
		@GetMapping("/edit/{id}")
		public String editarGeneroForm(@PathVariable("id") Long id, Model model) {	
		    Genero genero = generoRepository.findById(id)
		            .orElseThrow(() -> new RuntimeException("Género no encontrado"));
			model.addAttribute("generoForm", genero);
			return "generoForm";
		}
}
