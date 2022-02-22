package ficha_4;

import java.util.ArrayList;
import java.util.List;

public class Cesto {

	private static final int capacidadeMaxima = 2;
	private int totalFrutas;

	private List<Fruta> frutas;

	public Cesto() {

		frutas = new ArrayList<Fruta>();

	}

	public void inserirFruta(Fruta aFruta) {
		if (frutas.size() <= capacidadeMaxima) {

			frutas.add(aFruta);
			System.out.println(aFruta.getNome() + " foi adicionada ao cesto");
		} else {
			System.out.println("Excedeu o limite");
		}
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
