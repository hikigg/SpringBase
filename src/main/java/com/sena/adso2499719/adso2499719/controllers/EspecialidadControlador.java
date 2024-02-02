package com.sena.adso2499719.adso2499719.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso2499719.adso2499719.dtos.ApiResponseDto;
import com.sena.adso2499719.adso2499719.entities.Especialidad;
import com.sena.adso2499719.adso2499719.interfaces.IEspecialidadService;

@RestController
@RequestMapping("api/especialidad")
@CrossOrigin("http://localhost:4200/")

public class EspecialidadControlador {

	@Autowired
	private IEspecialidadService service;
	
	// GET solo por URL api/especialidad;
	// POST URL - CUERPO DE LA PETICION
	// PUT
	// DELETE
	
	// BUSCAR TODO
	@GetMapping
	public ResponseEntity<ApiResponseDto<List<Especialidad>>> getAll() {
		ApiResponseDto<List<Especialidad>> respuesta = new ApiResponseDto<List<Especialidad>>();
		try {
			// forma larga
			respuesta.setStatus(true);
			respuesta.setMessage("Datos obtenidos");
			respuesta.setData(service.getAll());
			return ResponseEntity.ok(respuesta);	
		} catch (Exception e) {
			respuesta.setStatus(false);
			respuesta.setMessage(e.getMessage());
			return ResponseEntity.internalServerError().body(respuesta);
		}
		
	}

	
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto<Especialidad>> getById(@PathVariable Long id) {
		try {	
			return ResponseEntity.ok(
					new ApiResponseDto<Especialidad>("Datos encontrado", true, service.getById(id))
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Especialidad>(e.getMessage(), false, null)
				);
		}
	}
	
	@PostMapping
	public ResponseEntity<ApiResponseDto<Especialidad>> save(@RequestBody Especialidad especialidad) {
		return ResponseEntity.ok(
				new ApiResponseDto<Especialidad>("Datos guardados", true, service.save(especialidad))
			);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ApiResponseDto<Especialidad>> update(@PathVariable Long id, @RequestBody Especialidad especialidad) throws Exception {
		try {
			service.update(id, especialidad);
			return ResponseEntity.ok(new ApiResponseDto<Especialidad>("Datos actualizados", true, null));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<Especialidad>(e.getMessage(), false, null));
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponseDto<Especialidad>> delete(@PathVariable Long id){
		try {
			service.delete(id);
			return ResponseEntity.ok(
					new ApiResponseDto<Especialidad>("Datos eliminados", true, null)
				);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<Especialidad>(e.getMessage(), false, null));
		}
	}
	
}
