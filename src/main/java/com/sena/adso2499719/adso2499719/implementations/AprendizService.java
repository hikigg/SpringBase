package com.sena.adso2499719.adso2499719.implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.entities.Aprendiz;
import com.sena.adso2499719.adso2499719.interfaces.IAprendizService;
import com.sena.adso2499719.adso2499719.repositories.AprendizRepository;

@Service

public class AprendizService implements IAprendizService{

	@Autowired
	private AprendizRepository repository;
	
	@Override
	public List<Aprendiz> getAll() {
		return repository.findAll();
	}

	@Override
	public Aprendiz getById(Long id) throws Exception {
		Optional<Aprendiz> aprendizOptional = repository.findById(id);
		if (aprendizOptional.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		return aprendizOptional.get();
		}

	@Override
	public Aprendiz save(Aprendiz aprendiz) {
		aprendiz.setCreatedAt(LocalDateTime.now());
		return repository.save(aprendiz);
	}

	@Override
	public void update(Long id, Aprendiz aprendiz) 	throws Exception {
		Optional<Aprendiz> AprendizDBOpt = repository.findById(id);
		if (AprendizDBOpt.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		Aprendiz aprendizDB = AprendizDBOpt.get();
		
		aprendizDB.setNombre(aprendiz.getNombre());
		aprendizDB.setApellido(aprendiz.getApellido());
		aprendizDB.setCreatedAt(aprendiz.getCreatedAt());
		
		repository.save(aprendizDB);
	}
	
	@Override
	public void delete(Long id) throws Exception{
		Optional<Aprendiz> aprendizOptional = repository.findById(id);
		if (aprendizOptional.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		repository.deleteById(id);
	}



	
}
