package com.etobon.springboot.web.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="listas_deseos")
public class ListaDeseo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	@Temporal(TemporalType.DATE)
	@Column(name="create_at")
	private Date createAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="lista_deseo_id")
	private List<ItemListaDeseo> items;
	
	
	
	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}
	
	public ListaDeseo() {
		items = new ArrayList<ItemListaDeseo>();	
	}

	

	public ListaDeseo(Long id, String nombre, String descripcion, Date createAt, Usuario usuario,
			List<ItemListaDeseo> items) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.createAt = createAt;
		this.usuario = usuario;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	public List<ItemListaDeseo> getItems() {
		return items;
	}

	public void setItems(List<ItemListaDeseo> items) {
		this.items = items;
	}

	


	@Override
	public String toString() {
		return "ListaDeseo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", createAt=" + createAt
				+ ", usuario=" + usuario + ", items=" + items + "]";
	}


	public void addItemListaDeseo(ItemListaDeseo item) {
		items.add(item);
	}

	private static final long serialVersionUID = 1L;
	
	
	
	
}
