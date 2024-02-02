package com.sena.adso2499719.adso2499719.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso2499719.adso2499719.dtos.ApiResponseDto;
import com.sena.adso2499719.adso2499719.entities.Grado;
import com.sena.adso2499719.adso2499719.interfaces.IGradoService;

@RestController
@RequestMapping("api/grado")
public class GradoControlador {
	@Autowired
	private IGradoService service;
	
	@GetMapping
	public ResponseEntity<ApiResponseDto<List<Grado>>> getAll() {
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<List<Grado>>("Datos obtenidos", true, service.getAll())
					);	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<List<Grado>>(e.getMessage(), false, null)	
					);
		}
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto<Grado>> getById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<Grado>("Datos obtenidos", true, service.getById(id))
					);	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Grado>(e.getMessage(), false, null)	
					);
		}
	}
	
	@PostMapping
	public ResponseEntity<ApiResponseDto<Grado>>  save(@RequestBody Grado grado) {
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<Grado>("Datos obtenidos", true, service.save(grado))
					);	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Grado>(e.getMessage(), false, null)	
					);
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ApiResponseDto<Grado>>  update(@PathVariable Long id, @RequestBody Grado grado) throws Exception {
		try {
			service.update(id, grado);
			return ResponseEntity.ok(
					new ApiResponseDto<Grado>("Datos actualizados", true, null)
					);	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Grado>(e.getMessage(), false, null)	
					);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponseDto<Grado>>  delete(@PathVariable Long id) throws Exception{
		try {
			service.delete(id);
			return ResponseEntity.ok(
					new ApiResponseDto<Grado>("Datos Eliminado", true, null)
					);	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Grado>(e.getMessage(), false, null)	
					);
		}
	}
	
}
