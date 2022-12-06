package com.Club_Futbol.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Club_Futbol.app.entity.Usuario;
import com.Club_Futbol.app.repository.UsuarioRepositorio;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepositorio.findByUsername(username);
		UserBuilder builder  = null;
		
		if(usuario != null) {
			builder = User.withUsername(username);
			builder.disabled(false);
			builder.password(usuario.getClave());
			builder.authorities( new SimpleGrantedAuthority("ROLE_USER"));
			
		}else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		return builder.build();
	}

}
