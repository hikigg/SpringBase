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
import com.sena.adso2499719.adso2499719.entities.Materia;
import com.sena.adso2499719.adso2499719.interfaces.IMateriaService;

@RestController
@RequestMapping("api/materia")
public class MateriaControlador {

	@Autowired
	private IMateriaService service;
	
	@GetMapping
	public ResponseEntity<ApiResponseDto<List<Materia>>> getAll() {
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<List<Materia>>("Datos guardados", true, service.getAll())
					);	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<List<Materia>>(e.getMessage(), false, null)	
					);
		}
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto<Materia>> getById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<Materia>("Datos encontrados", true, service.getById(id))
					);	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Materia>(e.getMessage(), false, null)	
					);
		}
	}
	
	@PostMapping
	public ResponseEntity<ApiResponseDto<Materia>> save(@RequestBody Materia materia) {
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<Materia>("Datos guardados", true, service.save(materia))
					);	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Materia>(e.getMessage(), false, null)	
					);
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ApiResponseDto<Materia>> update(@PathVariable Long id, @RequestBody Materia materia) {
		try {
			service.update(id, materia);
			return ResponseEntity.ok(
					new ApiResponseDto<Materia>("Datos actualizados", true, null)
					);	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Materia>(e.getMessage(), false, null)	
					);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponseDto<Materia>> delete(@PathVariable Long id) {
		try {
			service.delete(id);
			return ResponseEntity.ok(
					new ApiResponseDto<Materia>("Datos Eliminado", true, null)
					);	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Materia>(e.getMessage(), false, null)	
					);
	}
	}
}
