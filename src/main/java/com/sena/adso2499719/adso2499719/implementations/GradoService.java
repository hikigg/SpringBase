package com.sena.adso2499719.adso2499719.implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.entities.Grado;
import com.sena.adso2499719.adso2499719.interfaces.IGradoService;
import com.sena.adso2499719.adso2499719.repositories.GradoRepository;
@Service
public class GradoService implements IGradoService{

	@Autowired
	private GradoRepository repository;
	
	@Override
	public List<Grado> getAll() {
		
		return repository.findAll();
	}

	@Override
	public Grado getById(Long id) throws Exception {
		Optional<Grado> gradoOptional = repository.findById(id);
		if (gradoOptional.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		return gradoOptional.get();
	}
	@Override
	public Grado save(Grado grado) {
		grado.setCreatedAt(LocalDateTime.now());
		return repository.save(grado);
	}

	@Override
	public void update(Long id, Grado grado) throws Exception{
		Optional<Grado> gradoDBOpt = repository.findById(id);
		if (gradoDBOpt.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		Grado gradoDB = gradoDBOpt.get();
		
		gradoDB.setNombre(grado.getNombre());
		gradoDB.setJornada(grado.getJornada());
		gradoDB.setSalon(grado.getSalon());
		gradoDB.setCreatedAt(LocalDateTime.now());
		
		repository.save(gradoDB);
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<Grado> gradoOptional = repository.findById(id);
		if (gradoOptional.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		repository.deleteById(id);
		
	}

	
}
