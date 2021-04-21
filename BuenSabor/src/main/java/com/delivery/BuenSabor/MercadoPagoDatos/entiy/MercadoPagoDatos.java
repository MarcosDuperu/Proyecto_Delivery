package com.delivery.BuenSabor.MercadoPagoDatos.entiy;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.delivery.BuenSabor.Pedido.entity.Pedido;

@Entity
@Table(name = "mercado_pago_datos")
public class MercadoPagoDatos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificadorPago;

	private Date fechaCreacion;

	private Date fechaAprobacion;

	private String fromaPago;

	private String metodoPago;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_domicilio")
	private Pedido pedido;

	public Long getIdentificadorPago() {
		return identificadorPago;
	}

	public void setIdentificadorPago(Long identificadorPago) {
		this.identificadorPago = identificadorPago;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	public String getFromaPago() {
		return fromaPago;
	}

	public void setFromaPago(String fromaPago) {
		this.fromaPago = fromaPago;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MercadoPagoDatos)) {
			return false;
		}
		MercadoPagoDatos c = (MercadoPagoDatos) obj;
		return this.identificadorPago != null && this.identificadorPago.equals(c.getIdentificadorPago());
	}

	@Override
	public String toString() {
		String obj = "ID-Pago:" + this.identificadorPago + "/ Fech-Creacion:" + this.fechaCreacion
				+ "/ Fecha Aprobacion:" + this.fechaAprobacion + "/ Forma pago:" + this.fromaPago + "/ Metodo Pago:"
				+ this.metodoPago;
		return obj;
	}

}
