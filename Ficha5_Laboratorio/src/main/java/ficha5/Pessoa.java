package ficha5;

import java.util.UUID;

public class Pessoa {
	private String nome;
	private String sobrenome;
	private int idade;
	private double saldo;
	private UUID id;

	public Pessoa(String aNome, String aSobrenome, int aIdade, double aSaldo) {

		nome = aNome;
		sobrenome = aSobrenome;
		idade = aIdade;
		saldo = aSaldo;
		id = UUID.randomUUID();
	}

	@Override
	public String toString() {

		return "\nPrimeiro Nome: " + nome + ", Último Nome: " + sobrenome + ", Idade " + idade + ", Saldo " + saldo
				+ ", ID " + id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public int getIdade() {
		return idade;
	}

	public double getSaldo() {
		return saldo;
	}

	public UUID getId() {
		return id;
	}

	public void setNome(String aNome) {
		nome = aNome;
	}

	public void setSobrenome(String aSobrenome) {
		sobrenome = aSobrenome;
	}

	public void setIdade(int aIdade) {
		idade = aIdade;
	}

	public void setSaldo(double aSaldo) {
		saldo = aSaldo;
	}

}
