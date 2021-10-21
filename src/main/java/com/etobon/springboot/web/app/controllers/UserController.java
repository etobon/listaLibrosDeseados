package com.etobon.springboot.web.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.etobon.springboot.web.app.models.entity.Usuario;
import com.etobon.springboot.web.app.models.service.IUsuarioService;

@Controller
@SessionAttributes("usuario")
public class UserController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping(value={"/","/listarUsuarios"}, method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de Usuarios");
		model.addAttribute("usuarios", usuarioService.findAll());
		return "listarUsuarios";
	}
	
	
	@RequestMapping(value="/formUsuario", method=RequestMethod.GET)
	public String crear(Model model) {
		Usuario usuario = new Usuario();
		
		model.addAttribute("titulo", "Formulario de Usuarios");
		model.addAttribute("usuario", usuario);
		
		return "formUsuario";
	}
	
	
	@RequestMapping(value="/formUsuario", method = RequestMethod.POST)
	public String guardar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Usuarios");
			return "formUsuario";
		}
		
		String mensajeFlash = (usuario.getId() != null)?"Usuario actualizado con éxito":"Usuario creado con éxito";
		
		usuarioService.save(usuario);
		status.setComplete(); //elimina el objeto usuario de la session
		
		flash.addFlashAttribute("success", mensajeFlash);
		
		return "redirect:/listarUsuarios";
	}
	
	
	@RequestMapping(value="/formUsuario/{id}", method=RequestMethod.GET)
	public String editar(@PathVariable(value="id") Long id, Model model, RedirectAttributes flash) {
		
		Usuario usuario = null;
		
		if (id > 0) {
			usuario = usuarioService.findById(id);
			if (usuario == null) {
				flash.addFlashAttribute("error", "El id del usuario no existe");
				return "redirect:/listar";
			}
		}
		else {
			flash.addFlashAttribute("error", "El id del usuario no puede ser cero");
			return "redirect:/listar";
		}
		
		model.addAttribute("titulo", "Editar usuario");
		model.addAttribute("usuario", usuario);
		
		return "formUsuario";
	}
	
	@RequestMapping(value="/eliminarUsuario/{id}")
	public String eliminar(@PathVariable(value="id")Long id, RedirectAttributes flash) {
		
		if(id > 0) {
			usuarioService.delete(id);
			flash.addFlashAttribute("success", "Usuario eliminado con éxito");
		}
		
		return "redirect:/listarUsuarios";
	}
	
	
	@RequestMapping(value="/verInfoUsuario/{id}", method=RequestMethod.GET)
	public String verInfoUsuario(@PathVariable(name="id") Long id, Model model, RedirectAttributes flash) {
		
		Usuario usuario = usuarioService.findById(id);
		
		if (usuario == null) {
			flash.addFlashAttribute("error", "El usuario no existe ");
			return "redirect:/listarUsuarios";
		}
		
		model.addAttribute("titulo", "Información del Usuario");
		model.addAttribute("usuario", usuario);
		
		return "verInfoUsuario";
	}
	
	
	
}
