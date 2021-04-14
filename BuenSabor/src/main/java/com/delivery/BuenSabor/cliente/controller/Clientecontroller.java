package com.delivery.BuenSabor.cliente.controller;

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

import com.delivery.BuenSabor.cliente.entity.Cliente;
import com.delivery.BuenSabor.cliente.service.ClienteServiceImpl;

@RestController
@RequestMapping(path = "/api/v1/cliente")
public class Clientecontroller {

	@Autowired
	protected ClienteServiceImpl service;
	
	@GetMapping("/all")
	public ResponseEntity<?> allCliente(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> byId(@PathVariable Long id){
		Optional<Cliente> o = service.findById(id);
		if(o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Cliente cliente) {
		Cliente clienteDb = service.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteDb);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarUno(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
