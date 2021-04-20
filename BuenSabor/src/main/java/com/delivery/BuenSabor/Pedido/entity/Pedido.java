package com.delivery.BuenSabor.Pedido.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.delivery.BuenSabor.Factura.entity.Factura;
import com.delivery.BuenSabor.cliente.entity.Cliente;
import com.delivery.BuenSabor.domicilio.entity.Domicilio;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int estado;
	
	@Column(name = "horas_estimadas_fin")
	private Date horaEstimadaFin; // dataTime
	
	@Column(name = "tipo_envio")
	private int tipoEnvio;
	
	private double total;
	
	private Date fecha;

	// @OneToMany(cascade = CascadeType.ALL)
	// @JoinColumn(name = "fk_detallePedido")
	// private DetallePedido detallePedido[];
	// FALTANTE FALTA GET AND SETER
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_factura")
	private Factura factura;
	
	@ManyToOne
	@JoinColumn( name = "fk_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn( name = "fk_domicilio")
	private Domicilio domicilio;
	
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
	
	/*	@Override
	private boolean equals(Object obj) {
		if (this == obj) {
			return false;
			
		}
		Pedido p = (Pedido) obj;
		return this.id != null && this.id.equals(p.getId());
	}*/
	
	
	
	

}
