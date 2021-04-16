package com.delivery.BuenSabor.Pedido.entity;

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

import com.delivery.BuenSabor.DetallePedido.entity.DetallePedido;
import com.delivery.BuenSabor.Factura.entity.Factura;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	private Long id;
	@Column(name = "estado")
	private int estado;
	@Column(name = "horasEstimadasFin")
	private Date horaEstimadaFin; // dataTime
	@Column(name = "tipoEnvio")
	private int tipoEnvio;
	@Column(name = "total")
	private double total;
	@Column(name = "fecha")
	private Date fecha;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_detallePedido")
	private DetallePedido detallePedido[];

	


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_factura")
	private Factura factura;
	
	@PrePersist
	public void prePersist() {
		this.fecha = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getHoraEstimadaFin() {
		return horaEstimadaFin;
	}

	public void setHoraEstimadaFin(Date horaEstimadaFin) {
		this.horaEstimadaFin = horaEstimadaFin;
	}

	public int getTipoEnvio() {
		return tipoEnvio;
	}

	public void setTipoEnvio(int tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
	public DetallePedido[] getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(DetallePedido[] detallePedido) {
		this.detallePedido = detallePedido;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(!(obj instanceof Pedido)) {
			return false;
		}
		Pedido P = (Pedido) obj;
		return this.id !=null && this.id.equals(P.getId());
	}
	
	@Override
	public String toString() {
		String obj="ID:"+this.id+"/ Estado:"+ this.estado + "/ Hora Estimada:" + this.horaEstimadaFin + "/ Tipo de Envio:" + this.tipoEnvio +
				"/ Total:" + this.total + "/ Fecha:" + this.fecha;
		return obj;
	}

}
