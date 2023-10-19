package cibertec.edu.pe.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Formulario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idForm;
	private String cvForm;
	private String cartaForm;
	private String antecedentesForm;
	private String copiaDNI_CEForm;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idPro")
	private Programa programa;

	public Long getIdForm() {
		return idForm;
	}

	public void setIdForm(Long idForm) {
		this.idForm = idForm;
	}

	public String getCvForm() {
		return cvForm;
	}

	public void setCvForm(String cvForm) {
		this.cvForm = cvForm;
	}

	public String getCartaForm() {
		return cartaForm;
	}

	public void setCartaForm(String cartaForm) {
		this.cartaForm = cartaForm;
	}

	public String getAntecedentesForm() {
		return antecedentesForm;
	}

	public void setAntecedentesForm(String antecedentesForm) {
		this.antecedentesForm = antecedentesForm;
	}

	public String getCopiaDNI_CEForm() {
		return copiaDNI_CEForm;
	}

	public void setCopiaDNI_CEForm(String copiaDNI_CEForm) {
		this.copiaDNI_CEForm = copiaDNI_CEForm;
	}

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
	
	

	public Formulario(Long idForm, String cvForm, String cartaForm, String antecedentesForm, String copiaDNI_CEForm, 
			Usuario usuario, Programa programa) {
		super();
		this.idForm = idForm;
		this.cvForm = cvForm;
		this.cartaForm = cartaForm;
		this.antecedentesForm = antecedentesForm;
		this.copiaDNI_CEForm = copiaDNI_CEForm;
		this.usuario = usuario;
		this.programa = programa;
	}



	public Formulario() {
	}

}
