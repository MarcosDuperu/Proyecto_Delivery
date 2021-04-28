package com.delivery.BuenSabor.Pedido.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.BuenSabor.Pedido.entity.Pedido;
import com.delivery.BuenSabor.Pedido.service.PedidoServiceImpl;


@RestController
@RequestMapping(path = "/api/v1/pedido")
public class PedidoController {
	
	@Autowired
	protected PedidoServiceImpl service;
	
	@GetMapping("/all")
	public ResponseEntity<?> allFacturas(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> byId(@PathVariable Long id){
		Optional<Pedido> p = service.findById(id);
		if(!p.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(p.get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Pedido pedido, @PathVariable Long id) {
		Optional<Pedido> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Pedido pedidoDb = o.get();
		pedidoDb.setCliente(pedido.getCliente());
		pedidoDb.setDetallesPedido(pedido.getDetallesPedido());
		pedidoDb.setDomicilio(pedido.getDomicilio());
		pedidoDb.setEstado(pedido.getEstado());
		pedidoDb.setFactura(pedido.getFactura());
		pedidoDb.setFecha(pedido.getFecha());
		pedidoDb.setHoraEstimadaFin(pedido.getHoraEstimadaFin());
		pedidoDb.setMercadoPagoDatos(pedido.getMercadoPagoDatos());
		pedidoDb.setTipoEnvio(pedido.getTipoEnvio());
		pedidoDb.setTotal(pedido.getTotal());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(pedidoDb));
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Pedido pedido) {
		Pedido facturaeDb = service.save(pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaeDb);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUno(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
