package ficha_4;

public class FrutaPeso extends Fruta implements Descontável {

	private float peso;
	private double percentagem;

	public FrutaPeso(String aNome, double aPrecoBase) {
		super(aNome, aPrecoBase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double pagar() {
		// TODO Auto-generated method stub
		return (precoBase * peso);
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float aPeso) {
		peso = aPeso;

	}

	@Override
	public double descontar(double percentagem) {

		// testado na main com número decimal (0.2d)
		return (precoBase * percentagem);

	}

	public void setDescontar(double aPercentagem) {
		percentagem = aPercentagem;
	}

}
