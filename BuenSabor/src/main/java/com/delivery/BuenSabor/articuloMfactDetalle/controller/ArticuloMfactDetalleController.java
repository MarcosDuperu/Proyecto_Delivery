package com.delivery.BuenSabor.articuloMfactDetalle.controller;

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

import com.delivery.BuenSabor.articuloMfactDetalle.entity.ArticuloMfactDetalle;
import com.delivery.BuenSabor.articuloMfactDetalle.service.ArticuloMfactDetalleServiceImpl;

@RestController
@RequestMapping(path = "/api/v1/artmfactdetalle")
public class ArticuloMfactDetalleController {

	@Autowired
	private ArticuloMfactDetalleServiceImpl service;
	
	@GetMapping("/all")
	public ResponseEntity<?> AllDetalle() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> byId(@PathVariable Long id) {
		Optional<ArticuloMfactDetalle> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody ArticuloMfactDetalle detalle, @PathVariable Long id) {
		Optional<ArticuloMfactDetalle> o = service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		ArticuloMfactDetalle detalleDb = o.get();
		detalleDb.setArticuloInsumo(detalle.getArticuloInsumo());
		detalleDb.setCantidad(detalle.getCantidad());
		detalleDb.setUnidadMedida(detalle.getUnidadMedida());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(detalleDb));
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody ArticuloMfactDetalle articulo) {
		ArticuloMfactDetalle articuloDb = service.save(articulo);
		return ResponseEntity.status(HttpStatus.CREATED).body(articuloDb);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUno(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
