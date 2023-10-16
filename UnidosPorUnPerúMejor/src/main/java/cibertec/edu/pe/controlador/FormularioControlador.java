package cibertec.edu.pe.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cibertec.edu.pe.modelo.Formulario;
import cibertec.edu.pe.modelo.Programa;
import cibertec.edu.pe.servicio.FormularioServicio;

public class FormularioControlador {
	@Autowired
	private FormularioServicio formServ;
	
	@RequestMapping("/nuevoFromulario")
	public String mostrarFormularioDeRegistrarPrograma(Model m) {
		Formulario form = new Formulario();
		m.addAttribute("formulario", form);
		return "nuevo_formulario";
	}

}
