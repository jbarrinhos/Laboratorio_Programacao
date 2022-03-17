package Ficha8.Ficha8_resolucao.services;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.Optional;

import Ficha8.Ficha8_resolucao.model.Andar;
import Ficha8.Ficha8_resolucao.model.CentroComercial;
import Ficha8.Ficha8_resolucao.model.Loja;
import Ficha8.Ficha8_resolucao.repository.AndarRepository;
import Ficha8.Ficha8_resolucao.repository.CentroComercialRepository;
import Ficha8.Ficha8_resolucao.repository.LojaRepository;

public class CCAndarLojaService {
	private final CentroComercialRepository centroComercialRepository;
	private final AndarRepository andarRepository;
	private final LojaRepository lojaRepository;

	public CCAndarLojaService(CentroComercialRepository aCentroComercialRepository, AndarRepository aAndarRepository,
			LojaRepository aLojaRepository) {
		centroComercialRepository = aCentroComercialRepository;
		andarRepository = aAndarRepository;
		lojaRepository = aLojaRepository;
	}

	public boolean deleteCentroComercialAndarLoja(String aId) {

		try {
			Long id_long = parseLong(aId);
			Optional<CentroComercial> ccOpcional = centroComercialRepository.findById(id_long);

			if (aId == null || id_long == NaN || ccOpcional.isEmpty()) {
				return false;
			}
			if (ccOpcional.isPresent()) {
				for (Andar andares : ccOpcional.get().getAndares()) {
					// lojas.setAndares(null);
					// lojaRepo.save(lojas);
					andarRepository.delete(andares);

					for (Loja lojas : andares.getLojas()) {

						lojaRepository.delete(lojas);
					}
				}
			}

			CentroComercial cc = ccOpcional.get();
			centroComercialRepository.delete(cc);

			return true;

		} catch (Exception e) {
			return false;
		}
	}

}
