package com.Club_Futbol.app.service;

import com.Club_Futbol.app.entity.Usuario;

public interface UsuarioService {
	
	public Usuario findByUsername(String username);
	
	public Usuario registrar(Usuario u);

}
