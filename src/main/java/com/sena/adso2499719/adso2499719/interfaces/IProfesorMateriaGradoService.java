package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;
import java.util.Optional;

import com.sena.adso2499719.adso2499719.entities.ProfesorMateriaGrado;

public interface IProfesorMateriaGradoService {

	List<ProfesorMateriaGrado> getAll();
	
	Optional<ProfesorMateriaGrado> getById(Long id);
	
	ProfesorMateriaGrado save(ProfesorMateriaGrado profesorMateriaGrado);
	
	void update(Long id, ProfesorMateriaGrado profesorMateriaGrado);
	
	void delete(Long id);
	
}
