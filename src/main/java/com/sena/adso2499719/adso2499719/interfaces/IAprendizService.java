package com.sena.adso2499719.adso2499719.interfaces;

import java.util.List;
import com.sena.adso2499719.adso2499719.entities.Aprendiz;

public interface IAprendizService {
	
	List<Aprendiz> getAll();
	
	Aprendiz getById(Long id) throws Exception;
	
	Aprendiz save(Aprendiz aprendiz);
	
	void update(Long id, Aprendiz aprendiz) throws Exception;
	
	void delete(Long id) throws Exception;
	
}
