package ficha3Laboratorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	public ContaBancaria getConta(String titular) {
		for (ContaBancaria conta : contas) {
			if (Objects.equals(conta.getTitular(), titular)) {

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
			if (Objects.equals(aCasa.getMorada(), morada)) {
				casas.remove(aCasa);
				return;
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
