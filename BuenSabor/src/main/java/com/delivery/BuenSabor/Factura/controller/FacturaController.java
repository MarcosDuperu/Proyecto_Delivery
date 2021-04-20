package com.delivery.BuenSabor.Factura.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.BuenSabor.Factura.entity.Factura;
import com.delivery.BuenSabor.Factura.service.FacturaServiceImpl;

@RestController
@RequestMapping(path = "/api/v1/factura")
public class FacturaController {

	@Autowired
	protected FacturaServiceImpl service;
	
	@GetMapping("/all")
	public ResponseEntity<?> allFacturas(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> byId(@PathVariable Long id){
		Optional<Factura> f = service.findById(id);
		if(!f.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(f.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Factura cliente) {
		Factura facturaeDb = service.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaeDb);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUna(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
