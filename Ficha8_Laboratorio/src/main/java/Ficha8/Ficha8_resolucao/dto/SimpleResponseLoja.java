package Ficha8.Ficha8_resolucao.dto;

import java.util.ArrayList;
import java.util.List;

import Ficha8.Ficha8_resolucao.model.Loja;

public class SimpleResponseLoja extends SimpleResponse {

	List<Loja> lojas;

	public SimpleResponseLoja() {
		lojas = new ArrayList<>();
	}

	public List<Loja> getLoja() {
		return lojas;
	}

	public void setLoja(List<Loja> aLojas) {
		lojas = aLojas;
	}

}
