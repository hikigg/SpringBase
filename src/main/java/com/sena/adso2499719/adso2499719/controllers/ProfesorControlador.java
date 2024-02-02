package com.sena.adso2499719.adso2499719.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.adso2499719.adso2499719.dtos.ApiResponseDto;
import com.sena.adso2499719.adso2499719.entities.Profesor;
import com.sena.adso2499719.adso2499719.interfaces.IProfesorService;

@RestController
@RequestMapping("api/profesor")
@CrossOrigin("http://localhost:4200/")
public class ProfesorControlador {
	@Autowired
	private IProfesorService service;
	
	// localhost:8008/api/profesor/datatable?page=0&size=10&column_order=nombres&column_direction=asc
	@GetMapping("datatable")
	public ResponseEntity<Page<?>> datatable(@RequestParam(name = "page") Integer page,
			@RequestParam(name = "size") Integer size,
			@RequestParam(name = "column_order") String columnOrder,
			@RequestParam(name = "column_direction") String columnDirection,
			@RequestParam(name = "search", required = false) String search) {
			List<Order> orders = new ArrayList<>();
			
			if (columnDirection.equals("asc")) {
				orders.add(
						new Order(Direction.ASC, columnOrder) // A-Z
						);
			}else {
				orders.add(
						new Order(Direction.DESC, columnOrder) // Z-A
						);
			}
			
			// orders.add(new Order(columnDirection == "asc" ? Direction.ASC : Direction.DESC, columnOrder ));
			
			if (search == null) {
				search = "";
			}
			return ResponseEntity.ok(service.getDatatable(PageRequest.of(page, size, Sort.by(orders)), search));
			//return ResponseEntity.ok(new ApiResponseDto<Page<?>>("Datos obtenidos",
				//	service.getDatatable(PageRequest.of(page, size, Sort.by(orders)), search), true));
		
	}
	
	@GetMapping
	public ResponseEntity<ApiResponseDto<List<Profesor>>> getAll() {
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<List<Profesor>>("Datos obtenidos", true, service.getAll())
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<List<Profesor>>(e.getMessage(), false, null)
					);
		}
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto<Profesor>> getById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<Profesor>("Datos obtenidos", true, service.getById(id))
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Profesor>(e.getMessage(), false, null)
					);
		}
	}
	
	@PostMapping
	public ResponseEntity<ApiResponseDto<Profesor>> save(@RequestBody Profesor profesor) {
		try {
			return ResponseEntity.ok(
					new ApiResponseDto<Profesor>("Datos guardados", true, service.save(profesor))
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Profesor>(e.getMessage(), false, null)
					);
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ApiResponseDto<Profesor>> update(@PathVariable Long id, @RequestBody Profesor profesor) {
		try {
			service.uptdate(id, profesor);
			return ResponseEntity.ok(
					new ApiResponseDto<Profesor>("Datos actualizados", true, null)
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Profesor>(e.getMessage(), false, null)
					);
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponseDto<Profesor>> delete(@PathVariable Long id) {
		try {
			service.delete(id);
			return ResponseEntity.ok(
					new ApiResponseDto<Profesor>("Datos eliminados", true, null)
					);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(
					new ApiResponseDto<Profesor>(e.getMessage(), false, null)
					);
		}
		
	}
	
	
	
	
	
	
}
