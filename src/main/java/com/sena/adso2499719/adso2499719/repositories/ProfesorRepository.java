package com.sena.adso2499719.adso2499719.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.adso2499719.adso2499719.dtos.ProfesorDatatableDto;
import com.sena.adso2499719.adso2499719.entities.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long>{

	@Query(value = "SELECT\r\n"
			+ "pro.id,\r\n"
			+ " pro.nombres,\r\n"
			+ "pro.apellidos,\r\n"
			+ "esp.nombres as nombreEspecialidad \r\n"
			+ "FROM profesores as pro\r\n"
			+ "INNER JOIN especialidades AS esp ON esp.id = pro.especialidad_id\r\n"
			+ "WHERE CONCAT(pro.nombres, pro.apellidos, esp.nombres) LIKE CONCAT('%', :textobu, '%')", nativeQuery = true)
	Page<ProfesorDatatableDto> getDatatable(Pageable pageable, @Param("textobu") String textoBusqueda);
}
