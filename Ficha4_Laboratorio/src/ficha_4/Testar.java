package ficha_4;

import java.text.DecimalFormat;

public class Testar {

	public static void main(String[] args) {

		DecimalFormat formatarValor = new DecimalFormat("0.00");

		System.out.println("Comprar Fruta \n");

		FrutaUnidade maracuja = new FrutaUnidade("Maracujá", 1.25);
		FrutaPeso laranja = new FrutaPeso("Laranja", 4.95);
		FrutaVolume anona = new FrutaVolume("Anona", 6.00);

		maracuja.setUnidade(15);

		System.out.println(formatarValor.format(maracuja.pagar()) + "€/uni");

		laranja.setPeso(0.3f);// 300g em kg // necessário colocar "f" para identificar float em números
								// decimais

		System.out.println(formatarValor.format(laranja.pagar()) + "€/kg");

		anona.setVolume(25);
		System.out.println(formatarValor.format(anona.pagar()) + "€/volume\n");

		// 2

		Cesto cestoFruta = new Cesto();

		System.out.println("Adicionando fruta ao cesto \n");

		cestoFruta.inserirFruta(maracuja);
		cestoFruta.inserirFruta(maracuja);
		cestoFruta.inserirFruta(maracuja);
		cestoFruta.inserirFruta(laranja);
		cestoFruta.inserirFruta(anona);

		// tentar depois juntar as peças de frutas ex.: 3 maracujás"
		System.out.println("\nO meu cesto de momento tem: " + cestoFruta);

		System.out.println("\nValor total da cesta: " + formatarValor.format(cestoFruta.valorTotalPagar()) + "€");

		cestoFruta.numeroFruta("maracujá");

		// testar unicamento o desconto
		System.out.println("\nvalor com desconto sem peso: " + formatarValor.format(laranja.descontar(0.7)) + "€");
		System.out.println("valor com desconto sem volume: " + formatarValor.format(anona.descontar(0.15)) + "€");

		// testar com peso/volume

		laranja.setDescontar(0.2d);
		anona.setDescontar(15);

		System.out.println("\nvalor com desconto e peso: " + formatarValor.format(laranja.pagar()) + "€");
		System.out.println("valor com desconto e volume: " + formatarValor.format(anona.pagar()) + "€");

	}

}
