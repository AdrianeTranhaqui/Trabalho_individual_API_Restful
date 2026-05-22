package org.serratec.cursos.dto.Response;

import java.time.LocalDate;
import org.serratec.cursos.Domain.Curso;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "nome", "descricao", "cargaHoraria", "dataInicio", "dataFim", "preco", "nomeProfessor"})
public class CursoResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Double preco;
    private String nomeProfessor;

    public static CursoResponseDTO fromEntity(Curso curso) {
        CursoResponseDTO dto = new CursoResponseDTO();
        dto.id = curso.getId();
        dto.nome = curso.getNome();
        dto.descricao = curso.getDescricao();
        dto.cargaHoraria = curso.getCargaHoraria();
        dto.dataInicio = curso.getDataInicio();
        dto.dataFim = curso.getDataFim();
        dto.preco = curso.getPreco();
        if (curso.getProfessor() != null) {
            dto.nomeProfessor = curso.getProfessor().getNome();
        }
        return dto;
    }

    public Long getId() {
    	return id; 
    }
    public String getNome() {
    	return nome; 
    }
    public String getDescricao() {
    	return descricao; 
    }
    public Integer getCargaHoraria() {
    	return cargaHoraria; 
    }
    public LocalDate getDataInicio() {
    	return dataInicio; 
    }
    public LocalDate getDataFim() {
    	return dataFim; 
    }
    public Double getPreco() {
    	return preco; 
    }
    public String getNomeProfessor() {
    	return nomeProfessor; 
    }
}
	
