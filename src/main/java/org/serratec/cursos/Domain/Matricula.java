package org.serratec.cursos.Domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_matricula")
    private LocalDate dataMatricula;

    private String status;

    @Column(name = "nota_final")
    private Double notaFinal;


    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    @JsonBackReference(value = "aluno-matriculas")
    private Aluno aluno;


    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    @JsonBackReference(value = "curso-matriculas")
    private Curso curso;

    @PrePersist
    public void prePersist() {
        this.dataMatricula = LocalDate.now();
        if (this.status == null) this.status = "ATIVA";
    }

    public Matricula(Long id, LocalDate dataMatricula, String status, Double notaFinal, Aluno aluno, Curso curso) {
		super();
		this.id = id;
		this.dataMatricula = dataMatricula;
		this.status = status;
		this.notaFinal = notaFinal;
		this.aluno = aluno;
		this.curso = curso;
	}

	public Matricula() {
		super();
	}

	public Long getId() {
		return id; 
	}
    public void setId(Long id) {
    this.id = id; 
    }

    public LocalDate getDataMatricula() {
    	return dataMatricula; 
    }
    public void setDataMatricula(LocalDate dataMatricula) {
    	this.dataMatricula = dataMatricula; 
    }

    public String getStatus() {
    	return status; 
    }
    public void setStatus(String status) {
    	this.status = status; 
    }

    public Double getNotaFinal() {
    	return notaFinal; 
    }
    public void setNotaFinal(Double notaFinal) {
    	this.notaFinal = notaFinal; 
    }

    public Aluno getAluno() {
    	return aluno; 
    }
    public void setAluno(Aluno aluno) {
    	this.aluno = aluno; 
    }

    public Curso getCurso() {
    	return curso; 
    }
    public void setCurso(Curso curso) {
    	this.curso = curso; 
    }
}

