package segundaFicha;

import java.text.Normalizer;
import java.util.Scanner;

public class Operacoes {
	static Scanner pedir = new Scanner(System.in);

	public static void main(String[] args) {

		// aqui chamo as funções criadas em baixo no "static void"

//		printAreaTriangulo();
//		printAreaRetangulo();
//		printCalcArea();
		calcularFactorial();
//		System.out.print(factorialRecursivo(6));
//		totalVogais();
//		anual(3601);
//		anual(8551);
//		numeroVogais("Eu sou uma arvore");
//		numeroVogais("Eu sou uma árvore");
//		numeroVogais("Eu sou uma Arvore");
	}

//	exercício 1_Crie uma função chamada areaTriang que recebe dois argumentos (altura e base) e
//	retorna a área do triangulo.

	public static double areaTriangulo(double base, double altura) {
		return (base * altura) / 2;
	}

	static void printAreaTriangulo() {

		System.out.println("Digite o valor da base do Triângulo");
		double base = pedir.nextDouble();

		System.out.println("Digite o valor da altura do Triângulo");
		double altura = pedir.nextDouble();

		System.out.println("A área do Triângulo é: " + areaTriangulo(base, altura));

	}

//  exercício 2_Crie uma função chamada areaRetang que recebe dois argumentos (altura e comprimento) e 
//	retorna a área do retângulo.
//	

	public static double areaRetangulo(double base, double altura) {
		return (base * altura);
	}

	static void printAreaRetangulo() {

		System.out.println("Digite o valor do comprimento do retângulo");
		double base = pedir.nextDouble();

		System.out.println("Digite o valor da altura do retângulo");
		double altura = pedir.nextDouble();

		System.out.println("A área do Retângulo é: " + areaRetangulo(base, altura));
	}

//	exercício 3_Crie uma função chamada areaCal que recebe três argumentos (x, y, z) e 
//	retorna a área do triangulo caso z = 1 e retorna a área do retângulo caso contrário.

	static void printCalcArea() {
		System.out.println("Digite três valores para X,Y,Z ");
		double X = pedir.nextDouble();
		double Y = pedir.nextDouble();
		double Z = pedir.nextDouble();

		if (Z == 1) {
			System.out.print("Área do Triângulo é: " + areaTriangulo(X, Y));
		}

		else {
			System.out.println("Área do Retângulo é: " + areaRetangulo(X, Y));
		}

	}

//	exercicio 4_ Crie uma função chamada factor que recebe um argumento (n) e 
//	calcula o seu fatorial usando um ciclo (for ou while).

	private static int calcularFactorial() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite um número: ");
		int userInput = sc.nextInt();

		if (userInput == 0) {
			System.out.println(1);
		}

		int factorial = userInput;

		for (int i = userInput - 1; i > 0; i--) {
			factorial *= i; // factorial=factorial*i
			System.out.println(factorial);

		}
		return factorial;

	}

//	exercicio 5_Crie uma função chamada factorRecursivo que recebe um argumento (n) e
//	calcula o seu fatorial (recursivamente).

	private static int factorialRecursivo(int number) {
		if (number == 0) {
			return 1;
		}

		int factorial = factorialRecursivo(number - 1);
		return factorial * number;
	}
//	exercicio 6_Crie uma função chamada numTotalVogais que recebe uma String (frase) e 
//	retorna o número total de vogais na mesma.

	private static void totalVogais() {
		Scanner in = new Scanner(System.in);

		System.out.println("Escreva uma palavra ou frase :) ");

		String frase = in.next();

		int vogais = 0;

		String ref = "aeiouAEIOU";

		for (int i = 0; i < frase.length(); i++) {

			if ((frase.charAt(i) >= 'A' && frase.charAt(i) <= 'Z')
					|| (frase.charAt(i) >= 'a' && frase.charAt(i) <= 'z')) {
				if (ref.indexOf(frase.charAt(i)) != -1)
					vogais++;
			}

			// havia return para consoantes com uma variavel para as consoantes
		}

		System.out.println("Numero de vogais = " + vogais);
	}

//	exercicio 7_Crie uma função chamada numVogais que recebe uma String (frase) e 
//	retorna uma lista com o número de cada vogal na mesma.

	public static void numeroVogais(String expressao) {
		String expressaoFormatada = Normalizer.normalize(expressao, Normalizer.Form.NFD).toLowerCase();

		int a = 0;
		int e = 0;
		int i = 0;
		int o = 0;
		int u = 0;

		for (int j = 0; j < expressaoFormatada.length(); j++) {

			char letra = expressaoFormatada.charAt(j);

			switch (letra) {
			case 'a':
				a++;
				break;
			case 'e':
				e++;
				break;
			case 'i':
				i++;
				break;
			case 'o':
				o++;
				break;
			case 'u':
				u++;
				break;

			}
		}
		System.out.println("Expressão: " + expressao);
		System.out.println("a: " + a + "\ne: " + e + "\ni: " + i + "\no: " + o + "\nu: " + u);
	}
//
//exercicio 8_Escreva uma função chamada percentMulheres que recebe uma lista de Strings (nomes) e
//	retorna a percentagem de mulheres. Considere que os nomes das mulheres acabam todos em ‘a’.

	public static String percentMulheres() {
		return null;

	}

//	exercicio9_Escreva uma função que recebe um número (segundos) e 
//	retorna o número de minutos, horas, dias e meses (considere que um mês tem 30 dias).

	public static void anual(int aSegundos) {

		int segundos, minutos, horas, dias, meses;

		// segundos %= 60;
		segundos = aSegundos % 60;
		minutos = (aSegundos / 60) % 60;
		horas = (aSegundos / (60 * 60)) % 24;
		dias = (aSegundos / (60 * 60 * 24)) % 30;
		meses = (aSegundos / (60 * 60 * 24 * 30)) % 12;

		System.out.println("segundos introduzidos: " + aSegundos);
		System.out.println("Corresponde a: \n" + segundos + " segundos \n" + minutos + " minutos \n" + horas
				+ " horas \n" + dias + " dias \n" + meses + " meses \n");

	}

}
