package fichaExtra;

import java.util.Date;

public class Main {

	public static void main(String[] args) {

//		criação do Porto

		Porto portoFunchal = new Porto("Porto do Funchal");

//		adicionar navios Porta-Contentores e Petroleiros

		PortaContentores pC = new PortaContentores("222", "pContentores", new Date(), 100, 3);
		PortaContentores pC1 = new PortaContentores("12", "pContentor1", new Date(), 50, 1);

		Petroleiro pt = new Petroleiro("12", "Ptroleiro", new Date(), 20, 10);
		Petroleiro pt1 = new Petroleiro("12", "Ptroleiro1", new Date(), 40, 25);

//		adicionar os navios ao porto

		portoFunchal.adicionarNavio(pC);
		portoFunchal.adicionarNavio(pC1);

		portoFunchal.adicionarNavio(pt);
		portoFunchal.adicionarNavio(pt1);

//		verificação se existem navios no porto

		System.out.println("Navios adicionados ao porto do funchal " + portoFunchal);

//		verificar a capacidade máxima
		System.out.println("\nCapacidade máxima de Contentores dos navios PC: " + portoFunchal.capacidadeMax());

//		verificar a capacidade total dos navios atracados no porto

		System.out.println("\nCapacidade total: " + portoFunchal.capacidadeTotal());

//		quando vários navios são definidos com identificadores unicos

		System.out.println("-----navios definidos com identificadores iguais ");

//		é possível verificar que os identificadores são alterados devido ao método adicionarNavio(), evitando identificadores iguais
		System.out.println(pC1.getIdentificador());
		System.out.println(pt.getIdentificador());
		System.out.println(pt1.getIdentificador());
	}

}
