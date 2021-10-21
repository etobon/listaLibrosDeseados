package com.etobon.springboot.web.app.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(@RequestParam(value="error", required = false) String error,
			@RequestParam(value="logout", required = false) String logout,
			Model model, Principal principal, RedirectAttributes flash) {
		
		if (principal != null) {
			
			flash.addFlashAttribute("info", "ya ha iniciado session");
			return "redirect:/";
		}
		
		if (error != null) {
			model.addAttribute("error", "Error de login: nombre de usuario o contraseña incorretos");
		}
		
		if (logout != null) {
			model.addAttribute("success", "Ha cerrado sesión con éxito");
		}
		
		return "login";
	}
}
