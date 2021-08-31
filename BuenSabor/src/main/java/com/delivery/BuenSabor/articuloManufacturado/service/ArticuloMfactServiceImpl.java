package com.delivery.BuenSabor.articuloManufacturado.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.delivery.BuenSabor.articuloManufacturado.entity.ArticuloMfact;
import com.delivery.BuenSabor.articuloManufacturado.repository.ArticuloMfactRepository;

@Service
public class ArticuloMfactServiceImpl implements ArticuloMfactService {

	@Autowired
	protected ArticuloMfactRepository articuloMfactRepository; 
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<ArticuloMfact> findAll() {
		return articuloMfactRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ArticuloMfact> findById(Long id) {
		return articuloMfactRepository.findById(id);
	}

	@Override
	public ArticuloMfact save(ArticuloMfact articuloMfact) {
		return articuloMfactRepository.save(articuloMfact);
	}

	@Override
	public void deleteById(Long id) {
		articuloMfactRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<ArticuloMfact> findByLike() {
		return articuloMfactRepository.search();
	}

}
