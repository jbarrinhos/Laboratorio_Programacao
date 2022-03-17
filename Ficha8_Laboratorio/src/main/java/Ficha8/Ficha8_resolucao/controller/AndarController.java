package Ficha8.Ficha8_resolucao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Ficha8.Ficha8_resolucao.dto.SimpleResponse;
import Ficha8.Ficha8_resolucao.dto.SimpleResponseAndar;
import Ficha8.Ficha8_resolucao.model.Andar;
import Ficha8.Ficha8_resolucao.services.AndarLojaService;
import Ficha8.Ficha8_resolucao.services.AndarService;
import Ficha8.Ficha8_resolucao.services.CentroComercialAndarService;
import Ficha8.Ficha8_resolucao.utils.WrapperAndarCComercial;

@RestController
public class AndarController {
	private final AndarService andarService;
	private final CentroComercialAndarService centroComercialAndarService;
	private final AndarLojaService andarLojaService;

	@Autowired
	public AndarController(AndarService aAndarService, CentroComercialAndarService aCentroComercialAndarService,
			AndarLojaService aAndarLojaService) {
		andarService = aAndarService;
		centroComercialAndarService = aCentroComercialAndarService;
		andarLojaService = aAndarLojaService;
	}

	@GetMapping("/getAndares")
	public List<Andar> getAndares() {
		return andarService.getAndares();
	}

	@PostMapping("/addAndar")
	public ResponseEntity<SimpleResponse> addAndar(@RequestBody Andar aAndar) {

		SimpleResponseAndar sra = new SimpleResponseAndar();

		if (aAndar.getNumeroAndar() <= 0) {
			sra.setMensagem("Valor inválido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sra);
		}
		if (aAndar.getNumeroMaxLojas() <= 0) {
			sra.setMensagem("Valor inválido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sra);
		}
		if (andarService.addAndar(aAndar)) {
			sra.setSucesso("Andar criado com sucesso");
			sra.setAndar(andarService.getAndares());
			return ResponseEntity.status(HttpStatus.OK).body(sra);
		} else {
			sra.setAsError("Erro ao criai o Andar");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sra);
		}
	}

	@DeleteMapping("/deleteAndar/{aId}")
	public boolean deleteAndar(@PathVariable String aId) {
		return andarService.deleteAndarById(aId);
	}

	@PostMapping("/addAndarToCc")
	public ResponseEntity<SimpleResponse> addAndarToCc(@RequestBody WrapperAndarCComercial aWrapper) {
		SimpleResponseAndar sra = new SimpleResponseAndar();
		if (centroComercialAndarService.addAndarToCc(aWrapper.getAndar(), aWrapper.getCentroComercial())) {
			sra.setSucesso("Andar adicionado ao Centro Comercial com sucesso");
			return ResponseEntity.status(HttpStatus.OK).body(sra);
		}
		return null;
	}

}
