package com.delivery.BuenSabor.ArticuloInsumo.controller;

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

import com.delivery.BuenSabor.ArticuloInsumo.entity.ArticuloInsumo;
import com.delivery.BuenSabor.ArticuloInsumo.service.ArticuloInsumoServiceImpl;

@RestController
@RequestMapping(path ="/api/v1/articuloinsumo")
public class ArticuloInsumoController {

	@Autowired
	protected ArticuloInsumoServiceImpl service;
	
	@GetMapping("/all")
	public ResponseEntity<?> AllInsumo() {
		return ResponseEntity.ok().body(service.finAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> byId(@PathVariable Long id) {
		Optional<ArticuloInsumo> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody ArticuloInsumo articuloInsumo) {
		ArticuloInsumo articuloDb = service.save(articuloInsumo);
		return ResponseEntity.status(HttpStatus.CREATED).body(articuloDb);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUno(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
