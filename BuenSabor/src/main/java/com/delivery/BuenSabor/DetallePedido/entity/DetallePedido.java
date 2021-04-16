package com.delivery.BuenSabor.DetallePedido.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.delivery.BuenSabor.Pedido.entity.Pedido;

import javax.persistence.CascadeType;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {
	
	@Id
	private Long id;
	
	private int cantidad;
	private double subtotal;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_pedido")
	private Pedido pedido;


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


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(!(obj instanceof DetallePedido)) {
			return false;
		}
		DetallePedido DP = (DetallePedido) obj;
		return this.id !=null && this.id.equals(DP.getId());
	}
	
	@Override
	public String toString() {
		String obj="ID:"+this.id+"/ Cantidad:"+ this.cantidad + "/ Subtotal:" + this.subtotal;
		return obj;
	}

}
