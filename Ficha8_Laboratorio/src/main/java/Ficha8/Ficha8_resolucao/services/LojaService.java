package Ficha8.Ficha8_resolucao.services;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ficha8.Ficha8_resolucao.model.Loja;
import Ficha8.Ficha8_resolucao.repository.LojaRepository;

@Service
public class LojaService {
	private final LojaRepository lojaRepository;

	@Autowired
	public LojaService(LojaRepository aLojaRepository) {
		lojaRepository = aLojaRepository;
	}

	public boolean addAndar(Loja aLoja) {
		if (aLoja.getId() == null || aLoja.getNumeroFuncionarios() != 0 || aLoja.getArea() != 0) {
			lojaRepository.save(aLoja);
			return true;
		}
		return false;
	}

	public List<Loja> getLojas() {

		List<Loja> lojas = new ArrayList<>();

		lojaRepository.findAll().forEach(lojas::add);

		return lojas;
	}

	public Optional<Loja> getLojaById(String aId) {
		try {
			Long id_long = parseLong(aId);
			Optional<Loja> lojaOpcional = lojaRepository.findById(id_long);
			if (aId == null || id_long == NaN || lojaOpcional.isEmpty()) {
				return null;
			}
			return lojaOpcional;
		} catch (Exception e) {
			return null;
		}

	}

	public boolean updateLoja(Loja aLoja) {
		Optional<Loja> lojaOptional = getLojaOptional(aLoja);
		if (lojaOptional.isEmpty()) {
			return false;
		}
		Loja lojaToUpdate = lojaOptional.get();

		if (aLoja.getNome() != null && !aLoja.getNome().isBlank()) {
			lojaToUpdate.setNome(aLoja.getNome());
		}

		if (aLoja.getNumeroFuncionarios() != 0) {
			lojaToUpdate.setNumeroFuncionarios(aLoja.getNumeroFuncionarios());
		}
		if (aLoja.getArea() != 0) {
			lojaToUpdate.setArea(aLoja.getArea());
		}

		lojaRepository.save(aLoja);

		return true;
	}

	public Optional<Loja> getLojaOptional(Loja aLoja) {
		return lojaRepository.findById(aLoja.getId());

	}

	public boolean deleteLojaById(String aId) {

		try {
			Long id_long = parseLong(aId);

			Optional<Loja> lojaOpcional = lojaRepository.findById(id_long);

			if (aId == null || id_long == NaN || lojaOpcional.isEmpty()) {
				return false;
			}

			Loja loja = lojaOpcional.get();
			lojaRepository.delete(loja);

			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
