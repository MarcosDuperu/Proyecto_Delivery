package com.delivery.BuenSabor.usuario.controller;

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

import com.delivery.BuenSabor.usuario.entity.Usuario;
import com.delivery.BuenSabor.usuario.service.UsuarioServiceImpl;

@RestController
@RequestMapping(path = "/api/v1/usuario")
public class UsuarioController {

	@Autowired
	protected UsuarioServiceImpl service;
	
	@GetMapping("/all")
	public ResponseEntity<?> allUser() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{usuario}")
	public ResponseEntity<?> byUsuario(@PathVariable String usuario) {
		Optional<Usuario> o = service.findByUsuario(usuario);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	@PutMapping("/{user}")
	public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable String user){
		Optional<Usuario> o = service.findByUsuario(user);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Usuario usuarioDb = o.get();
		usuarioDb.setClave(usuario.getClave());
		usuarioDb.setCliente(usuario.getCliente());
		usuarioDb.setRol(usuario.getRol());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioDb));
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Usuario usuario) {
		Usuario usuarioDb = service.save(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDb);
	}
	
	@DeleteMapping("/{usuario}")
	public ResponseEntity<?> eliminarUsuario(@PathVariable String usuario){
		service.deleteByIdUsuario(usuario);
		return ResponseEntity.noContent().build();
	}
}
