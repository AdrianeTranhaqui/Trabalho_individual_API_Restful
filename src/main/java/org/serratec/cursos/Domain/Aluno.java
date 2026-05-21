package org.serratec.cursos.Domain;

import java.time.LocalDate;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
    @JsonManagedReference
    private PerfilSocial perfilSocial;


    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "aluno-matriculas")
    private List<Matricula> matriculas = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }
    
    public Aluno(Long id, String nome, String email, String telefone, LocalDate dataNascimento, LocalDate createdAt,
			PerfilSocial perfilSocial, List<Matricula> matriculas) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.createdAt = createdAt;
		this.perfilSocial = perfilSocial;
		this.matriculas = matriculas;
	}

	public Aluno() {
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

    public LocalDate getCreatedAt() {
    	return createdAt; 
    }
    public void setCreatedAt(LocalDate createdAt) {
    	this.createdAt = createdAt; 
    }

    public PerfilSocial getPerfilSocial() {
    	return perfilSocial; 
    }
    public void setPerfilSocial(PerfilSocial perfilSocial) {
    	this.perfilSocial = perfilSocial; 
    }

    public List<Matricula> getMatriculas() {
    	return matriculas; 
    }
    public void setMatriculas(List<Matricula> matriculas) {
    	this.matriculas = matriculas; }
}
		

	


	
	

