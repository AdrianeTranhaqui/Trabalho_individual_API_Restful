package org.serratec.cursos.dto.Request;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados para cadastro ou atualização de aluno")
public class AlunoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    @Schema(description = "Nome completo do aluno", example = "Maria da Silva")
    private String nome;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    @Schema(description = "E-mail do aluno", example = "maria@email.com")
    private String email;

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\)\\s?\\d{4,5}-\\d{4}", message = "Telefone inválido. Use o formato (99) 99999-9999")
    @Schema(description = "Telefone do aluno", example = "(21) 99999-9999")
    private String telefone;

    @Past(message = "Data de nascimento deve ser no passado")
    @Schema(description = "Data de nascimento", example = "2000-05-15")
    private LocalDate dataNascimento;

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

    public String getTelefone() {
    	return telefone; 
    }
    public void setTelefone(String telefone) {
    	this.telefone = telefone; 
    }

    public LocalDate getDataNascimento() {
    	return dataNascimento; 
    }
    public void setDataNascimento(LocalDate dataNascimento) {
    	this.dataNascimento = dataNascimento; 
    }
}
    
    

