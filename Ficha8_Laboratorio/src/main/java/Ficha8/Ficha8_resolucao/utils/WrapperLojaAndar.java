package Ficha8.Ficha8_resolucao.utils;

import Ficha8.Ficha8_resolucao.model.Andar;
import Ficha8.Ficha8_resolucao.model.Loja;

public class WrapperLojaAndar {
	private Andar andar;
	private Loja loja;

	public WrapperLojaAndar(Andar aAndar, Loja aLoja) {
		andar = aAndar;
		loja = aLoja;
	}

	public Andar getAndar() {
		return andar;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setAndar(Andar aAndar) {
		andar = aAndar;
	}

	public void setLoja(Loja aLoja) {
		loja = aLoja;
	}

}
