package com.delivery.BuenSabor.articuloManufacturado.controller;

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

import com.delivery.BuenSabor.articuloManufacturado.entity.ArticuloMfact;
import com.delivery.BuenSabor.articuloManufacturado.service.ArticuloMfactServiceImpl;

@RestController
@RequestMapping(path = "api/v1/articulomanufaturado")
public class articuloMfactController {

	@Autowired
	protected ArticuloMfactServiceImpl service;
	
	@GetMapping("/all")
	public ResponseEntity<?> AllArticulo() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id")
	public ResponseEntity<?> byId(@PathVariable Long id){
		Optional<ArticuloMfact> o = service.findById(id);
		if(o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody ArticuloMfact articuloMfact) {
		ArticuloMfact articuloDb = service.save(articuloMfact);
		return ResponseEntity.status(HttpStatus.CREATED).body(articuloDb);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUno(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
