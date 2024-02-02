	package com.sena.adso2499719.adso2499719.implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.dtos.ProfesorDatatableDto;
import com.sena.adso2499719.adso2499719.entities.Profesor;
import com.sena.adso2499719.adso2499719.interfaces.IProfesorService;
import com.sena.adso2499719.adso2499719.repositories.ProfesorRepository;
@Service
public class ProfesorService implements IProfesorService {

	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public Page<ProfesorDatatableDto> getDatatable(Pageable pageable, String textoBusqueda) {
		return repository.getDatatable(pageable, textoBusqueda);
	}

	
	@Override
	public List<Profesor> getAll() {
		return repository.findAll();
	}

	@Override
	public Profesor getById(Long id) throws Exception {
		Optional<Profesor> especialidadOptional = repository.findById(id);
		if (especialidadOptional.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		return especialidadOptional.get();
	}

	@Override
	public Profesor save(Profesor profesor) {
		profesor.setCreatedAt(LocalDateTime.now());
		return repository.save(profesor) ;
	}

	@Override
	public void uptdate(Long id, Profesor profesor) throws Exception {
		Optional<Profesor> profesorDBOpt = repository.findById(id);
		if (profesorDBOpt.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		Profesor profesorDB = profesorDBOpt.get();
		
		profesorDB.setNombre(profesor.getNombre());
		profesorDB.setApellido(profesor.getApellido());
		profesorDB.setCreatedAt(LocalDateTime.now());
		
		repository.save(profesorDB);
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<Profesor> profesorOptional = repository.findById(id);
		if (profesorOptional.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		repository.deleteById(id);
		
	}

	


}
