package cibertec.edu.pe.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import cibertec.edu.pe.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(Usuario registro);
	
	public List<Usuario> listarUsuarios();
	
}
