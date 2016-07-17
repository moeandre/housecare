package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.PrescricaoMedicamentosa;
import br.com.wamais.houseCare.domain.PrescricaoMedicamentosaPK;
import br.com.wamais.houseCare.repository.PrescricaoMedicamentosaRepository;
import br.com.wamais.houseCare.service.IPrescricaoMedicamentosaService;

@Service
@Transactional
public class PrescricaoMedicamentosaServiceImpl extends AbstractService<PrescricaoMedicamentosa, PrescricaoMedicamentosaPK> implements
		IPrescricaoMedicamentosaService {

	@Autowired
	private PrescricaoMedicamentosaRepository repository;

	@Autowired
	public void superRepository(final PrescricaoMedicamentosaRepository repository) {

		super.setRepository(repository);
	}

}
