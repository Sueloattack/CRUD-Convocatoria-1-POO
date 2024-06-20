package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Estudiante;
import com.example.demo.models.common.RequestEstudianteDto;
import com.example.demo.repositories.EstudianteRepository;

@Service
public class EstudianteService {
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	private Estudiante mapperEstudiante(RequestEstudianteDto estudiante) {
		
		Estudiante est = new Estudiante();
		est.setNumeroIdentificacion(estudiante.getNumeroIdentificacion());
		est.setTipoDocumento(estudiante.getTipoDocumento());
		est.setApellidos(estudiante.getApellidos());
		est.setNombres(estudiante.getNombres());
		est.setGrupo(estudiante.getGrupo());
		est.setSemestre(estudiante.getSemestre());
		est.setEmail(estudiante.getEmail());
		est.setId(0);
		return est;
	}
	
	public Estudiante save(RequestEstudianteDto estudiante) {
		return estudianteRepository.save(mapperEstudiante(estudiante));
	}
	
	public List<Estudiante> getAll(){
		return (List<Estudiante>) estudianteRepository.findAll();
	}
	
	public Estudiante update(Estudiante estudiante) {
		if(existeEstudiante(estudiante.getId())){
			return estudianteRepository.save(estudiante);	
		}
		return null;
	}
	
	public boolean delete(int Id){
		try {
			return existeEstudiante(Id) ? eliminarEstudiante(Id):false;
		}catch(Exception ex){
			return false;
		}
	}
	
	private boolean existeEstudiante(int Id){
		return estudianteRepository.existsById(Id);
	}
	
	private boolean eliminarEstudiante(int Id) {
		estudianteRepository.deleteById(Id);;
		return true;
	}
}
