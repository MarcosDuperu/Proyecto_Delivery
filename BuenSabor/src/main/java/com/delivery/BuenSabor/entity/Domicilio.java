package com.delivery.BuenSabor.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "domicilio")
public class Domicilio {

	@Id
	private Long id;
	
	private int numero;
	
	private String localidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(!(obj instanceof Domicilio)) {
			return false;
		}
		Domicilio d = (Domicilio)obj;
		return this.id !=null && this.id.equals(d.getId());
	}

	@Override
	public String toString() {
		String obj="Id:" + this.id + "/ Localidad:" + this.localidad + "/ Numero:" + this.numero;
		return obj;
	}
	
	
}
