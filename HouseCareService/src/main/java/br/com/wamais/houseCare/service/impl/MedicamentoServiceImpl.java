package br.com.wamais.houseCare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Medicamento;
import br.com.wamais.houseCare.repository.MedicamentoRepository;
import br.com.wamais.houseCare.service.IMedicamentoService;

@Service
@Transactional
public class MedicamentoServiceImpl extends AbstractService<Medicamento, Integer> implements IMedicamentoService {

	@Autowired
	private MedicamentoRepository repository;

	@Autowired
	public void superRepository(final MedicamentoRepository repository) {

		super.setRepository(repository);
	}

}
