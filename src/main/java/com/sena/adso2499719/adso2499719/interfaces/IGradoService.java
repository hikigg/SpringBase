package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;

import com.sena.adso2499719.adso2499719.entities.Grado;

public interface IGradoService {
	
	List<Grado> getAll();
	
	Grado getById(Long id) throws Exception;
	
	Grado save(Grado grado);
	
	void update(Long id, Grado grado) throws Exception;
	
	void delete(Long id) throws Exception;
	
}
