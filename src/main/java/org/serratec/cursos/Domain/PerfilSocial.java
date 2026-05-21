package org.serratec.cursos.Domain;

import org.serratec.cursos.Enum.Escolaridade;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "perfil_social")
public class PerfilSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "renda_familiar")
    private String rendaFamiliar;

    @Column(name = "escolaridade")
    @Enumerated(EnumType.STRING)
    private Escolaridade escolaridade;

    @OneToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    @JsonBackReference
    private Aluno aluno;

	public PerfilSocial(Long id, String rendaFamiliar, Escolaridade escolaridade, Aluno aluno) {
		super();
		this.id = id;
		this.rendaFamiliar = rendaFamiliar;
		this.escolaridade = escolaridade;
		this.aluno = aluno;
	}

	public PerfilSocial() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

    
}
