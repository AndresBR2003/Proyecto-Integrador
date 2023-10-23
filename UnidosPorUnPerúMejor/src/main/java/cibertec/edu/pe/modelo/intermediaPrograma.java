package cibertec.edu.pe.modelo;

import org.springframework.web.multipart.MultipartFile;

public class intermediaPrograma {

	private Long idPro;
	private String nombrePro;
	private String descripcionPro;
	private String actividades;
	private String descripcionPro3;
	private MultipartFile imagenPro;
	
	
	public intermediaPrograma(Long idPro, String nombrePro, String descripcionPro, String actividades,
			String descripcionPro3, MultipartFile imagenPro) {
		super();
		this.idPro = idPro;
		this.nombrePro = nombrePro;
		this.descripcionPro = descripcionPro;
		this.actividades = actividades;
		this.descripcionPro3 = descripcionPro3;
		this.imagenPro = imagenPro;
	}
	
	
	public intermediaPrograma() {
		super();
	}


	//
	public Long getIdPro() {
		return idPro;
	}
	public void setIdPro(Long idPro) {
		this.idPro = idPro;
	}
	public String getNombrePro() {
		return nombrePro;
	}
	public void setNombrePro(String nombrePro) {
		this.nombrePro = nombrePro;
	}
	public String getDescripcionPro() {
		return descripcionPro;
	}
	public void setDescripcionPro(String descripcionPro) {
		this.descripcionPro = descripcionPro;
	}
	public String getActividades() {
		return actividades;
	}
	public void setActividades(String actividades) {
		this.actividades = actividades;
	}
	public String getDescripcionPro3() {
		return descripcionPro3;
	}
	public void setDescripcionPro3(String descripcionPro3) {
		this.descripcionPro3 = descripcionPro3;
	}
	public MultipartFile getImagenPro() {
		return imagenPro;
	}
	public void setImagenPro(MultipartFile imagenPro) {
		this.imagenPro = imagenPro;
	}
	
	
}
