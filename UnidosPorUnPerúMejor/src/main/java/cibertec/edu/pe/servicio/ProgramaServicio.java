package cibertec.edu.pe.servicio;

import java.util.List;


import cibertec.edu.pe.modelo.Programa;

public interface ProgramaServicio {
	public List<Programa> listAll(String palabraClave);
	public void save(Programa programa);
	public Programa get(Long id);
	public void delete(Long idPro);

}
