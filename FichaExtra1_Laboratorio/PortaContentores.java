package fichaExtra;

import java.util.Date;

public class PortaContentores extends Navio {
	private int numMaxContentores;

//	construtor

	public PortaContentores(String aIdentificador, String aNome, Date aAnoConstrucao, float aComprimento,
			int aNumMaxContentores) {
		super(aIdentificador, aNome, aAnoConstrucao, aComprimento);
		numMaxContentores = aNumMaxContentores;
	}

//	Getter e Setter

	public int getNumMaxContentores() {
		return numMaxContentores;
	}

	public void setNumMaxContentores(int numMaxContentores) {
		this.numMaxContentores = numMaxContentores;
	}

}
