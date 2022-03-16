package Ficha8.Ficha8_resolucao.dto;

import java.util.ArrayList;
import java.util.List;

import Ficha8.Ficha8_resolucao.model.Andar;

public class SimpleResponseAndar extends SimpleResponse {
	List<Andar> andares;

	public SimpleResponseAndar() {
		andares = new ArrayList<>();
	}

	public List<Andar> getAndar() {
		return andares;
	}

	public void setAndar(List<Andar> aAndares) {
		andares = aAndares;
	}

}
