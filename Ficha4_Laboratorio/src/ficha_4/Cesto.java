package ficha_4;

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

	/// ver isto em casa (na String fica o nome da classe, ver como funciona a
	/// comparação entre classes

	public int numeroFruta(String tipoFruta) {

		for (Fruta fruta : frutas) {

			if (fruta.getNome().equals(tipoFruta)) {

				if (fruta instanceof FrutaUnidade) {

					System.out.println("Tem " + ((FrutaUnidade) fruta).getUnidade() + " unidades");
				}

				else if (fruta instanceof FrutaPeso) {
					System.out.println("Tem " + ((FrutaPeso) fruta).getPeso() + " Kgs");
				}

				else if (fruta instanceof FrutaVolume) {
					System.out.println("Tem" + ((FrutaVolume) fruta).getVolume() + " volume");
				}
			}
		}
		return 0;
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
