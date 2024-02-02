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
import com.sena.adso2499719.adso2499719.entities.Aprendiz;
import com.sena.adso2499719.adso2499719.interfaces.IAprendizService;

@RestController
@RequestMapping("api/aprendiz")

public class AprendizControlador {
	
	@Autowired
	private IAprendizService service;
	
	@GetMapping
	public ResponseEntity<ApiResponseDto<List<Aprendiz>>> getAll() {
		ApiResponseDto<List<Aprendiz>> respuesta = new ApiResponseDto<List<Aprendiz>>();
		try {
			respuesta.setStatus(true);
			respuesta.setMessage("Datos Obtenidos");
			respuesta.setData(service.getAll());
			return ResponseEntity.ok(respuesta);	
		} catch (Exception e) {
			respuesta.setStatus(false);
			respuesta.setMessage(e.getMessage());
			return ResponseEntity.internalServerError().body(respuesta);
		}
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto<Aprendiz>> getById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<Aprendiz>("Datos encontrados", true, service.getById(id))
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Aprendiz>(e.getMessage(), false, null)
					);
		}
	}
	
	@PostMapping
	public ResponseEntity<ApiResponseDto<Aprendiz>> save(@RequestBody Aprendiz aprendiz ) {
		try {
			return ResponseEntity.ok( new ApiResponseDto<Aprendiz>("Datos guardado", true, service.save(aprendiz))
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<Aprendiz>(e.getMessage(), false, null));
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ApiResponseDto<Aprendiz>> update(@PathVariable Long id, @RequestBody Aprendiz aprendiz) {
		try {
			service.update(id, aprendiz);
			return ResponseEntity.ok(new ApiResponseDto<Aprendiz>("Datos actualizados", true, null));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<Aprendiz>(e.getMessage(), false, null));
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponseDto<Aprendiz>> delete(@PathVariable Long id) {
		try {
			service.delete(id);
			return ResponseEntity.ok(
					new ApiResponseDto<Aprendiz>("Datos eliminados", true, null)
				);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new ApiResponseDto<Aprendiz>(e.getMessage(), false, null));
		}
	}
}

