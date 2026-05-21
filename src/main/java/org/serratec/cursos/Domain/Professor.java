package org.serratec.cursos.Domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String especialidade;

    @Column(nullable = false, length = 20)
    private String telefone;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "professor-cursos")
    private List<Curso> cursos = new ArrayList<>();

    public Professor(Long id, String nome, String email, String especialidade, String telefone, List<Curso> cursos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.especialidade = especialidade;
		this.telefone = telefone;
		this.cursos = cursos;
	}
    
	public Professor() {
		super();
	}

	public Long getId() {
		return id; 
	}
    public void setId(Long id) {
    	this.id = id; 
    }

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

    public List<Curso> getCursos() {
    	return cursos; 
    }
    public void setCursos(List<Curso> cursos) {
    	this.cursos = cursos; 
    }
}

