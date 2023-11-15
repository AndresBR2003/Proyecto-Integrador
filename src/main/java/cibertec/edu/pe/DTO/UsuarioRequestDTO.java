package cibertec.edu.pe.DTO;

public class UsuarioRequestDTO {

	private String email;
	private String DNI_CE;
	
	
	
	
	public UsuarioRequestDTO(String email, String dNI_CE) {
		super();
		this.email = email;
		DNI_CE = dNI_CE;
	}
	
	
	public UsuarioRequestDTO() {
		super();
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDNI_CE() {
		return DNI_CE;
	}
	public void setDNI_CE(String dNI_CE) {
		DNI_CE = dNI_CE;
	}



	

	
}
