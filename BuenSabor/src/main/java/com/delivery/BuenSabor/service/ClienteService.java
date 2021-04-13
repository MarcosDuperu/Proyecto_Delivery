package com.delivery.BuenSabor.service;

import java.util.Optional;

import com.delivery.BuenSabor.entity.Cliente;

public interface ClienteService {

	public Iterable<Cliente> findAll();
	
	public Optional<Cliente> findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void deleteById(Long id);
}
