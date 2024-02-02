package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;

import com.sena.adso2499719.adso2499719.entities.Especialidad;

public interface IEspecialidadService {
	
	List<Especialidad> getAll();
	
	Especialidad getById(Long id) throws Exception;

	Especialidad save(Especialidad especialdiad);
	
	void update(Long id, Especialidad especialidad) throws Exception;
	
	void delete(Long id) throws Exception;
	
	
}
