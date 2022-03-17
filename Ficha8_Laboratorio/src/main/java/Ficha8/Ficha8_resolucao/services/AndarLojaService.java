package Ficha8.Ficha8_resolucao.services;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.Optional;

import org.springframework.stereotype.Service;

import Ficha8.Ficha8_resolucao.model.Andar;
import Ficha8.Ficha8_resolucao.model.Loja;
import Ficha8.Ficha8_resolucao.repository.AndarRepository;
import Ficha8.Ficha8_resolucao.repository.LojaRepository;

@Service
public class AndarLojaService {

	private final AndarRepository andarRepository;
	private final LojaRepository lojaRepository;

	public AndarLojaService(AndarRepository aAndarRepository, LojaRepository aLojaRepository) {
		andarRepository = aAndarRepository;
		lojaRepository = aLojaRepository;
	}

	public boolean addLojaToAndar(Loja aLoja, Andar aAndar) {
		Optional<Andar> andarOptional = andarRepository.findById(aAndar.getId());

		if (andarOptional.isPresent() && andarOptional.isEmpty()) {
			return false;
		}
		Andar andarAux = andarOptional.get();
		andarAux.addLoja(aLoja);
		aLoja.setAndares(andarAux);

		lojaRepository.save(aLoja);
		andarRepository.save(andarAux); // para adicionar à base de dados

		return true;
	}

	public boolean deleteAndarLoja(String aId) {

		try {
			Long id_long = parseLong(aId);
			Optional<Andar> andarOpcional = andarRepository.findById(id_long);

			if (aId == null || id_long == NaN || andarOpcional.isEmpty()) {
				return false;
			}

			if (andarOpcional.isPresent()) {
				for (Loja lojas : andarOpcional.get().getLojas()) {
					lojaRepository.delete(lojas);
				}
			}

			Andar andar = andarOpcional.get();
			andarRepository.delete(andar);

			return true;

		} catch (Exception e) {
			return false;
		}
	}

}
