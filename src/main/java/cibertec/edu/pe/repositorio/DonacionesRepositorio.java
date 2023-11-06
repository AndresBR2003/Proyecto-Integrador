package cibertec.edu.pe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cibertec.edu.pe.modelo.Donaciones;

public interface DonacionesRepositorio extends JpaRepository<Donaciones, Long>{

	List<Donaciones> findByUsuario(Long id);
} 
