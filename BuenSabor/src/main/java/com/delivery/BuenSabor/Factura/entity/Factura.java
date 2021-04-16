package com.delivery.BuenSabor.Factura.entity;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.delivery.BuenSabor.DetalleFactura.entity.DetalleFactura;
import com.delivery.BuenSabor.Pedido.entity.Pedido;

@Entity
@Table(name = "factura")
public class Factura {

	@Id
	private Long id;
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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_detalleFactura")
	private DetalleFactura detallesFacturas[];

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_pedido")
	private Pedido pedido;

	// FALTANTES PREGUNTAR CUANDO ERA CON TRIANGULO LLENO
	// CREAR GET Y SET DE LO Q ESTA COMENADO ARRIBA FALTAN ESAS CLASES

	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}

	public DetalleFactura[] getDetallesFacturas() {
		return detallesFacturas;
	}

	public void setDetallesFacturas(DetalleFactura[] detallesFacturas) {
		this.detallesFacturas = detallesFacturas;
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

	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(!(obj instanceof Factura)) {
			return false;
		}
		Factura F = (Factura) obj;
		return this.id !=null && this.id.equals(F.getId());
	}
	
	@Override
	public String toString() {
		String obj="ID:"+this.id+"/ Numero:"+ this.numero + "/ Monto de Descuento:" + this.montoDescuento + "/ Forma de Pago:" + this.formaPago + 
				"/ Numero de Tarjeta:" + this.numTarjeta + " / Total Venta:" + this.totalVenta + "/ Total Costo:" + this.totalCosto  + "/ Fecha:"+
				this.fecha;
		return obj;
	}

}
