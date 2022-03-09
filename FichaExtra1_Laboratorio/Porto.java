package fichaExtra;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Porto {

	private String nome;
	private int capacidadeTotal;
	private List<Navio> navios;

	public Porto(String aNome) {
		nome = aNome;
		navios = new ArrayList<>();

	}

//	método que permite adicionar um novo navio sem que haja Identificadores do navio repetidos;

	public void adicionarNavio(Navio aNavio) {

		for (Navio navio : navios) {
			if (navio.getIdentificador().equals(aNavio.getIdentificador())) {
				aNavio.setIdentificador(String.valueOf(UUID.randomUUID()));
			}
		}
		navios.add(aNavio);
	}

	// método que devolvee a quantidade máxima total de contentores de todos os
	// navios porta-contentores que estão atracados no porto

	public int capacidadeMax() {
		int capMax = 0;
		for (Navio navio : navios) {

			if (navio instanceof PortaContentores) {
				int capNavio = ((PortaContentores) navio).getNumMaxContentores();
				capMax += capNavio;
			}
		}

		return capMax;
	}

	// método que devolve a capacidade total de carga de todos os navios atracados
	// no porto, sabendo que um contentor tem capacidade máxima de
	// 10 toneladas;

	public float capacidadeTotal() {
		int capacidadeTotal = 0;

		int capacidadeContentor = capacidadeMax() * 10;
		for (Navio navio : navios) {

			if (navio instanceof Petroleiro) {

				float capacidadePetroleiro = ((Petroleiro) navio).getCapacidadeCarga();
				capacidadeTotal += capacidadePetroleiro;
			}
		}

		return (capacidadeTotal + capacidadeContentor);
	}

	@Override
	public String toString() {
		return "Porto [\nnome:" + nome + ", capacidadeTotal: " + capacidadeTotal + ", navios:\n" + navios;
	}

	public String getNome() {
		return nome;
	}

	public int getCapacidadeTotal() {
		return capacidadeTotal;
	}

	public List<Navio> getNavios() {
		return navios;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCapacidadeTotal(int capacidadeTotal) {
		this.capacidadeTotal = capacidadeTotal;
	}

	public void setNavios(List<Navio> navios) {
		this.navios = navios;
	}

}
