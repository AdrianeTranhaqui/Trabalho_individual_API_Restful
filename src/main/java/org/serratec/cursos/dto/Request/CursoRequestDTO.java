package org.serratec.cursos.dto.Request;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados para cadastro ou atualização de curso")
public class CursoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    @Schema(description = "Nome do curso", example = "Java para Iniciantes")
    private String nome;

    @Size(max = 1000, message = "Descrição deve ter no máximo 1000 caracteres")
    @Schema(description = "Descrição do curso")
    private String descricao;

    @NotNull(message = "Carga horária é obrigatória")
    @Positive(message = "Carga horária deve ser positiva")
    @Schema(description = "Carga horária em horas", example = "40")
    private Integer cargaHoraria;

    @Schema(description = "Data de início", example = "2026-06-01")
    private LocalDate dataInicio;

    @Schema(description = "Data de fim", example = "2026-08-01")
    private LocalDate dataFim;

    @Positive(message = "Preço deve ser positivo")
    @Schema(description = "Preço do curso", example = "99.90")
    private Double preco;

    @NotNull(message = "Professor é obrigatório")
    @Schema(description = "ID do professor responsável", example = "1")
    private Long professorId;

    public String getNome() {
    	return nome; 
    }
    public void setNome(String nome) {
    	this.nome = nome; 
    }

    public String getDescricao() {
    	return descricao; 
    }
    public void setDescricao(String descricao) {
    	this.descricao = descricao; 
    }

    public Integer getCargaHoraria() {
    	return cargaHoraria; 
    }
    public void setCargaHoraria(Integer cargaHoraria) {
    	this.cargaHoraria = cargaHoraria; 
    }

    public LocalDate getDataInicio() {
    	return dataInicio; 
    }
    public void setDataInicio(LocalDate dataInicio) {
    	this.dataInicio = dataInicio; 
    }

    public LocalDate getDataFim() {
    	return dataFim; 
    }
    public void setDataFim(LocalDate dataFim) {
    	this.dataFim = dataFim; 
    }

    public Double getPreco() {
    	return preco; 
    }
    public void setPreco(Double preco) {
    	this.preco = preco; 
    }

    public Long getProfessorId() {
    	return professorId; 
    }
    public void setProfessorId(Long professorId) {
    	this.professorId = professorId; 
    }
}
	
