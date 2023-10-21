package cibertec.edu.pe.modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String imagenPro;
	
	private boolean estado;

	@OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
	private Set<Formulario> formularios;
	
	@OneToOne(mappedBy = "programa")
    private Donaciones donaciones;
	
	

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

	public Programa(Long idPro, String nombrePro, String descripcionPro, String imagenPro, boolean estado,
			Set<Formulario> formularios) {
		super();
		this.idPro = idPro;
		this.nombrePro = nombrePro;
		this.descripcionPro = descripcionPro;
		this.imagenPro = imagenPro;
		this.formularios = formularios;
		this.estado = estado;
	}



	public Programa() {
		super();
		this.estado = true;
	}

}
