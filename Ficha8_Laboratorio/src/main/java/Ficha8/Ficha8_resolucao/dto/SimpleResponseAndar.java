package Ficha8.Ficha8_resolucao.dto;

import java.util.List;

import Ficha8.Ficha8_resolucao.model.Andar;

public class SimpleResponseAndar extends SimpleResponse {
	List<Andar> andares;

	public void SimpleResponseEmpresas(List<Andar> aAndares) {
		andares = aAndares;
	}

	public List<Andar> getEmpresas() {
		return andares;
	}

	public void setEmpresas(List<Andar> aAndares) {
		andares = aAndares;
	}

}
