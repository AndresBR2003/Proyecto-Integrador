package cibertec.edu.pe.controlador;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cibertec.edu.pe.modelo.Formulario;
import cibertec.edu.pe.modelo.Programa;
import cibertec.edu.pe.modelo.Usuario;
import cibertec.edu.pe.modelo.intermediaPrograma;
import cibertec.edu.pe.repositorio.UsuarioRepositorio;
import cibertec.edu.pe.servicio.ProgramaServicio;

@Controller
public class ProgramaControlador {
	
	@Autowired
	private ProgramaServicio programaServicio;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@RequestMapping("/programas")
	public String verPaginaDeProgramas(Model modelo, @Param("palabraClave") String palabraClave ) {
		List<Programa> listaProgramas = programaServicio.listAll(palabraClave);
		modelo.addAttribute("listaProgramas",listaProgramas);
		modelo.addAttribute("palabraClave", palabraClave);
		
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioRepositorio.findByEmail(authentication.getName());
        
        System.out.println(usuario.getRol());
        
        modelo.addAttribute("rol",usuario.getRol());

		return "programasxjefe";
	}
	
	
	@RequestMapping("/nuevo")
	public String mostrarFormularioDeRegistrarPrograma(Model m) {
		Programa pro = new Programa();
		m.addAttribute("programa", pro);
		return "AñadirPrograma";
	}
	
	@PostMapping("/guardar")
	public String guardarPrograma(@ModelAttribute("programa") intermediaPrograma programa) {
		
		if (!programa.getImagenPro().isEmpty()) {
			try {

                Programa nuevoPrograma = new Programa();
                
                nuevoPrograma.setNombrePro(programa.getNombrePro());
                nuevoPrograma.setDescripcionPro(programa.getDescripcionPro());
                nuevoPrograma.setActividades(programa.getActividades());
                nuevoPrograma.setDescripcionPro3(programa.getDescripcionPro3());
                nuevoPrograma.setImagenPro(ObtenerUrl(programa.getImagenPro()));
                
                programaServicio.save(nuevoPrograma);

                return "redirect:/programas";				
			
			}
			catch (Exception e) {
				// TODO: handle exception
			}
         }
		return null;		
}
	
	public String ObtenerUrl(MultipartFile imagen ) throws IOException {
		
		String imgurApiUrl = "https://api.imgur.com/3/image";
        String imgurClientId = "6d069b2c4acdf44";
        String url = "";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Client-ID " + imgurClientId);

        MultipartFile image = imagen;
        HttpEntity<byte[]> requestEntity = new HttpEntity<>(image.getBytes(), headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> responseEntity = restTemplate.exchange(imgurApiUrl, HttpMethod.POST, requestEntity, Map.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            Map<String, Object> body = responseEntity.getBody();
            url = (String) ((Map) body.get("data")).get("link");
        }
		return url;
	}
	
	
	@PostMapping("/editarPrograma")
	public String editarPrograma(@ModelAttribute("programa") intermediaPrograma programa) {
		
		if (!programa.getImagenPro().isEmpty()) {
			try {
                
                Programa nuevoPrograma = programaServicio.get(programa.getIdPro());
                
                nuevoPrograma.setNombrePro(programa.getNombrePro());
                nuevoPrograma.setDescripcionPro(programa.getDescripcionPro());
                nuevoPrograma.setActividades(programa.getActividades());
                nuevoPrograma.setDescripcionPro3(programa.getDescripcionPro3());
                nuevoPrograma.setImagenPro(ObtenerUrl(programa.getImagenPro()));
                
                programaServicio.save(nuevoPrograma);

                

                return "redirect:/programas";				
				
				
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
         }
		return null;		
}

		


	
	@RequestMapping("/verPrograma/{idPro}")
	public ModelAndView mostrarFormularioDeEditarPro(@PathVariable(name = "idPro") Long idPro) {
		ModelAndView modelo = new ModelAndView("masInformacion");
		System.out.println("llegue");
		
		Programa pro = programaServicio.get(idPro);
		modelo.addObject("programa", pro);
		
		String actividades = pro.getActividades();
		String [] actSeparadas = actividades.split("\\|"); 
		
		List<String> listActividades = new ArrayList<>();
		for(int i = 0; i< actSeparadas.length; i++ ) {
			listActividades.add(actSeparadas[i]);
			System.out.println(actSeparadas[i]);
		}
		
		modelo.addObject("listActividades",listActividades);
		
		modelo.addObject("usuario",0);
		
		Programa programa = programaServicio.get(idPro);
		
        Formulario form = new Formulario();	
		form.setPrograma(programa);
		modelo.addObject("formulario", form);
		
		return modelo;
	}
	
	@RequestMapping("/editar/{idPro}")
	public ModelAndView mostrarFormularioDeEditarPrograma(@PathVariable(name = "idPro") Long idPro) {
		ModelAndView modelo = new ModelAndView("editarPrograma");
		
		Programa pro = programaServicio.get(idPro);
		modelo.addObject("programa", pro);
		
		return modelo;
	}
	
	@RequestMapping("/eliminar/{idPro}")
	public String eliminarPrograma(@PathVariable(name = "idPro") Long idPro) {
		Programa programa = programaServicio.get(idPro);
		programa.setEstado(false);
		programaServicio.save(programa);
		return "redirect:/programas";
	}
	

}
