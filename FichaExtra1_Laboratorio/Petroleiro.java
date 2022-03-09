package fichaExtra;

import java.util.Date;

public class Petroleiro extends Navio {
	private float capacidadeCarga;

//	construtor

	public Petroleiro(String aIdentificador, String aNome, Date aAnoConstrucao, float aComprimento,
			float aCapacidadeCarga) {
		super(aIdentificador, aNome, aAnoConstrucao, aComprimento);
		capacidadeCarga = aCapacidadeCarga;
	}

//	Getter e Setter
	public float getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(float capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}

}
