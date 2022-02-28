package ficha3;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<ContaBancaria> contas;
	private List<Casa> casas;

	// construtor

	public Banco(String aNome) {
		nome = aNome;
		// limitar para cem itens

		contas = new ArrayList<ContaBancaria>(100);
		casas = new ArrayList<Casa>();

	}

	// conta bancaria

	public void criaConta(ContaBancaria aContaBancaria) {

		contas.add(aContaBancaria);

	}

//maneira correta de usar o equals !!!

	public ContaBancaria getConta(String titular) {
		for (ContaBancaria conta : contas) {

			if (conta.getTitular().equals(titular)) {

				return conta;
			}
		}

		System.out.print("Não existe registo de nenhuma conta com o titular " + titular + " -> ");

		return null;
	}

	// casas

	public void adicionarCasa(Casa aCasa) {
		casas.add(aCasa);
	}

	public void removerCasa(String morada) {
		for (int i = 0; i < casas.size(); i++) {
			Casa aCasa = casas.get(i);
			if (aCasa.getMorada().equals(morada)) {
				casas.remove(aCasa);
			}
		}
	}

	public double getLucroPrevisto() {
		double lucroPrevisto = 0;
		for (Casa casa : casas) {
			lucroPrevisto += casa.getMargemLucro();
		}

		return lucroPrevisto;
	}

	// getter&setter Array

	public List<ContaBancaria> getContas() {

		return contas;
	}

	public void setContas(List<ContaBancaria> contas) {
		this.contas = contas;
	}

	public List<Casa> getCasas() {
		return casas;
	}

	public void setCasas(List<Casa> casas) {
		this.casas = casas;
	}

}
