package cibertec.edu.pe.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Donaciones {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDona;
	private String nroTargeta;
	private String nombreDelTitular;
	private String CVC;
	private String caducidad;
	private double totalDona;
	
	 @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	    @JoinColumn(name = "id")
	    private Usuario usuario;

	 @ManyToOne // Donación pertenece a un Programa
	    @JoinColumn(name = "idPro")
	    private Programa programa; // Relación a la entidad Programa
	
	public Donaciones() {
		super();
	}



	public Donaciones(Long idDona, String nroTargeta, String nombreDelTitular, String cVC, String caducidad,
			double totalDona, Usuario usuario, Programa programa) {
		super();
		this.idDona = idDona;
		this.nroTargeta = nroTargeta;
		this.nombreDelTitular = nombreDelTitular;
		CVC = cVC;
		this.caducidad = caducidad;
		this.totalDona = totalDona;
		this.usuario = usuario;
		this.programa = programa;
	}







	


//
	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Programa getPrograma() {
		return programa;
	}



	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
//


	public Long getIdDona() {
		return idDona;
	}

	public void setIdDona(Long idDona) {
		this.idDona = idDona;
	}

	public String getNroTargeta() {
		return nroTargeta;
	}

	public void setNroTargeta(String nroTargeta) {
		this.nroTargeta = nroTargeta;
	}

	public String getNombreDelTitular() {
		return nombreDelTitular;
	}

	public void setNombreDelTitular(String nombreDelTitular) {
		this.nombreDelTitular = nombreDelTitular;
	}

	public String getCVC() {
		return CVC;
	}

	public void setCVC(String cVC) {
		CVC = cVC;
	}

	public String getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}

	public double getTotalDona() {
		return totalDona;
	}

	public void setTotalDona(double totalDona) {
		this.totalDona = totalDona;
	}

	
	
}
