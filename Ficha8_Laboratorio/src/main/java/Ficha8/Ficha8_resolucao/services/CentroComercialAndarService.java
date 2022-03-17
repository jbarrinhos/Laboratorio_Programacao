package Ficha8.Ficha8_resolucao.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import Ficha8.Ficha8_resolucao.model.Andar;
import Ficha8.Ficha8_resolucao.model.CentroComercial;
import Ficha8.Ficha8_resolucao.repository.AndarRepository;
import Ficha8.Ficha8_resolucao.repository.CentroComercialRepository;

@Service
public class CentroComercialAndarService {

	private final CentroComercialRepository centroComercialRepository;
	private final AndarRepository andarRepository;

	public CentroComercialAndarService(CentroComercialRepository aCentroComercialRepository,
			AndarRepository aAndarRepository) {

		centroComercialRepository = aCentroComercialRepository;
		andarRepository = aAndarRepository;

	}

	public boolean addAndarToCc(Andar aAndar, CentroComercial aCentroComercial) {
		Optional<CentroComercial> ccOptional = centroComercialRepository.findById(aCentroComercial.getId());

		if (ccOptional.isPresent() && ccOptional.isEmpty()) {
			return false;
		}
		CentroComercial ccAux = ccOptional.get();
		ccAux.addAndar(aAndar);
		aAndar.setCentroComercial(ccAux);

		andarRepository.save(aAndar);
		centroComercialRepository.save(ccAux); // para adicionar à base de dados

		return true;
	}

}
