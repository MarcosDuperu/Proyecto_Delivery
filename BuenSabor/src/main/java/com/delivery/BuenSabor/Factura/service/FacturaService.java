package com.delivery.BuenSabor.Factura.service;

import java.util.Optional;

import com.delivery.BuenSabor.Factura.entity.Factura;

public interface FacturaService {

	public Iterable<Factura> findAll();

	public Optional<Factura> findById(Long id);

	public Factura save(Factura factura);

	public void deleteById(Long id);
}
