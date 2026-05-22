package org.serratec.cursos.dto.Response;

import java.time.LocalDate;

import org.serratec.cursos.Domain.Aluno;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "nome", "email", "telefone", "dataNascimento", "createdAt"})
public class AlunoResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDate createdAt;

    public static AlunoResponseDTO fromEntity(Aluno aluno) {
        AlunoResponseDTO dto = new AlunoResponseDTO();
        dto.id = aluno.getId();
        dto.nome = aluno.getNome();
        dto.email = aluno.getEmail();
        dto.telefone = aluno.getTelefone();
        dto.dataNascimento = aluno.getDataNascimento();
        dto.createdAt = aluno.getCreatedAt();
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
    public String getTelefone() {
    	return telefone; 
    }
    public LocalDate getDataNascimento() {
    	return dataNascimento; 
    }
    public LocalDate getCreatedAt() {
    	return createdAt; 
    }
}
