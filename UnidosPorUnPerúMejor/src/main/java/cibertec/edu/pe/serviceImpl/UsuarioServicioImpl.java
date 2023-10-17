package cibertec.edu.pe.serviceImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.modelo.Rol;
import cibertec.edu.pe.modelo.Usuario;
import cibertec.edu.pe.repositorio.RolRepositorio;
import cibertec.edu.pe.repositorio.UsuarioRepositorio;
import cibertec.edu.pe.servicio.UsuarioServicio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
	
	@Autowired
	private RolRepositorio rolRepositorio;

	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}
	
	@Override
	public Usuario guardar(Usuario registro) {
		
		Rol roleUser = rolRepositorio.findByNombre("ROLE_USER");
		
		Rol rolUser = rolRepositorio.findByNombre("ROLE_USER");
	    if (rolUser == null) {
	        rolUser = new Rol("ROLE_USER");
	        rolRepositorio.save(rolUser);
	    }
		
		Usuario usuario = new Usuario(registro.getNombre(), 
				registro.getApellido(),
				registro.getDNI_CE(),
				registro.getCelular(),
				registro.getEmail(),
				passwordEncoder.encode(registro.getPassword()),
				Collections.singletonList(roleUser));
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}

}
