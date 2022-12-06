package com.Club_Futbol.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Club_Futbol.app.entity.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);
		
}
