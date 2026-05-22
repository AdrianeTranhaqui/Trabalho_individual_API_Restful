package org.serratec.cursos.dto.Request;

import org.serratec.cursos.Enum.Escolaridade;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Dados para cadastro do perfil social do aluno")
public class PerfilSocialRequestDTO {


    @NotBlank(message = "Renda familiar é obrigatória")
    @Schema(description = "Faixa de renda familiar", example = "Até 2 salários mínimos")
    private String rendaFamiliar;

    @NotNull(message = "Escolaridade é obrigatória")
    @Schema(description = "Nível de escolaridade", example = "Ensino_Fundamental_Completo")
    private Escolaridade escolaridade;

    @NotNull(message = "ID do aluno é obrigatório")
    @Schema(description = "ID do aluno vinculado", example = "1")
    private Long alunoId;

	public String getRendaFamiliar() {
		return rendaFamiliar;
	}

	public void setRendaFamiliar(String rendaFamiliar) {
		this.rendaFamiliar = rendaFamiliar;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

    
}

