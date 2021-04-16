package com.delivery.BuenSabor.DetalleFactura.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.delivery.BuenSabor.Factura.entity.Factura;

import javax.persistence.CascadeType;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {
	
	@Id
	private Long id;
	
	private int cantidad;
	private double subtotal;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_factura")
	private Factura factura;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	public Factura getFactura() {
		return factura;
	}


	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(!(obj instanceof DetalleFactura)) {
			return false;
		}
		DetalleFactura DF = (DetalleFactura) obj;
		return this.id !=null && this.id.equals(DF.getId());
	}
	
	@Override
	public String toString() {
		String obj="ID:"+this.id+"/ Cantidad:"+ this.cantidad + "/ Subtotal:" + this.subtotal;
		return obj;
	}

}
