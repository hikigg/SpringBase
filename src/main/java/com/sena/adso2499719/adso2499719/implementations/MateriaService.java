package com.sena.adso2499719.adso2499719.implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.entities.Materia;
import com.sena.adso2499719.adso2499719.interfaces.IMateriaService;
import com.sena.adso2499719.adso2499719.repositories.MateriaRepository;
@Service
public class MateriaService implements IMateriaService {

	@Autowired
	private MateriaRepository repository;

	@Override
	public List<Materia> getAll() {
		return repository.findAll();
	}

	@Override
	public Materia getById(Long id) throws Exception {
		Optional<Materia> materiaOptional = repository.findById(id); 
		if (materiaOptional.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		return materiaOptional.get();
	}

	@Override
	public Materia save(Materia materia) {
		materia.setCreatedAt(LocalDateTime.now());
		return repository.save(materia);
	}

	@Override
	public void update(Long id, Materia materia) {
		Optional<Materia> materiaDBOpt = repository.findById(id);
		if (materiaDBOpt.isEmpty()) {
			return;
		}
		Materia materiaDB = materiaDBOpt.get();
		materiaDB.setNombre(materia.getNombre());
		materiaDB.setCreatedAt(LocalDateTime.now());
		
		repository.save(materia);
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}
}
