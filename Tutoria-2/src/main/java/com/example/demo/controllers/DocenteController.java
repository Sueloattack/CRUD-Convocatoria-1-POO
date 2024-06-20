package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DuplicateIdentificationException;
import com.example.demo.models.Docente;
import com.example.demo.models.common.RequestDocenteDto;
import com.example.demo.models.common.Response;
import com.example.demo.services.DocenteService;
import io.swagger.v3.oas.annotations.Operation;



@RestController
@RequestMapping("/docente")
public class DocenteController{
	
	@Autowired
	private DocenteService docenteService;
	
    @PostMapping
    @Operation(summary = "Ingresa un nuevo docente", description = "Ingresa un nuevo docente a la base de datos")
    public ResponseEntity<?> save(@RequestBody RequestDocenteDto docente) {
        try {
            Docente savedDocente = docenteService.save(docente);
            return ResponseEntity.ok(savedDocente);
        } catch (DuplicateIdentificationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor, por favor intente nuevamente.");
        }
    }

    @ExceptionHandler(DuplicateIdentificationException.class)
    public ResponseEntity<String> handleDuplicateIdentificationException(DuplicateIdentificationException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

	
	@GetMapping
	@Operation(summary = "Listar docentes", description = "Muestra los docentes registrados y su informacion por ID")
    public ResponseEntity<?> getAll() {
        List<Docente> docentes = docenteService.getAll();
        if (docentes.isEmpty()) {
            return ResponseEntity.ok("No se encuentran docentes registrados");
        } else {
            return ResponseEntity.ok(docentes);
        }
    }
	
	@PutMapping
	@Operation(summary = "Actualizar datos del docente", description = "Actualiza la informacion registrada del docente")
	public ResponseEntity<Object> update(@RequestBody Docente docente){
		
		var docenteActualizado = docenteService.update(docente);
		
		if(docenteService.update(docente)==null) {
			return ResponseEntity.ok(new Response<>("No se encontro docente"));
		}		
		return ResponseEntity.ok(new Response<>("Docente actualizado", docenteActualizado));
	}
	
	@DeleteMapping("/{Id}")
	@Operation(summary = "Eliminar docente", description = "Eliminar un docente por ID")
	public ResponseEntity<Object> delete(@PathVariable("Id") int Id){
		
		var docenteEliminado = docenteService.delete(Id);
		
		if(docenteEliminado) {
			return ResponseEntity.ok(new Response<>("Docente eliminado"));
		}else {
			return ResponseEntity.ok(new Response<>("Docente no encontrado"));
		}
	}
		
}