package com.sena.adso2499719.adso2499719.implementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.adso2499719.adso2499719.entities.Especialidad;
import com.sena.adso2499719.adso2499719.interfaces.IEspecialidadService;
import com.sena.adso2499719.adso2499719.repositories.EspecialidadRepository;

@Service
public class EspecialidadService implements IEspecialidadService {

	@Autowired
	private EspecialidadRepository repository;
	
	@Override
	public List<Especialidad> getAll() {
		return repository.findAll();
	}

	@Override
	public Especialidad getById(Long id) throws Exception {
		Optional<Especialidad> especialidadOptional = repository.findById(id);
		if (especialidadOptional.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		return especialidadOptional.get();
	}

	@Override
	public Especialidad save(Especialidad especialdiad) {
		especialdiad.setCreatedAt(LocalDateTime.now());
		return repository.save(especialdiad);
	}

	@Override
	public void update(Long id, Especialidad especialidad) throws Exception {
		/** 
		 * 1. Tener en cuenta que existen dos especialidades
		 * 	-Especialidad en la base de datos
		 * -- Especialidad en el proyecto
		 * 2. Voy a validar que la especialidad exista con el id actualizando
		 * 3. Reemplazar los datos que se requieran
		 * 4. Actualizar el registro
		 *
		 */
		
		Optional<Especialidad> especialidadDBOpt = repository.findById(id);
		if (especialidadDBOpt.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		Especialidad especialidadDB = especialidadDBOpt.get();
		
		especialidadDB.setNombre(especialidad.getNombre());
		especialidadDB.setUpdateAt(LocalDateTime.now());
		
		repository.save(especialidadDB);
		
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<Especialidad> especialidadOptional = repository.findById(id);
		if (especialidadOptional.isEmpty()) {
			throw new Exception("No se encontro el registro");
		}
		repository.deleteById(id);
		
	}

}
