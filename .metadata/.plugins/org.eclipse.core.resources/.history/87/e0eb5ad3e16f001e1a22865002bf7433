package cibertec.edu.pe.controlador;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;

import cibertec.edu.pe.modelo.Formulario;
import cibertec.edu.pe.modelo.Programa;
import cibertec.edu.pe.modelo.Usuario;
import cibertec.edu.pe.servicio.FormularioServicio;
import cibertec.edu.pe.servicio.ProgramaServicio;
import cibertec.edu.pe.servicio.UsuarioServicio;
import org.springframework.security.core.context.SecurityContextHolder;


@Controller
@Secured("ROLE_USER")
public class FormularioControlador {
	@Autowired
	private FormularioServicio formServ;
	@Autowired
    private ProgramaServicio programaServicio;
	@Autowired
	private UsuarioServicio usuarioServicio;

	
	@RequestMapping("/nuevoForm/{idPro}")
	public ModelAndView  mostrarFormularioDeFormulario(@PathVariable(name = "idPro") Long idPro) {
		ModelAndView m = new ModelAndView("nuevo_form");
		// Obtener el programa y usuario
        Programa programa = programaServicio.get(idPro);
 
		Formulario form = new Formulario();		
		form.setPrograma(programa);
		

		m.addObject("formulario", form);
		return m;
	}
	
	@PostMapping("/guardarFormulario")
	public String guardarPrograma(@ModelAttribute("formulario") Formulario form) {
		formServ.save(form);
		return "redirect:/nuevoForm";
	}
	
	@GetMapping
	public ResponseEntity<Usuario> getCurrentUser() {
	    Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    return ResponseEntity.ok(usuario);
	}
}
