package com.Club_Futbol.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Club_Futbol.app.entity.Usuario;
import com.Club_Futbol.app.repository.UsuarioRepositorio;

public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private BCryptPasswordEncoder pass;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Override
	public Usuario findByUsername(String username) {
		return null;
	}

	@Override
	public Usuario registrar(Usuario u) {
		u.setClave(pass.encode(u.getClave()));
		return usuarioRepositorio.save(u);
	}

}
