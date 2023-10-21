package cibertec.edu.pe.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.modelo.Donaciones;
import cibertec.edu.pe.repositorio.DonacionesRepositorio;
import cibertec.edu.pe.servicio.DonacionesServicio;

@Service
public class DonacionesServicioImpl implements DonacionesServicio{

	@Autowired
	private DonacionesRepositorio donaRepo;
	
	@Override
	public void save(Donaciones donaciones) {
		donaRepo.save(donaciones);
		
	}

	@Override
	public Donaciones get(Long idDona) {
		return donaRepo.findById(idDona).get();
	}

}
