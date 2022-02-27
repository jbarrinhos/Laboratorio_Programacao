package ficha4Laboratorio;

public class FrutaUnidade extends Fruta {

	private int unidade;

	public FrutaUnidade(String aNome, double aPrecoBase) {
		super(aNome, aPrecoBase);

	}

	public double pagar() {

		return (precoBase * unidade);
	}

	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int aUnidade) {
		unidade = aUnidade;
	}

}
