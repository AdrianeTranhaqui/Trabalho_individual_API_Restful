package org.serratec.cursos.dto.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Dados para criação de matrícula")
public class MatriculaRequestDTO {

    @NotNull(message = "ID do aluno é obrigatório")
    @Schema(description = "ID do aluno", example = "1")
    private Long alunoId;

    @NotNull(message = "ID do curso é obrigatório")
    @Schema(description = "ID do curso", example = "1")
    private Long cursoId;

    @Schema(description = "Status da matrícula", example = "ATIVA")
    private String status;

    public Long getAlunoId() {
    	return alunoId; 
    }
    public void setAlunoId(Long alunoId) {
    	this.alunoId = alunoId; 
    }

    public Long getCursoId() {
    	return cursoId; 
    }
    public void setCursoId(Long cursoId) {
    	this.cursoId = cursoId; 
    }

    public String getStatus() {
    	return status; 
    }
    public void setStatus(String status) {
    	this.status = status; 
    }
}
