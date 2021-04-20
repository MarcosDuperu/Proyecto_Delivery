package com.delivery.BuenSabor.usuario.service;

import java.util.Optional;

import com.delivery.BuenSabor.usuario.entity.Usuario;

public interface UsuarioService {

	public Iterable<Usuario> findAll();
	
	public Optional<Usuario> findByUsuario(String usuario);
	
	public Usuario save(Usuario usuario);
	
	public void deleteByIdUsuario(String usuario);
}
