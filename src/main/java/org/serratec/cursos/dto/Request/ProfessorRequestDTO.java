package org.serratec.cursos.dto.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados para cadastro ou atualização de professor")
public class ProfessorRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    @Schema(description = "Nome completo do professor", example = "Carlos Souza")
    private String nome;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    @Schema(description = "E-mail do professor", example = "carlos@email.com")
    private String email;

    @NotBlank(message = "Especialidade é obrigatória")
    @Schema(description = "Especialidade do professor", example = "Desenvolvimento Web")
    private String especialidade;

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\)\\s?\\d{4,5}-\\d{4}", message = "Telefone inválido. Use o formato (99) 99999-9999")
    @Schema(description = "Telefone do professor", example = "(21) 98888-7777")
    private String telefone;

    public String getNome() {
    	return nome; 
    }
    public void setNome(String nome) {
    	this.nome = nome; 
    }

    public String getEmail() {
    	return email; 
    }
    public void setEmail(String email) {
    	this.email = email; 
    }

    public String getEspecialidade() {
    	return especialidade; 
    }
    public void setEspecialidade(String especialidade) {
    	this.especialidade = especialidade; 
    }

    public String getTelefone() {
    	return telefone; 
    }
    public void setTelefone(String telefone) {
    	this.telefone = telefone; 
    }
}
