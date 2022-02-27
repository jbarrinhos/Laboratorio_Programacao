package ficha3;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TestarFuncoesContaBancaria {

	public static void main(String[] args) throws ParseException {

		List<ContaBancaria> contas = new ArrayList<>();

		ContaBancaria contaJose = new ContaBancaria("José Fonseca");
		ContaBancaria contaJoana = new ContaBancaria("Joana Pinto");
		ContaBancaria contaAna = new ContaBancaria("Ana Bela");
		ContaBancaria contaJoao = new ContaBancaria("João Falcão");

		contas.add(contaJose);
		contas.add(contaJoana);
		contas.add(contaAna);
		contas.add(contaJoao);

		System.out.println("------Abertura de conta------\n ");

		// tentativa informação da conta

		System.out.println(contaJose.getInformacaoConta());

		System.out.println("\n------Despositar dinheiro na conta------ \n ");

		// Depositar dinheiro

		contaJose.depositar();

//		System.out.println("Saldo Disponivel: " + contaJose.getSaldo());

		System.out.println("\n------Levantar dinheiro e atualizar saldo na conta------\n ");

		// teste a verificar se a data funciona-depois tirar

		contaJose.levantar();

//		System.out.println("Saldo Disponivel: " + contaJose.getSaldo());

		System.out.println("\n------Verificar a conta do jose ------\n ");

		System.out.println(contaJose.getInformacaoConta());

		// verificar o titular da conta
		System.out.println("\n------Verificar o titular da conta ------\n ");

		Banco banco = new Banco("Milenium");

		banco.criaConta(contaJose);
		banco.criaConta(contaJoao);
		banco.criaConta(contaAna);
		banco.criaConta(contaJoana);

		/// questão! como colocar a aprecer os dados do "jose" e da "ana"?
		System.out.println(banco.getConta("José Fonseca"));
		System.out.println(banco.getConta("Jess"));
		System.out.println(banco.getConta("Alberto"));
		System.out.println(banco.getConta("Ana Bela"));

		/// Criar casas

		Casa casa0 = new Casa();

		Casa casa1 = new Casa("Caminho do Pico");
		casa1.setPrecoCusto(95_000);
		casa1.setPrecoVenda(120_000);

		System.out.println("\n------As casas ------\n ");

		System.out.println("\ndados: casa 1: " + casa1);

		Casa casa2 = new Casa("Quinta Rodrigues");
		casa2.setPrecoCusto(125_000);
		casa2.setPrecoVenda(300_000);

		System.out.println("\n" + casa0);
		System.out.println("\n" + casa1);
		System.out.println("\nQuinta: " + casa2.getMorada() + "\ntem um lucro de: " + casa2.getMargemLucro()
				+ "\ncorrespondente a: " + casa2.getPercentMargemLucro() + "%");

		// remove casas

		banco.adicionarCasa(casa0);
		banco.adicionarCasa(casa1);
		banco.adicionarCasa(casa2);

		System.out.println("\nRemover uma casa, antes/depois");
		System.out.println("\n" + banco.getCasas());
		banco.removerCasa("Caminho do Pico");
		System.out.println("\n" + banco.getCasas());
		System.out
				.println("\nLucro previsto: " + banco.getLucroPrevisto() + " (" + banco.getCasas().size() + " casas)");
		System.out.println(casa1);
	}

}
