package com.delivery.BuenSabor.cliente.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.delivery.BuenSabor.domicilio.entity.Domicilio;
import com.delivery.BuenSabor.usuario.entity.Usuario;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private Long telefono;
	
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_domicilio")
	private Domicilio domicilio;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_usuario")
	private Usuario usuario;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(!(obj instanceof Cliente)) {
			return false;
		}
		Cliente c = (Cliente) obj;
		return this.id !=null && this.id.equals(c.getId());
	}

	@Override
	public String toString() {
		String obj="ID:"+this.id+"/ Nombre:"+ this.nombre + "/ Apellido:" + this.apellido + "/ Telefono:"
				+ this.telefono + "/ Email:" + this.email;
		return obj;
	}
	
	
	
}
