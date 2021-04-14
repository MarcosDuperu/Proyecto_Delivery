package com.delivery.BuenSabor.Factura.entity;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.delivery.BuenSabor.Pedido.entity.Pedido;

@Entity
@Table(name = "factura")
public class Factura {

	@Id
	private long id;
	@Column(name = "numero")
	private int numero;
	@Column(name = "montoDescuento")
	private double montoDescuento;
	@Column(name = "formaPago")
	private String formaPago;
	@Column(name = "numeroTarjeta")
	private String numTarjeta;
	@Column(name = "totalCosto")
	private double totalVenta;
	@Column(name = "totalCosto")
	private double totalCosto;
	@Column(name = "fecha")
	private Date fecha;

	// @OneToMany(cascade = cascadeType.ALL)
	// @JoinColumn(name = "fk_detalleFactura")
	// private DetalleFactura detallesFacturas[];

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_pedido")
	private Pedido pedido;

	// FALTANTES PREGUNTAR CUANDO ERA CON TRIANGULO LLENO
	// CREAR GET Y SET DE LO Q ESTA COMENADO ARRIBA FALTAN ESAS CLASES

	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getMontoDescuento() {
		return montoDescuento;
	}

	public void setMontoDescuento(double montoDescuento) {
		this.montoDescuento = montoDescuento;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public double getTotalCosto() {
		return totalCosto;
	}

	public void setTotalCosto(double totalCosto) {
		this.totalCosto = totalCosto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/*
	 * @Override private boolean equals(Object obj) { if (this == obj) { return
	 * false;
	 * 
	 * } Factura f = (Factura) obj; return this.id != null &&
	 * this.id.equals(f.getId()); }
	 */

}
