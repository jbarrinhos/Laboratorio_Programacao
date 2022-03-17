package Ficha8.Ficha8_resolucao.services;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ficha8.Ficha8_resolucao.model.Andar;
import Ficha8.Ficha8_resolucao.repository.AndarRepository;
import Ficha8.Ficha8_resolucao.repository.CentroComercialRepository;

@Service
public class AndarService {
	private final AndarRepository andarRepository;
	private final CentroComercialRepository centroComercialRepository;

	@Autowired
	public AndarService(AndarRepository aAndarRepository, CentroComercialRepository aCentroComercialRepository) {
		andarRepository = aAndarRepository;
		centroComercialRepository = aCentroComercialRepository;
	}

	public boolean addAndar(Andar aAndar) {
		if (aAndar.getId() == null || aAndar.getNumeroAndar() != 0 || aAndar.getNumeroMaxLojas() != 0) {
			andarRepository.save(aAndar);
			return true;
		}
		return false;
	}

	public List<Andar> getAndares() {
		List<Andar> andares = new ArrayList<>();
		andarRepository.findAll().forEach(andares::add);
		return andares;
	}

	public boolean deleteAndarById(String aId) {
		try {
			Long id_long = parseLong(aId);
			Optional<Andar> andarOptional = andarRepository.findById(id_long);
			if (aId == null || id_long == NaN || andarOptional.isEmpty()) {
				return false;
			}
			Andar andar = andarOptional.get();
			andarRepository.delete(andar);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
