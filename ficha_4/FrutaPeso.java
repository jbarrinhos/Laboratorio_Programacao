package ficha_4;

public class FrutaPeso extends Fruta {

	private double peso;

	public FrutaPeso(String aNome, double aPrecoBase) {
		super(aNome, aPrecoBase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double pagar() {
		// TODO Auto-generated method stub
		return (precoBase * peso);
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

}
