package com.delivery.BuenSabor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.delivery.BuenSabor.entity.Domicilio;

@Repository
public interface DomicilioRepository extends CrudRepository<Domicilio, Long>{

}
