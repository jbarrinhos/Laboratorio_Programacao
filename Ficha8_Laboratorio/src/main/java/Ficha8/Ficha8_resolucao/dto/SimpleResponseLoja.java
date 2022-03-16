package Ficha8.Ficha8_resolucao.dto;

import java.util.List;

import Ficha8.Ficha8_resolucao.model.Loja;

public class SimpleResponseLoja extends SimpleResponse {

	List<Loja> lojas;

	public void SimpleResponseEmpresas(List<Loja> aLojas) {
		lojas = aLojas;
	}

	public List<Loja> getEmpresas() {
		return lojas;
	}

	public void setEmpresas(List<Loja> aLojas) {
		lojas = aLojas;
	}

}
