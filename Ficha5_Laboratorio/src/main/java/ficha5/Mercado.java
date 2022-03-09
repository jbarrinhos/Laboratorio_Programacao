package ficha5;

import java.util.ArrayList;
import java.util.List;

public class Mercado {

	private List<Pessoa> pessoas;
	private String nome;

	public Mercado(String aNome) {
		nome = aNome;
		pessoas = new ArrayList<Pessoa>();

	}

	public void inserirPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}

	public void inserirPessoaJson(ArrayList<Pessoa> arrayList) {
		pessoas.addAll(arrayList);

	}

	public double valorTotalAcumulado() {
		double valor = 0;

		for (Pessoa pessoa : pessoas) {
			valor += pessoa.getSaldo();
		}

		return valor;

	}

	public String toString() {
		return "Mercado [Nome=" + nome + ", \nPessoa=" + pessoas + "]";
	}

}
