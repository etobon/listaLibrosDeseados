package com.etobon.springboot.web.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ListaDeseo> listasDeseos;

	@PrePersist
	public void prePersist() {
		createAt = new Date();
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Long id, String username, String password, Date createAt, List<ListaDeseo> listasDeseos) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.createAt = createAt;
		this.listasDeseos = listasDeseos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", createAt=" + createAt
				+ ", listasDeseos=" + listasDeseos + "]";
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public List<ListaDeseo> getListasDeseos() {
		return listasDeseos;
	}

	public void setListasDeseos(List<ListaDeseo> listasDeseos) {
		this.listasDeseos = listasDeseos;
	}

	private static final long serialVersionUID = 1L;

}
