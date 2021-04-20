package com.delivery.BuenSabor.DetalleFactura.controller;


import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.BuenSabor.DetalleFactura.service.DetalleFacturaServiceImpl;
import com.delivery.BuenSabor.DetalleFactura.entity.DetalleFactura;

@RestController
@RequestMapping(path = "/api/v1/detallefactura")
public class DetalleFacturaController {
	
	protected DetalleFacturaServiceImpl service;

	@GetMapping("/all")
	public ResponseEntity<?> allCliente(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> byId(@PathVariable Long id){
		Optional<DetalleFactura> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody DetalleFactura detalle_factura) {
		DetalleFactura detalleFacturadb = service.save(detalle_factura);
		return ResponseEntity.status(HttpStatus.CREATED).body(detalleFacturadb);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUno(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
