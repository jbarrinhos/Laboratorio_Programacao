package ficha_4;

public abstract class Fruta {

	protected String nome;
	protected double precoBase;

	public Fruta(String aNome, double aPrecoBase) {
		nome = aNome;
		precoBase = aPrecoBase;
	}

	public abstract double pagar();

	@Override
	public String toString() {

		return nome;
	}

	// Getters e Setters

	public String getNome() {
		return nome;
	}

	public double getPrecoBase() {
		return precoBase;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPrecoBase(double aPrecoBase) {
		this.precoBase = aPrecoBase;
	}

}
