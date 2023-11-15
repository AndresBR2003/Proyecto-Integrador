package cibertec.edu.pe.controlador;

import java.security.SecureRandom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cibertec.edu.pe.DTO.UsuarioRequestDTO;
import cibertec.edu.pe.DTO.UsuarioResponseDTO;
import cibertec.edu.pe.modelo.Usuario;
import cibertec.edu.pe.servicio.UsuarioServicio;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

	private UsuarioServicio usuarioServicio;

	public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
		super();
		this.usuarioServicio = usuarioServicio;
	}
	
	@ModelAttribute("usuario")
	public Usuario retornarNuevoUsuarioRegistroDTO() {
		return new Usuario();
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") Usuario registro) {
		registro.setRol(2);
		usuarioServicio.guardar(registro);
		
		return "redirect:/registro?exito";
	}
	
	
}
