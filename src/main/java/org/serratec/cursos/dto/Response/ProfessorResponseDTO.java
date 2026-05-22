package org.serratec.cursos.dto.Response;

import org.serratec.cursos.Domain.Professor;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "nome", "email", "especialidade", "telefone"})
public class ProfessorResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String especialidade;
    private String telefone;

    public static ProfessorResponseDTO fromEntity(Professor professor) {
        ProfessorResponseDTO dto = new ProfessorResponseDTO();
        dto.id = professor.getId();
        dto.nome = professor.getNome();
        dto.email = professor.getEmail();
        dto.especialidade = professor.getEspecialidade();
        dto.telefone = professor.getTelefone();
        return dto;
    }

    public Long getId() {
    	return id; 
    }
    public String getNome() {
    	return nome; 
    }
    public String getEmail() {
    	return email; 
    }
    public String getEspecialidade() {
    	return especialidade; 
    }
    public String getTelefone() {
    	return telefone; 
    }
}

