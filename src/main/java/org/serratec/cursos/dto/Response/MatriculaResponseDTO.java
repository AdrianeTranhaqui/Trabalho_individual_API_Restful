package org.serratec.cursos.dto.Response;

import java.time.LocalDate;

import org.serratec.cursos.Domain.Matricula;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "nomeAluno", "nomeCurso", "dataMatricula", "status", "notaFinal"})
public class MatriculaResponseDTO {

    private Long id;
    private LocalDate dataMatricula;
    private String status;
    private Double notaFinal;
    private String nomeAluno;
    private String nomeCurso;

    public static MatriculaResponseDTO fromEntity(Matricula matricula) {
        MatriculaResponseDTO dto = new MatriculaResponseDTO();
        dto.id = matricula.getId();
        dto.dataMatricula = matricula.getDataMatricula();
        dto.status = matricula.getStatus();
        dto.notaFinal = matricula.getNotaFinal();
        if (matricula.getAluno() != null) dto.nomeAluno = matricula.getAluno().getNome();
        if (matricula.getCurso() != null) dto.nomeCurso = matricula.getCurso().getNome();
        return dto;
    }

    public Long getId() {
    	return id; 
    }
    public LocalDate getDataMatricula() {
    	return dataMatricula; 
    }
    public String getStatus() {
    	return status; 
    }
    public Double getNotaFinal() {
    	return notaFinal; 
    }
    public String getNomeAluno() {
    	return nomeAluno; 
    }
    public String getNomeCurso() {
    	return nomeCurso; 
    }
}
