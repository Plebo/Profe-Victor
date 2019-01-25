/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "users")
public class User {
	@Id
	private Long id;
	
	@Column(name = "nombre")
	@NotEmpty
	private String nombre;
	
	@Column(name = "correo")
	@NotEmpty
	private String correo;
	
	@Column(name = "password")
	@NotEmpty
	private String password;
	
	@Column(name = "activo")
	@NotEmpty
	private int activo;
	
	@Column(name = "codigoPostal")
	@NotEmpty
	private String codigoPostal;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", password=" + password + ", activo=" + activo + ", codigoPostal=" + codigoPostal + '}';
	}

}
