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
		
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
			generoRepository.deleteById(id);
		return "redirect:/genero";
		}
		
		@GetMapping("/new")
		public String initCreationForm(Model model) {
			Genero genero = new Genero();
			model.addAttribute("genero", genero);
			return "generoForm";
		}
		
		@PostMapping("/new/submit")
		public String processCreationForm(@ModelAttribute Genero genero) {
			generoRepository.save(genero);
			return "redirect:/genero";
		}
		
		@GetMapping("/edit/{id}")
		public String initEditForm(@PathVariable("id") Long id, Model model) {	
			model.addAttribute("genero", generoRepository.findById(id));
			return "generoForm";
		}
}
