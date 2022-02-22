package ficha_4;

public class Testar {

	public static void main(String[] args) {

		FrutaUnidade maracuja = new FrutaUnidade("maça", 0.99);
		FrutaPeso laranja = new FrutaPeso("laranja", 1.99);
		FrutaVolume anona = new FrutaVolume("anona", 1.99);

		maracuja.setUnidade(15);

		System.out.println(maracuja.pagar() + "€/uni");

		laranja.setPeso(10.5);

		System.out.println(laranja.pagar() + "€/kg");

		anona.setVolume(10);
		System.out.println(anona.pagar() + "€/volume");

		// 2

		Cesto cestoFruta = new Cesto();

		cestoFruta.inserirFruta(maracuja);
		cestoFruta.inserirFruta(laranja);
		cestoFruta.inserirFruta(anona);

	}
}
