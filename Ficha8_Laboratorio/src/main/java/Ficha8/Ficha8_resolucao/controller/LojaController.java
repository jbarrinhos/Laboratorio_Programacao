package Ficha8.Ficha8_resolucao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Ficha8.Ficha8_resolucao.dto.SimpleResponse;
import Ficha8.Ficha8_resolucao.dto.SimpleResponseLoja;
import Ficha8.Ficha8_resolucao.model.Loja;
import Ficha8.Ficha8_resolucao.services.LojaService;

@RestController
public class LojaController {
	private final LojaService lojaService;

	@Autowired
	public LojaController(LojaService aLojaService) {
		lojaService = aLojaService;
	}

	@GetMapping("/getLojas")
	public List<Loja> getLojas() {
		return lojaService.getLojas();
	}

	@PostMapping("/addLoja")
	public ResponseEntity<SimpleResponse> addLoja(@RequestBody Loja aLoja) {

		SimpleResponseLoja srl = new SimpleResponseLoja();

		if (aLoja.getNome() == null || aLoja.getNome().isBlank()) {
			srl.setMensagem("Nome Inválido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(srl);
		}

		if (aLoja.getNumeroFuncionarios() <= 0 || aLoja.getNumeroFuncionarios() == ' ') {
			srl.setMensagem("Valor inválido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(srl);
		}
		if (aLoja.getArea() == 0 || aLoja.getArea() == ' ') {
			srl.setMensagem("Valor inválido");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(srl);
		}
		if (lojaService.addAndar(aLoja)) {
			srl.setSucesso("Loja criada com sucesso");
			srl.setLoja(lojaService.getLojas());
			return ResponseEntity.status(HttpStatus.OK).body(srl);
		} else {
			srl.setAsError("Erro ao criai a Loja");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(srl);
		}
	}

	@PutMapping("/updateLoja")
	public ResponseEntity<SimpleResponse> updateLoja(@RequestBody Loja aLoja) {
		SimpleResponseLoja srl = new SimpleResponseLoja();

		if (lojaService.updateLoja(aLoja)) {
			srl.setSucesso("Loja atualizada com sucesso");
			return ResponseEntity.status(HttpStatus.OK).body(srl);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(srl);
	}

}
