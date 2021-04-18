package com.delivery.BuenSabor.MercadoPagoDatos.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.BuenSabor.MercadoPagoDatos.entiy.MercadoPagoDatos;
import com.delivery.BuenSabor.MercadoPagoDatos.repository.MpagoDatosRepository;

@Service
public class MercadoPagoDatosImpl implements MercadoPagoDatosService {

	@Autowired
	protected MpagoDatosRepository mPagoDatosRepository;

	@Override
	public Iterable<MercadoPagoDatos> findAll() {
		return mPagoDatosRepository.findAll();
	}

	@Override
	public Optional<MercadoPagoDatos> findById(Long id) {
		return mPagoDatosRepository.findById(id);
	}

	@Override
	public MercadoPagoDatos save(MercadoPagoDatos mPagoD) {
		return mPagoDatosRepository.save(mPagoD);
	}

	@Override
	public void deleteById(Long id) {
		mPagoDatosRepository.deleteById(id);
	}

}
