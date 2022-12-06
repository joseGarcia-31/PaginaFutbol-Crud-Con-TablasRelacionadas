package com.Club_Futbol.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Club_Futbol.app.entity.Entrenador;
import com.Club_Futbol.app.entity.Usuario;
import com.Club_Futbol.app.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/formUsuario")
	public String mostrarFormulario (Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formUsuario";
	}
	
	@PostMapping("/guardarUsuario")
	public String guardarUsuario (@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
	
		if(result.hasErrors()) {
			return "redirect:/formUsuario";
		}else {
			model.addAttribute("usuario", usuarioService.registrar(usuario));
		}
		
		return "redirect:/login";
	}
}
