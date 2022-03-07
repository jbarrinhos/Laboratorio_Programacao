package ficha5;

public class Main {

	public static void main(String[] args) {

		Pessoa joao = new Pessoa("João", "Freitas", 23, 750);
		Pessoa maria = new Pessoa("Maria", "Abreu", 31, 1400.5);

		System.out.println("Dados do João: " + joao);
		System.out.println("Id do João: " + joao.getId());

		System.out.println("\nDados da Maria: " + maria);
		System.out.println("Id da Maria: " + maria.getId());

		Mercado mercado = new Mercado("Lavradores");

		mercado.inserirPessoa(joao);
		mercado.inserirPessoa(maria);
		joao.setSaldo(850);
		maria.setSaldo(1500);

		System.out.println("\nValor total acumulado: " + mercado.valorTotalAcumulado());

		//

		LoadFromFile loadFFile = new LoadFromFile();

		mercado.inserirPessoaJson(loadFFile.obterInformacaoFicheiro("Pessoas.json"));

		System.out.println(mercado);
	}

}
