package com.delivery.BuenSabor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.delivery.BuenSabor.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
