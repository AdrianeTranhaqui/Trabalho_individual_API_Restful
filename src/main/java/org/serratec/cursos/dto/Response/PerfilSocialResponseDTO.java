package org.serratec.cursos.dto.Response;

import org.serratec.cursos.Domain.PerfilSocial;
import org.serratec.cursos.Enum.Escolaridade;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "nomeAluno", "linkedin", "github", "instagram", "rendaFamiliar", "escolaridade"})
public class PerfilSocialResponseDTO {

    private Long id;
    private String rendaFamiliar;
    private Escolaridade escolaridade;
    private String nomeAluno;

    public static PerfilSocialResponseDTO fromEntity(PerfilSocial perfil) {
        PerfilSocialResponseDTO dto = new PerfilSocialResponseDTO();
        dto.id = perfil.getId();
        dto.rendaFamiliar = perfil.getRendaFamiliar();
        dto.escolaridade = perfil.getEscolaridade();
        if (perfil.getAluno() != null) dto.nomeAluno = perfil.getAluno().getNome();
        return dto;
    }

	public Long getId() {
		return id;
	}

	public String getRendaFamiliar() {
		return rendaFamiliar;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

}

