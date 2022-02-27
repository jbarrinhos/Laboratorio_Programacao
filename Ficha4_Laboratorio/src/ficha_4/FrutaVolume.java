package ficha_4;

public class FrutaVolume extends Fruta implements Descontável {

	private float volume;
	private double percentagem;

	public FrutaVolume(String aNome, double aPrecoBase) {

		super(aNome, aPrecoBase);

	}

	public double pagar() {

		return (volume * getPrecoBase() - descontar(percentagem));
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float aVolume) {
		volume = aVolume;
	}

	@Override
	public double descontar(double percentagem) {

		return (volume * getPrecoBase() * percentagem);
	}

	public void setDescontar(double aPercentagem) {
		percentagem = aPercentagem;
	}

}
