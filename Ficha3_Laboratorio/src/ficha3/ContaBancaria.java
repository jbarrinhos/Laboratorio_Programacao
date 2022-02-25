package ficha3;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ContaBancaria {

	private String titular;
	private double saldo;
	private Date dataAbertura;

	// construtor

	public ContaBancaria(String aTitular) {

		titular = aTitular;
		saldo = 0.0;
		dataAbertura = new Date();

	}

	public String getInformacaoConta() {

		// formatar o Saldo
		DecimalFormat formatarSaldo = new DecimalFormat("0.00");

		// formatar a Data

		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/YYYY");

		return "nome: " + titular + "\nsaldo em conta: €" + formatarSaldo.format(saldo)
				+ "\nData de Abertura da Conta: " + formatarData.format(dataAbertura);
	}

	public void depositar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Qual o valor da quantia que vai depositar? ");
		double valorDepositar = scanner.nextDouble();

		saldo += valorDepositar;

		System.out.println("Saldo disponível: " + getSaldo() + " € na sua conta");

	}

	public void levantar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Qual a quantia que pertende levantar? ");
		double valorLevantar = scanner.nextDouble();

		if (valorLevantar > saldo) {
			System.out.println("Não tem dinheiro suficiente!!!!");
			return;
		}

		saldo -= valorLevantar;
		System.out.println("Saldo Disponivel: " + getSaldo());
	}

	public String toString() {
		return "Conta de: " + titular + "\nSaldo: " + saldo;
	}

//getters e setters

	public String getTitular() {
		return titular;
	}

	public Date getDataAbertura() {
		return dataAbertura;

	}

	public double getSaldo() {
		return saldo;

	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
