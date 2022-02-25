package ficha3;

public class Casa {

	private String morada;
	private double precoCusto;
	private double precoVenda;

	public Casa() {

	}

	public Casa(String aMorada) {

		morada = aMorada;

	}

	public double getMargemLucro() {
		return precoVenda - precoCusto;

	}

	public double getPercentMargemLucro() {
		return ((precoVenda / precoCusto) * 100);

	}

	// G&S

	public String getMorada() {
		return morada;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setMorada(String aMorada) {
		morada = aMorada;
	}

	public void setPrecoCusto(double aPrecoCusto) {
		precoCusto = aPrecoCusto;
	}

	public void setPrecoVenda(double aPrecoVenda) {
		precoVenda = aPrecoVenda;
	}

	public String toString() {
		return "\nmorada: " + morada + "\nprecoCusto: " + precoCusto + "\nprecoVenda: " + precoVenda;
	}

}
