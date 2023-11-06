package cibertec.edu.pe.servicio;

import java.util.List;

import cibertec.edu.pe.modelo.Donaciones;


public interface DonacionesServicio {
	
	public void save(Donaciones donaciones);
	public Donaciones get(Long idDona);
	public List<Donaciones> findByUsuario (Long id);
}
