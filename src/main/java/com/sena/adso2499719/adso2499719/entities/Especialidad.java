package com.sena.adso2499719.adso2499719.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "especialidades")

public class Especialidad {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	
	private Long id;
	
	@Column(name = "nombres", length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "created_at", nullable = false )
	private LocalDateTime createdAt;
	
	
	@Column(name = "update_at"  )
	private LocalDateTime updateAt;
	
	@Column(name = "deleted_at" )
	private LocalDateTime deletedAt;

	@Column(name = "daniel")
	private String daniel;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

}
