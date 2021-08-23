package com.delivery.BuenSabor.RubroArticulo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.BuenSabor.RubroArticulo.entity.RubroArticulo;

@Repository
public interface RubroArticuloRepository extends JpaRepository<RubroArticulo, Long>{

}
