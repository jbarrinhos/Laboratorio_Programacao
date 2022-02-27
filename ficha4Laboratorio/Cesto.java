package ficha4Laboratorio;

import java.util.ArrayList;
import java.util.List;

public class Cesto {

	private static final int capacidadeMaxima = 100;
	private int totalFrutas;

	private List<Fruta> frutas;

	public Cesto() {

		frutas = new ArrayList<Fruta>();

	}

	public void inserirFruta(Fruta aFruta) {

		if (frutas.size() <= capacidadeMaxima) {

			frutas.add(aFruta);

			totalFrutas++;
			System.out.println(aFruta.getNome() + " foi adicionada ao cesto");

		} else {

			System.out.println(" Não é possível adicionar mais fruta - limite excedido");
		}
	}

	public double valorTotalPagar() {

		double valorTotal = 0;

		for (Fruta fruta : frutas) {
			valorTotal += (fruta.pagar());
		}
		return valorTotal;
	}

	/// comparação entre classes

	public int numeroFruta(String tipoFruta) {
		int numero = 0;

		for (Fruta fruta : frutas) {
			if (fruta.getClass().getSimpleName().equals(tipoFruta)) {
				numero += 1;
			}
		}
		return numero;
	}

	public double totalGasto(String tipoFruta) {
		double valorGasto = 0;

		for (Fruta fruta : frutas) {
			if (fruta.getClass().getSimpleName().equals(tipoFruta)) {

				valorGasto += fruta.pagar();
			}

		}

		return valorGasto;
	}

	@Override
	public String toString() {

		return frutas.toString();
	}

	// G&S

	public static int getCapacidademaxima() {
		return capacidadeMaxima;
	}

	public int getTotalFrutas() {
		return totalFrutas;
	}

	public List<Fruta> getFrutas() {
		return frutas;
	}

	public void setTotalFrutas(int totalFrutas) {
		this.totalFrutas = totalFrutas;
	}

	public void setFrutas(List<Fruta> frutas) {
		this.frutas = frutas;
	}

}
