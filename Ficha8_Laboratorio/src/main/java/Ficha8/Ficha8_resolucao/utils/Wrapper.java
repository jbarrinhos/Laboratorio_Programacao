package Ficha8.Ficha8_resolucao.utils;

import Ficha8.Ficha8_resolucao.model.Andar;
import Ficha8.Ficha8_resolucao.model.CentroComercial;

public class Wrapper {
	private CentroComercial centroComercial;
	private Andar andar;

	public Wrapper(CentroComercial aCentroComercial, Andar aAndar) {
		centroComercial = aCentroComercial;
		andar = aAndar;
	}

	public CentroComercial getCentroComercial() {
		return centroComercial;
	}

	public Andar getAndar() {
		return andar;
	}

	public void setCentroComercial(CentroComercial aCentroComercial) {
		centroComercial = aCentroComercial;
	}

	public void setAndar(Andar aAndar) {
		andar = aAndar;
	}

}
