package ficha_4;

public class FrutaVolume extends Fruta implements Descontável {

	private float volume;
	private double percentagem;

	public FrutaVolume(String aNome, double aPrecoBase) {

		super(aNome, aPrecoBase);

	}

	public double pagar() {

		return (precoBase * volume);
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float aVolume) {
		volume = aVolume;
	}

	@Override
	public double descontar(double percentagem) {
		// testado na main com numero inteiro (25)

		return (precoBase * (percentagem / 100));
	}

	public void setDescontar(double aPercentagem) {
		percentagem = aPercentagem;
	}

}
