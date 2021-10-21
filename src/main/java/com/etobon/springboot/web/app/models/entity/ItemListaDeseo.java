package com.etobon.springboot.web.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="listas_deseos_items")
public class ItemListaDeseo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer cantidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Libro libro;

	public ItemListaDeseo() {
		// TODO Auto-generated constructor stub
	}

	public ItemListaDeseo(Long id, Integer cantidad) {
		this.id = id;
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
	public Integer calcularTotal() {
		return cantidad;
	}
	
	@Override
	public String toString() {
		return "ItemListaDeseo [id=" + id + ", cantidad=" + cantidad + "]";
	}


	private static final long serialVersionUID = 1L;

}
