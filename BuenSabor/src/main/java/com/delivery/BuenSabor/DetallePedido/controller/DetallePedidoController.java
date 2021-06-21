package com.delivery.BuenSabor.DetallePedido.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.BuenSabor.DetallePedido.service.DetallePedidoServiceImpl;
import com.delivery.BuenSabor.DetallePedido.entity.DetallePedido;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/detallepedido")
public class DetallePedidoController {
	
	@Autowired
	protected DetallePedidoServiceImpl service;

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_COCINERO') or hasRole('ROLE_CAJERO')")
	@GetMapping("/all")
	public ResponseEntity<?> allDetalle(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_COCINERO') or hasRole('ROLE_CAJERO')")
	@GetMapping("/{id}")
	public ResponseEntity<?> byId(@PathVariable Long id){
		Optional<DetallePedido> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_COCINERO') or hasRole('ROLE_CAJERO')")
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody DetallePedido detalle, @PathVariable Long id) {
		Optional<DetallePedido> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		DetallePedido detalleDb = o.get();
		detalleDb.setArticuloInsumo(detalle.getArticuloInsumo());
		detalleDb.setArticuloMfact(detalle.getArticuloMfact());
		detalleDb.setCantidad(detalle.getCantidad());
		detalleDb.setSubtotal(detalle.getSubtotal());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(detalleDb));
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_COCINERO') or hasRole('ROLE_CAJERO')")
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody DetallePedido detalle_pedido) {
		DetallePedido detallePedidodb = service.save(detalle_pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(detallePedidodb);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_COCINERO') or hasRole('ROLE_CAJERO')")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUno(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
