package Ficha8.Ficha8_resolucao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Loja")

public class Loja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)

	private Long id;

	private String nome;
	private int numeroFuncionarios;
	private int area;

//	-------------ligação--------------

	@ManyToOne
	@JoinColumn(name = "Andar_id")

	@JsonIgnore
	private Andar andares;

//	-----------Getters e Setters------------

	public String getNome() {
		return nome;
	}

	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public int getArea() {
		return area;
	}

	public void setNomeString(String aNome) {
		nome = aNome;
	}

	public void setNumeroFuncionarios(int aNumeroFuncionarios) {
		numeroFuncionarios = aNumeroFuncionarios;
	}

	public void setArea(int aArea) {
		area = aArea;
	}

	public Long getId() {
		return id;
	}

	public Andar getAndares() {
		return andares;
	}

	public void setNome(String aNome) {
		nome = aNome;
	}

	public void setAndares(Andar aAndares) {
		andares = aAndares;
	}

	public void setId(Long aId) {
		id = aId;
	}

}
