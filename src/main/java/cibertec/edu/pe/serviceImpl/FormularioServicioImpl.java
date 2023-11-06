package cibertec.edu.pe.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.modelo.Formulario;
import cibertec.edu.pe.modelo.Programa;
import cibertec.edu.pe.repositorio.FormularioRepositorio;
import cibertec.edu.pe.servicio.FormularioServicio;

@Service
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

	@Override
	public List<Formulario> listFormsByProgram(Programa idPro) {
		return formRepo.findByPrograma(idPro);
	}

	@Override
	public List<Formulario> findByUsuario(Long id) {
		return formRepo.findByUsuario(id);
	}

}
