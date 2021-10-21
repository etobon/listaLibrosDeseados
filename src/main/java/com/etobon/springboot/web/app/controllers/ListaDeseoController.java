package com.etobon.springboot.web.app.controllers;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.etobon.springboot.web.app.models.entity.Libro;
import com.etobon.springboot.web.app.models.entity.ListaDeseo;
import com.etobon.springboot.web.app.models.entity.Usuario;
import com.etobon.springboot.web.app.models.service.IGoogleBooksService;
import com.etobon.springboot.web.app.models.service.IUsuarioService;

@Controller
@RequestMapping("/listaDeseo")
@SessionAttributes("listaDeseo")
public class ListaDeseoController {

	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	private IGoogleBooksService googleBooksService;
	
	
	List<Libro> librosDesdeGoogle;
	
	
	//Metodo para desplegar la lista en la pagina
	@RequestMapping(value="/formListaDeseo/{userId}", method = RequestMethod.GET)
	public String crear(@PathVariable(name="userId") Long userId, Map<String, Object> model, RedirectAttributes flash) {
		
		Usuario usuario = usuarioService.findById(userId);
		
		if (usuario == null) {
			flash.addFlashAttribute("error", "El usuario no existe");
			return "redirect:/listarUsuarios";
		}
		
		ListaDeseo listaDeseo = new ListaDeseo();
		listaDeseo.setUsuario(usuario); // asociacion de lista deseo con usuario
		
		model.put("titulo", "Crear lista de deseos");
		model.put("listaDeseo", listaDeseo);
		
		return "listaDeseo/formListaDeseo";
	}

	@RequestMapping(value="/formListaDeseo", method = RequestMethod.POST)
	public String guardar(ListaDeseo listaDeseo, Model model) {

		model.addAttribute("titulo", "Crear lista de deseos");
		model.addAttribute("listaDeseo", listaDeseo);
		return "listaDeseo/formListaDeseo";
	}
	
	@RequestMapping(value="/verLibrosDesdeGoogleBooks", method = RequestMethod.POST)
	public String listarLibrosDesdeGoogle(ListaDeseo listaDeseo, Model model) {
		
		model.addAttribute("titulo", "Listado de Libros desde Google Books");
		model.addAttribute("listaDeseo", listaDeseo);
		
		return "listaDeseo/verLibrosDesdeGoogleBooks";
		
	}

	@RequestMapping(value="/verLibrosDesdeGoogleBooksFiltroAutor/{filtro}", method = RequestMethod.GET)
	public String listarLibrosDesdeGoogleFiltradosAutor(
			@PathVariable(name="filtro") String filtro, 
			Model model) {
		
		librosDesdeGoogle = googleBooksService.getByAuthor(filtro,0);
		
		model.addAttribute("titulo", "Listado de Libros desde Google Books");
		model.addAttribute("librosDesdeGoogle", librosDesdeGoogle);
		
		return "listaDeseo/verLibrosDesdeGoogleBooks";
		
	}
	
	@RequestMapping(value="/verLibrosDesdeGoogleBooksFiltroTitulo/{filtro}", method = RequestMethod.GET)
	public String listarLibrosDesdeGoogleFiltradosTitulo(
			@PathVariable(name="filtro") String filtro, 
			Model model) {
		
		librosDesdeGoogle = googleBooksService.getByTitle(filtro,0);
		
		model.addAttribute("titulo", "Listado de Libros desde Google Books");
		model.addAttribute("librosDesdeGoogle", librosDesdeGoogle);
		
		return "listaDeseo/verLibrosDesdeGoogleBooks";
		
	}
	
	@RequestMapping(value="/verLibrosDesdeGoogleBooksFiltroPublisher/{filtro}", method = RequestMethod.GET)
	public String listarLibrosDesdeGoogleFiltradosPublisher(
			@PathVariable(name="filtro") String filtro, 
			Model model) {
		
		librosDesdeGoogle = googleBooksService.getByPublisher(filtro,0);
		
		model.addAttribute("titulo", "Listado de Libros desde Google Books");
		model.addAttribute("librosDesdeGoogle", librosDesdeGoogle);
		
		return "listaDeseo/verLibrosDesdeGoogleBooks";
		
	}
	
	@RequestMapping(value="/verInfoLibro/{title}", method = RequestMethod.GET)
	public String verInfoLibro(
			@PathVariable(name="title") String title, Model model) {
		
		Libro libroEncontrado = new Libro();
		
		librosDesdeGoogle = googleBooksService.getByTitle(title,0);
		
		for (Libro libro : librosDesdeGoogle) {
			if (libro.getTitle().contains(title)) {
				libroEncontrado = libro;
				break;
			}
		}
		
		
		model.addAttribute("titulo", "Información de libros desde Google Books");
		
		model.addAttribute("libro", libroEncontrado);
		
		return "/listaDeseo/verInfoLibro";
		
	}
	
}
