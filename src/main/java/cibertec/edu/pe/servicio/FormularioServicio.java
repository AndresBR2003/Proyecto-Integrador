package cibertec.edu.pe.servicio;

import java.util.List;

import cibertec.edu.pe.modelo.Formulario;
import cibertec.edu.pe.modelo.Programa;



public interface FormularioServicio {
	public List<Formulario> listAll();
	public void save(Formulario formulario);
	public Formulario get(Long idForm);
	public void delete(Long idForm);
	public List<Formulario> listFormsByProgram (Programa idPro);
}
