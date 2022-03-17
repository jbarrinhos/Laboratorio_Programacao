package Ficha8.Ficha8_resolucao.controller;

import java.util.List;
import java.util.Optional;

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
import Ficha8.Ficha8_resolucao.dto.SimpleResponseLoja;
import Ficha8.Ficha8_resolucao.model.Loja;
import Ficha8.Ficha8_resolucao.services.AndarLojaService;
import Ficha8.Ficha8_resolucao.services.LojaService;
import Ficha8.Ficha8_resolucao.utils.WrapperLojaAndar;

@RestController
public class LojaController {
	private final LojaService lojaService;
	private final AndarLojaService andarLojaService;

	@Autowired
	public LojaController(LojaService aLojaService, AndarLojaService aAndarLojaService) {
		lojaService = aLojaService;
		andarLojaService = aAndarLojaService;
	}

	@GetMapping("/getLojas")
	public List<Loja> getLojas() {
		return lojaService.getLojas();
	}

	@GetMapping("/getLojaById/{aId}")
	public Optional<Loja> getLojaById(@PathVariable String aId) {

		return lojaService.getLojaById(aId);
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

	@DeleteMapping("/deleteLoja/{aId}")
	public boolean deleteLojaById(@PathVariable String aId) {
		return lojaService.deleteLojaById(aId);
	}

	@PostMapping("/addLojaToAndar")
	public ResponseEntity<SimpleResponse> addLojaToAndar(@RequestBody WrapperLojaAndar aWrapper) {
		SimpleResponseLoja srl = new SimpleResponseLoja();
		if (andarLojaService.addLojaToAndar(aWrapper.getLoja(), aWrapper.getAndar())) {
			srl.setSucesso("Loja adicionada ao Andar com sucesso");
			return ResponseEntity.status(HttpStatus.OK).body(srl);
		}
		return null;
	}

}
