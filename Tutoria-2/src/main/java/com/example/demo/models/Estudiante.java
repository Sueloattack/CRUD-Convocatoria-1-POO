package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(nullable = false , unique = true)						
	private int id;
	
	@Column(length = 20, nullable = false)
	private String tipoDocumento;
	    
	@Column(length = 20, nullable = false, unique = false)
    private String numeroIdentificacion;
	    
	@Column(length = 50, nullable = false)
	private String nombres;
	    
    @Column(length = 50, nullable = false)
    private String apellidos;
	    
    @Column(length = 50, nullable = false)
    private String grupo;
    
    @Column(length = 50, nullable = false)
    private String semestre;
	   
    @Column(length = 100)
    private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
					