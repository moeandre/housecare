package br.com.wamais.houseCare.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Cobranca;
import br.com.wamais.houseCare.domain.Familiar;
import br.com.wamais.houseCare.domain.Fatura;
import br.com.wamais.houseCare.domain.Lancamento;
import br.com.wamais.houseCare.repository.FaturaRepository;
import br.com.wamais.houseCare.service.IClienteService;
import br.com.wamais.houseCare.service.ICobrancaService;
import br.com.wamais.houseCare.service.IEmpresaService;
import br.com.wamais.houseCare.service.IFamiliarService;
import br.com.wamais.houseCare.service.IFaturaService;
import br.com.wamais.houseCare.service.ILancamentoService;

@Service
@Transactional
public class FaturaServiceImpl extends AbstractService<Fatura, Integer> implements IFaturaService {

	@Autowired
	private ICobrancaService cobrancaService;

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IEmpresaService empresaService;

	@Autowired
	private ILancamentoService lancamentoService;

	@Autowired
	private IFamiliarService familiarService;

	@Autowired
	public void superRepository(final FaturaRepository repository) {

		super.setRepository(repository);
	}

	@Override
	public Fatura faturar(final Integer idEmpresa, final Integer idCliente, final Fatura fatura) {

		// Armazena a fatura para gerar o ID
		final Fatura savedFatura = super.alterar(fatura);

		// Inicializa a Cobranca com valor Zero
		final Cobranca cobranca = new Cobranca();
		cobranca.setValor(BigDecimal.ZERO);

		final List<Lancamento> savedLancamentos = new ArrayList<Lancamento>();

		// Totaliza a cobrança e inclui a fatura no lançamento
		fatura.getLancamentos().stream().forEach(lancamento -> {
			lancamento = this.lancamentoService.obtemPorId(lancamento.getId());
			lancamento.setIdFatura(savedFatura.getId());
			savedLancamentos.add(this.lancamentoService.alterar(lancamento));
			cobranca.setValor(cobranca.getValor().add(lancamento.getValor()));
		});

		savedFatura.setLancamentos(savedLancamentos);

		cobranca.setIdEmpresa(idEmpresa);
		cobranca.setIdCliente(idCliente);

		cobranca.setData(Calendar.getInstance().getTime());

		final Calendar vencimento = Calendar.getInstance();
		vencimento.set(Calendar.DAY_OF_MONTH, this.obterDiaVencimento(idEmpresa, idCliente));
		vencimento.add(Calendar.MONTH, 1);

		cobranca.setVencimento(vencimento.getTime());

		final Familiar familiar = this.familiarService.obterResponsavelFinanceiro(idCliente, idEmpresa);
		if (familiar != null) {
			cobranca.setIdFamiliar(familiar.getIdFamiliar());
		}

		// Gera a cobrança
		final Cobranca savedCobranca = this.cobrancaService.alterar(cobranca);

		// Atribui a cobrança ao Faturamento
		savedFatura.setIdCobranca(savedCobranca.getId());
		savedFatura.setCobranca(savedCobranca);

		return this.alterar(savedFatura);
	}

	private Integer obterDiaVencimento(final Integer idEmpresa, final Integer idCliente) {

		String diaVencimento = "1";
		try {
			diaVencimento = this.clienteService.obterVencimento(idCliente, idEmpresa);
		} catch (final Exception e) {
			diaVencimento = this.empresaService.obterVencimento(idEmpresa);
		}
		return Integer.valueOf(diaVencimento);
	}

}
