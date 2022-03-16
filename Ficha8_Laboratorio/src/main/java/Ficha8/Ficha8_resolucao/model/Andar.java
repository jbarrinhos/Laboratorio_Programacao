package Ficha8.Ficha8_resolucao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Andar")
public class Andar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)

	private Long id;

	private int numeroAndar;
	private int numeroMaxLojas;

//	-----------------ligações-------------------

	@ManyToOne
	@JoinColumn(name = "CentroComercial_id")

	@JsonIgnore
	private CentroComercial centroComercial;

	@OneToMany(mappedBy = "andares")
	private List<Loja> lojas = new ArrayList<Loja>();

//	---------------Getters e Setters----------------

	public int getNumeroAndar() {
		return numeroAndar;
	}

	public int getNumeroMaxLojas() {
		return numeroMaxLojas;
	}

	public void setNumeroAndar(int aNumeroAndar) {
		numeroAndar = aNumeroAndar;
	}

	public void setNumeroMaxLojas(int aNumeroMaxLojas) {
		numeroMaxLojas = aNumeroMaxLojas;
	}

	public Long getId() {
		return id;
	}

	public CentroComercial getCentroComercial() {
		return centroComercial;
	}

	public void setCentroComercial(CentroComercial aCentroComercial) {
		centroComercial = aCentroComercial;
	}

	public List<Loja> getLojas() {
		return lojas;
	}

	public void setId(Long aId) {
		id = aId;
	}

	public void setLojas(List<Loja> aLojas) {
		lojas = aLojas;
	}

}
