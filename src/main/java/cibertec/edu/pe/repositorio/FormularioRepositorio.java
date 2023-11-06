package cibertec.edu.pe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cibertec.edu.pe.modelo.Formulario;
import cibertec.edu.pe.modelo.Programa;

public interface FormularioRepositorio extends JpaRepository<Formulario, Long>{

	@Query("SELECT f FROM Formulario f WHERE f.estado = true AND f.programa = ?1")
	List<Formulario> findByPrograma (Programa idPro);

	List<Formulario> findByUsuario(Long id);
}
