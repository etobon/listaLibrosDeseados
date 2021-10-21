package com.etobon.springboot.web.app.models.service;

import java.util.List;

import com.etobon.springboot.web.app.models.entity.Libro;
import com.etobon.springboot.web.app.models.entity.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();
	public void save(Usuario usuario);
	public Usuario findById(Long id);
	public void delete(Long id);
	
	
	
}
