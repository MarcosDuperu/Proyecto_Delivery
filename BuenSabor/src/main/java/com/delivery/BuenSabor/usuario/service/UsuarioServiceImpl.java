package com.delivery.BuenSabor.usuario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.BuenSabor.usuario.entity.Usuario;
import com.delivery.BuenSabor.usuario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	protected UsuarioRepository usuarioRepository;
	
	@Override
	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findByUsuario(String usuario) {
		return usuarioRepository.findById(usuario);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void deleteByIdUsuario(String usuario) {
		usuarioRepository.deleteById(usuario);

	}

}
