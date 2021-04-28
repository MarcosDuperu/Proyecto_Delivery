package com.delivery.BuenSabor.usuario.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.BuenSabor.security.dto.JwtDto;
import com.delivery.BuenSabor.security.dto.LoginUsuario;
import com.delivery.BuenSabor.security.dto.NuevoUsuario;
import com.delivery.BuenSabor.security.enums.RolNombre;
import com.delivery.BuenSabor.security.jwt.JwtProvider;
import com.delivery.BuenSabor.usuario.entity.Rol;
import com.delivery.BuenSabor.usuario.entity.Usuario;
import com.delivery.BuenSabor.usuario.service.RolServiceImpl;
import com.delivery.BuenSabor.usuario.service.UsuarioServiceImpl;

@RestController
@RequestMapping(path = "/api/v1/usuario/auth")
@CrossOrigin
public class UsuarioController {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
	@Autowired
	RolServiceImpl rolservice;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@PostMapping("/crear")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return ResponseEntity.badRequest().build();
		if(usuarioService.existsByUsuario(nuevoUsuario.getUsuario()))
			return ResponseEntity.badRequest().build();
		Usuario usuario = new Usuario();
		usuario.setUsuario(nuevoUsuario.getUsuario());
		usuario.setClave(passwordEncoder.encode(nuevoUsuario.getPassword()));
		usuario.setCliente(nuevoUsuario.getCliente());
		Set<Rol> roles = new HashSet<>();
		if(nuevoUsuario.getRoles().contains("cliente"))
			roles.add(rolservice.getByRolNombre(RolNombre.ROLE_CLIENTE).get());
		if(nuevoUsuario.getRoles().contains("jefe"))
			roles.add(rolservice.getByRolNombre(RolNombre.ROLE_ADMINISTRADOR).get());
		if(nuevoUsuario.getRoles().contains("cajero"))
			roles.add(rolservice.getByRolNombre(RolNombre.ROLE_CAJERO).get());
		if(nuevoUsuario.getRoles().contains("cocinero"))
			roles.add(rolservice.getByRolNombre(RolNombre.ROLE_COCINERO).get());
		usuario.setRoles(roles);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return ResponseEntity.badRequest().build();
		Authentication authentication = 
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getUsuario(), loginUsuario.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity<JwtDto>(jwtDto, HttpStatus.OK);
	}
}
