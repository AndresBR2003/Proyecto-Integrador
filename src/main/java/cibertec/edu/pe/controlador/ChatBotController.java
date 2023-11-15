package cibertec.edu.pe.controlador;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cibertec.edu.pe.DTO.UsuarioRequestDTO;
import cibertec.edu.pe.DTO.UsuarioResponseDTO;
import cibertec.edu.pe.modelo.Donaciones;
import cibertec.edu.pe.modelo.Programa;
import cibertec.edu.pe.modelo.Usuario;
import cibertec.edu.pe.servicio.ProgramaServicio;
import cibertec.edu.pe.servicio.UsuarioServicio;


@RestController
@Controller
public class ChatBotController {
	
	@Autowired
	private UsuarioServicio servicio;
	
	@Autowired
	private ProgramaServicio programaServicio;
	
	
	@PostMapping("/actualizarContrasenia")
	public UsuarioResponseDTO  actualziarContraseña(@RequestBody UsuarioRequestDTO usuReq) {
		
		Usuario usuario1 = servicio.findByEmail(usuReq.getEmail());
		
		if(usuario1.getDNI_CE().equals(usuReq.getDNI_CE())) {
			String clave = generarContrasena();
			usuario1.setPassword(clave);
			
			UsuarioResponseDTO dto = new UsuarioResponseDTO();
			dto.setEmail(usuario1.getEmail());
			dto.setPassword(clave);
			
			
			
			return dto;
		}
		UsuarioResponseDTO dto = new UsuarioResponseDTO();
		dto.setEmail("error");
		return dto;
	}

	
	public static String generarContrasena() {
        // Definir caracteres permitidos en la contraseña
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Crear un generador seguro de números aleatorios
        SecureRandom random = new SecureRandom();

        // Crear un StringBuilder para construir la contraseña
        StringBuilder contrasena = new StringBuilder();

        // Generar cada carácter de la contraseña
        for (int i = 0; i < 8; i++) {
            // Obtener un índice aleatorio dentro del rango de caracteres
            int indice = random.nextInt(caracteres.length());

            // Agregar el carácter correspondiente al índice a la contraseña
            contrasena.append(caracteres.charAt(indice));
        }

        // Convertir el StringBuilder a una cadena y retornar la contraseña generada
        return contrasena.toString();
    }
	

}
