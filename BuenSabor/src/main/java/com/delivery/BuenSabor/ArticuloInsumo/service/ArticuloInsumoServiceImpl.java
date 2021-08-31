package com.delivery.BuenSabor.ArticuloInsumo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delivery.BuenSabor.ArticuloInsumo.entity.ArticuloInsumo;
import com.delivery.BuenSabor.ArticuloInsumo.repository.ArticuloInsumoRepository;

@Service
public class ArticuloInsumoServiceImpl implements ArticuloInsumoService {

	@Autowired
	protected ArticuloInsumoRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<ArticuloInsumo> finAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ArticuloInsumo> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public ArticuloInsumo save(ArticuloInsumo articuloInsumo) {
		return repository.save(articuloInsumo);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<ArticuloInsumo> findByLike(){
		return repository.search();
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<ArticuloInsumo> findByInsumo() {
		return repository.articuloForCliente();
	}
}
