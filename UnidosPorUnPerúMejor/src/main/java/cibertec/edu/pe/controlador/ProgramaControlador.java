package cibertec.edu.pe.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cibertec.edu.pe.modelo.Programa;
import cibertec.edu.pe.servicio.ProgramaServicio;

@Controller
public class ProgramaControlador {
	
	@Autowired
	private ProgramaServicio programaServicio;
	
	@RequestMapping("/programas")
	public String verPaginaDeProgramas(Model modelo, @Param("palabraClave") String palabraClave ) {
		List<Programa> listaProgramas = programaServicio.listAll(palabraClave);
		modelo.addAttribute("listaProgramas",listaProgramas);
		modelo.addAttribute("palabraClave", palabraClave);

		return "index";
	}
	
	
	@RequestMapping("/nuevo")
	public String mostrarFormularioDeRegistrarPrograma(Model m) {
		Programa pro = new Programa();
		m.addAttribute("programa", pro);
		return "nuevo_programa";
	}
	
	@PostMapping("/guardar")
	public String guardarPrograma(@ModelAttribute("progama") Programa programa) {
		programaServicio.save(programa);
		return "redirect:/programas";
	}
	
	@RequestMapping("/editar/{idPro}")
	public ModelAndView mostrarFormularioDeEditarPrograma(@PathVariable(name = "idPro") Long idPro) {
		ModelAndView modelo = new ModelAndView("editar_programa");
		
		Programa pro = programaServicio.get(idPro);
		modelo.addObject("programa", pro);
		
		return modelo;
	}
	
	@RequestMapping("/eliminar/{idPro}")
	public String eliminarPrograma(@PathVariable(name = "idPro") Long idPro) {
		programaServicio.delete(idPro);
		return "redirect:/programas";
	}
	

}
