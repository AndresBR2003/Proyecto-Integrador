package cibertec.edu.pe.controlador;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cibertec.edu.pe.modelo.Donaciones;
import cibertec.edu.pe.modelo.Formulario;
import cibertec.edu.pe.modelo.Programa;
import cibertec.edu.pe.modelo.Usuario;
import cibertec.edu.pe.repositorio.UsuarioRepositorio;
import cibertec.edu.pe.servicio.DonacionesServicio;
import cibertec.edu.pe.servicio.FormularioServicio;
import cibertec.edu.pe.servicio.ProgramaServicio;
import cibertec.edu.pe.servicio.UsuarioServicio;

@Controller
public class DonacionesControlador {
	
	@Autowired
	private UsuarioRepositorio usuRepo;
	
	@Autowired
	private DonacionesServicio donaServi;
	
	@Autowired 
	private ProgramaServicio proServi;
	
	@Autowired
	private UsuarioServicio usuServi;
	
	@Autowired
	private FormularioServicio formService;
	
	
	@RequestMapping("/nuevaDonacion/{idPro}")
	public ModelAndView mostrarFormularioDeRegistrarDonacion(@PathVariable(name = "idPro") Long idPro) {
		ModelAndView modelo = new ModelAndView("donaciones");
		Programa programa = proServi.get(idPro);	
		Donaciones dona = new Donaciones();
		dona.setPrograma(programa);
		modelo.addObject("donacion", dona);
		
		return modelo;
	}
	
	
	@PostMapping("/guardarDonacion")
	public String guardarDonacion(@ModelAttribute("donaciones") Donaciones donaciones) {
		 // Obtén el ID del programa desde la donación
	    Long programaId = donaciones.getPrograma().getIdPro();

	    // Carga el programa desde la base de datos
	    Programa programa = proServi.get(programaId);
	 // Asigna el programa a la donación
	    donaciones.setPrograma(programa);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario usu = usuRepo.findByEmail(auth.getName());
		donaciones.setUsuario(usu);
		donaServi.save(donaciones);
		return "redirect:/programas";
	}
	
	@RequestMapping("/donacionesXUsuario")
	public String verDonacionesPorUsuario(Model modelo) {		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuServi.findByEmail(authentication.getName());
        modelo.addAttribute("usuario",usuario);
				
		List<Donaciones> listaDonaciones = donaServi.findByUsuario(usuario.getId());
		modelo.addAttribute("listaProgramas",listaDonaciones);
		
		if(usuario.getEstado().getIdEst() == 3) {
		
		List<Formulario> listaForm = formService.findByUsuario(usuario.getId());
		modelo.addAttribute("listaForm", listaForm); //Mediante la variable Programa de Formulario obtienes el programa al cual está dentro el usuario
		} else {
			return "No está participando en ningun Programa";
		}
		

		return "perfilUsuario";
	}
}
