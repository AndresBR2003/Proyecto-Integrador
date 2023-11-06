package cibertec.edu.pe.modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Programa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPro;
	private String nombrePro;
	private String descripcionPro;
	private String actividades;
	private String descripcionPro3;
	private String imagenPro;
	
	private boolean estado;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Usuario usuario;

	@OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
	private Set<Formulario> formularios;
	
	@OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
    private Set<Donaciones> donaciones;
	
	

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

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

	public String getImagenPro() {
		return imagenPro;
	}

	public void setImagenPro(String imagenPro) {
		this.imagenPro = imagenPro;
	}

	public Set<Formulario> getFormularios() {
		return formularios;
	}

	public void setFormularios(Set<Formulario> formularios) {
		this.formularios = formularios;
	}


	public Programa(Long idPro, String nombrePro, String descripcionPro,String actividades, String descripcionPro3,
			String imagenPro, boolean estado,Set<Formulario> formularios, Set<Donaciones> donaciones) {
		super();
		this.idPro = idPro;
		this.nombrePro = nombrePro;
		this.descripcionPro = descripcionPro;
		this.actividades = actividades;
		this.descripcionPro3 = descripcionPro3;
		this.imagenPro = imagenPro;
		this.estado = estado;
		this.formularios = formularios;
		this.donaciones = donaciones;
	}

	public Set<Donaciones> getDonaciones() {
		return donaciones;
	}

	public void setDonaciones(Set<Donaciones> donaciones) {
		this.donaciones = donaciones;
	}

	public Programa() {
		super();
		this.estado = true;
	}

}
