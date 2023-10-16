package cibertec.edu.pe.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cibertec.edu.pe.modelo.Formulario;
import cibertec.edu.pe.repositorio.FormularioRepositorio;
import cibertec.edu.pe.servicio.FormularioServicio;

public class FormularioServicioImpl implements FormularioServicio{
	
	@Autowired
	private FormularioRepositorio formRepo;

	@Override
	public List<Formulario> listAll() {
		return formRepo.findAll();
	}

	@Override
	public void save(Formulario formulario) {
		formRepo.save(formulario);
		
	}

	@Override
	public Formulario get(Long idForm) {
		return formRepo.findById(idForm).get();
	}

	@Override
	public void delete(Long idForm) {
		formRepo.deleteById(idForm);
		
	}

}
