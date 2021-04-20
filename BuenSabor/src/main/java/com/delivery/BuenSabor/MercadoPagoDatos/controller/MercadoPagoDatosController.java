package com.delivery.BuenSabor.MercadoPagoDatos.controller;

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

import com.delivery.BuenSabor.MercadoPagoDatos.entiy.MercadoPagoDatos;
import com.delivery.BuenSabor.MercadoPagoDatos.service.MercadoPagoDatosImpl;

@RestController
@RequestMapping(path = "/api/v1/mpago")
public class MercadoPagoDatosController {

	@Autowired
	protected MercadoPagoDatosImpl service;
	
	@GetMapping("/all")
	public ResponseEntity<?> allMpagoDatos(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> byId(@PathVariable Long id){
		Optional<MercadoPagoDatos> f = service.findById(id);
		if(f.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(f.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody MercadoPagoDatos mPagoD) {
		MercadoPagoDatos mPD = service.save(mPagoD);
		return ResponseEntity.status(HttpStatus.CREATED).body(mPD);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarMpagoD(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
