package Ficha8.Ficha8_resolucao.dto;

import java.util.ArrayList;
import java.util.List;

import Ficha8.Ficha8_resolucao.model.CentroComercial;

public class SimpleResponseCentroComercial extends SimpleResponse {
	List<CentroComercial> centrosComerciais;

	public SimpleResponseCentroComercial() {
		centrosComerciais = new ArrayList<>();
	}

	public List<CentroComercial> getCentroComercial() {
		return centrosComerciais;
	}

	public void setCentroComercial(List<CentroComercial> aCentrosComerciais) {
		centrosComerciais = aCentrosComerciais;
	}

}
