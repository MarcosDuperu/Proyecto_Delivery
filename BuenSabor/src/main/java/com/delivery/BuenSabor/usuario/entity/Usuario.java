package com.delivery.BuenSabor.usuario.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.delivery.BuenSabor.cliente.entity.Cliente;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column(name = "usuario", unique = true)
	private String usuario;
	
	private String clave;
	
	private String rol;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_cliente")
	private Cliente cliente;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(!(obj instanceof Usuario)) {
			return false;
		}
		Usuario u = (Usuario) obj;
		return this.usuario !=null && this.usuario.equals(u.getUsuario());
	}

	@Override
	public String toString() {
		String obj = "Usuario: "+this.usuario + "/ clave: " + this.clave +
				"/ clave: " + this.clave;
		return obj;
	}
	
	
}
