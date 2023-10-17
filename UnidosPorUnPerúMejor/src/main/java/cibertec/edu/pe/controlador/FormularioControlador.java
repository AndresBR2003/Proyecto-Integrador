package cibertec.edu.pe.controlador;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cibertec.edu.pe.modelo.Formulario;
import cibertec.edu.pe.modelo.Programa;
import cibertec.edu.pe.modelo.Usuario;
import cibertec.edu.pe.servicio.FormularioServicio;
import cibertec.edu.pe.servicio.ProgramaServicio;
import cibertec.edu.pe.servicio.UsuarioServicio;

@Controller
public class FormularioControlador {
	@Autowired
	private FormularioServicio formServ;
	@Autowired
    private ProgramaServicio programaServicio;
	@Autowired
	private UsuarioServicio usuarioService;
	
	@RequestMapping("/nuevoForm/{idPro}")
	public ModelAndView  mostrarFormularioDeFormulario(@PathVariable(name = "idPro") Long idPro /* , Authentication authy */) {
		ModelAndView m = new ModelAndView("nuevo_form");
		// Obtener el programa
        Programa programa = programaServicio.get(idPro);
        
        //Usuario usuario = (Usuario) authy.getPrincipal();
		
		Formulario form = new Formulario();
		form.setPrograma(programa);
		//form.setUsuario(usuario);
		m.addObject("formulario", form);
		return m;
	}
	
	@PostMapping("/guardarFormulario")
	public String guardarPrograma(@ModelAttribute("formulario") Formulario form) {
		formServ.save(form);
		return "redirect:/nuevoForm";
	}
	
	/*@RequestMapping("/nuevoFormulario/{idPro}")
	public ModelAndView mostrarFormulario(@PathVariable(name = "idPro") Long idPro) {
		ModelAndView modelo = new ModelAndView("nuevo_form");
		
		Formulario form = formServ.get(idPro);
		modelo.addObject("formulario", form);
		return modelo;
	}*/
	
	
	
	

}
