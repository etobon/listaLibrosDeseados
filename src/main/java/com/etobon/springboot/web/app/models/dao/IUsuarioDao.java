package com.etobon.springboot.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.etobon.springboot.web.app.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
