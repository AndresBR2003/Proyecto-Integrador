package cibertec.edu.pe.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cibertec.edu.pe.modelo.Formulario;
import cibertec.edu.pe.servicio.FormularioServicio;

@Controller
public class FormularioControlador {
	@Autowired
	private FormularioServicio formServ;
	
	@RequestMapping("/nuevoForm")
	public String mostrarFormularioDeFormulario(Model m) {
		Formulario form = new Formulario();
		m.addAttribute("formulario", form);
		return "nuevo_form";
	}
	
	@PostMapping("/guardarFormulario")
	public String guardarPrograma(@ModelAttribute("formulario") Formulario form) {
		formServ.save(form);
		return "redirect:/nuevoForm";
	}
	
	@RequestMapping("/nuevoFormulario/{idPro}")
	public ModelAndView mostrarFormulario(@PathVariable(name = "idPro") Long idPro) {
		ModelAndView modelo = new ModelAndView("nuevo_form");
		
		Formulario form = formServ.get(idPro);
		modelo.addObject("formulario", form);
		return modelo;
	}
	
	
	
	

}
