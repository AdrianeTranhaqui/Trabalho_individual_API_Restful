package org.serratec.cursos.Domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 1000)
    private String descricao;

    @Column(name = "carga_horaria")
    private Integer cargaHoraria;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    private Double preco;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @JsonBackReference(value = "professor-cursos")
    private Professor professor;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "curso-matriculas")
    private List<Matricula> matriculas = new ArrayList<>();

    public Curso(Long id, String nome, String descricao, Integer cargaHoraria, LocalDate dataInicio, LocalDate dataFim,
			Double preco, Professor professor, List<Matricula> matriculas) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.cargaHoraria = cargaHoraria;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.preco = preco;
		this.professor = professor;
		this.matriculas = matriculas;
	}
    
	public Curso() {
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

    public Professor getProfessor() {
    	return professor; 
    }
    public void setProfessor(Professor professor) {
    	this.professor = professor; 
    }

    public List<Matricula> getMatriculas() {
    	return matriculas; 
    }
    public void setMatriculas(List<Matricula> matriculas) {
    	this.matriculas = matriculas; 
    }
}
	

