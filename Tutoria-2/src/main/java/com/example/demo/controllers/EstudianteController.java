package com.example.demo.controllers;

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
import com.example.demo.models.Estudiante;
import com.example.demo.models.common.RequestEstudianteDto;
import com.example.demo.models.common.Response;
import com.example.demo.services.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/estudiante")
public class EstudianteController{
	
	@Autowired
	private EstudianteService estudianteService;
	
	@PostMapping
	@Operation(summary = "Ingresa un nuevo estudiante", description = "Ingresa un nuevo estudiante a la base de datos")
	public ResponseEntity<Estudiante>save(@RequestBody RequestEstudianteDto estudiante){
		return ResponseEntity.ok(estudianteService.save(estudiante));
	}
	
	@GetMapping
	@Operation(summary = "Listar estudiantes", description = "Muestra los estudiantes registrados y su informacion por ID")
	public ResponseEntity<List<Estudiante>> getAll(){
		return ResponseEntity.ok(estudianteService.getAll());
	}
	
	@PutMapping
	@Operation(summary = "Actualizar datos del estudiante", description = "Actualiza la informacion registrada del estudiante")
	public ResponseEntity<Object> update(@RequestBody Estudiante estudiante){
		
		var estudianteActualizado = estudianteService.update(estudiante);
		
		if(estudianteService.update(estudiante)==null) {
			return ResponseEntity.ok(new Response<>("No se encontro estudiante"));
		}		
		return ResponseEntity.ok(new Response<>("Estudiante actualizado", estudianteActualizado));
	}
	
	@DeleteMapping("/{Id}")
	@Operation(summary = "Eliminar estudiante", description = "Eliminar un estudiante por ID")
	public ResponseEntity<Object> delete(@PathVariable("Id") int Id){
		
		var estudianteEliminado = estudianteService.delete(Id);
		
		if(estudianteEliminado) {
			return ResponseEntity.ok(new Response<>("Estudiante eliminado"));
		}else {
			return ResponseEntity.ok(new Response<>("Estudiante no se ha eliminado"));
		}
	}
	
}