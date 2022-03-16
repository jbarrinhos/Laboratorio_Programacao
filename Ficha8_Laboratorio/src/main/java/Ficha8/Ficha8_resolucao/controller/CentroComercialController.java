package Ficha8.Ficha8_resolucao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Ficha8.Ficha8_resolucao.dto.SimpleResponse;
import Ficha8.Ficha8_resolucao.dto.SimpleResponseCentroComercial;
import Ficha8.Ficha8_resolucao.model.CentroComercial;
import Ficha8.Ficha8_resolucao.services.CentroComercialService;

@RestController
public class CentroComercialController {

	private final CentroComercialService centroComercialService;

	@Autowired
	public CentroComercialController(CentroComercialService aCentroComercialService) {
		centroComercialService = aCentroComercialService;

	}

	@GetMapping("/getCComerciais")
	public List<CentroComercial> getCentroComerciais() {
		return centroComercialService.getCentroComerciais();
	}

// em contrução
	public boolean getCComercial(@PathVariable String aId) {
		return centroComercialService.getCentroComercial(aId);
	}

	@PostMapping("/addCentroComercial")
	public ResponseEntity<SimpleResponse> addCentroComercial(@RequestBody CentroComercial aCentroComercial) {
		SimpleResponseCentroComercial srcc = new SimpleResponseCentroComercial();
		if (aCentroComercial.getNome() == null || aCentroComercial.getNome().isBlank()) {
			srcc.setMensagem("Nome Inválido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(srcc);
		}
		if (aCentroComercial.getMorada() == null || aCentroComercial.getMorada().isBlank()) {
			srcc.setMensagem("Morada Inválida");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(srcc);
		}
		if (aCentroComercial.getNumeroMaxAndar() == 0 || aCentroComercial.getNumeroMaxAndar() == ' ') {
			srcc.setMensagem("Valor inválido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(srcc);
		}

		if (centroComercialService.addCentroComercial(aCentroComercial)) {
			srcc.setSucesso("Centro Comercial criada com sucesso");
			srcc.setCentroComercial(centroComercialService.getCentroComerciais());
			return ResponseEntity.status(HttpStatus.OK).body(srcc);

		} else {
			srcc.setAsError("Erro ao criai o Centro Comercial");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(srcc);
		}
	}

	@DeleteMapping("/deleteCentroComercial/{aId}")
	public boolean deleteEmpresa(@PathVariable String aId) {
		return centroComercialService.deleteCentroComercialById(aId);
	}

	@PutMapping("/updateCComercial")
	public ResponseEntity<SimpleResponse> updateEmpresa(@RequestBody CentroComercial aCentroComercial) {
		SimpleResponseCentroComercial srcc = new SimpleResponseCentroComercial();

		if (centroComercialService.updateCComercial(aCentroComercial)) {
			srcc.setSucesso("Sucesso ao atualizar o Centro Comercial");
			return ResponseEntity.status(HttpStatus.OK).body(srcc);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(srcc);
	}

}