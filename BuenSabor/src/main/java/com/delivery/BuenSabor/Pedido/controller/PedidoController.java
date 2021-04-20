package com.delivery.BuenSabor.Pedido.controller;

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
