package com.delivery.BuenSabor.usuario.repository;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.delivery.BuenSabor.usuario.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	/*@Query("SELECT u FROM usuario u WHERE u.usuario LIKE %?1%")
	public Optional<Usuario> findById(String usuario);*/
}
