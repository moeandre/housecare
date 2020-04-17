package br.com.wamais.houseCare.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.wamais.houseCare.domain.Cliente;
import br.com.wamais.houseCare.domain.Familiar;
import br.com.wamais.houseCare.domain.Fatura;
import br.com.wamais.houseCare.domain.Lancamento;
import br.com.wamais.houseCare.domain.LancamentoPK;
import br.com.wamais.houseCare.enums.StatusFaturaEnum;
import br.com.wamais.houseCare.repository.crud.FaturaRepository;
import br.com.wamais.houseCare.service.IClienteService;
import br.com.wamais.houseCare.service.IEmpresaService;
import br.com.wamais.houseCare.service.IFamiliarService;
import br.com.wamais.houseCare.service.IFaturaService;
import br.com.wamais.houseCare.service.ILancamentoService;

@Service
@Transactional
public class FaturaServiceImpl extends AbstractService<Fatura, Integer> implements IFaturaService {

	@PersistenceContext(name = "housePU")
	private EntityManager entityManager;

	@Autowired
	private FaturaRepository repository;

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
	public Fatura clonar(final Integer idEmpresa, final Integer id) {

		final Fatura fatura = this.obterPorIdEmpresa(idEmpresa, id);
		final Fatura savedFatura = this.buildFatura(idEmpresa, fatura.getIdCliente(), fatura);

		final List<Lancamento> savedLancamentos = new ArrayList<Lancamento>();

		// Totaliza a cobrança e inclui a fatura no lançamento
		fatura.getLancamentos().stream().forEach(lancamento -> {

			final Lancamento savedLancamento = this.buildLancamento(savedFatura, lancamento);

			entityManager.persist(savedLancamento);
			entityManager.flush();
			entityManager.clear();

			savedLancamentos.add(savedLancamento);

			final BigDecimal valorDoItem = lancamento.getValor().multiply(BigDecimal.valueOf(lancamento.getQuantidade()));
			savedFatura.setValor(savedFatura.getValor().add(valorDoItem));
		});

		savedFatura.setLancamentos(savedLancamentos);
		this.alterar(savedFatura);

		return savedFatura;

	}

	@Override
	public Fatura faturar(final Integer idEmpresa, final Integer idCliente, final Fatura fatura) {

		final Fatura savedFatura = this.buildFatura(idEmpresa, idCliente, fatura);
		final List<Lancamento> savedLancamentos = new ArrayList<Lancamento>();

		// Totaliza a cobrança e inclui a fatura no lançamento
		fatura.getLancamentos().stream().forEach(lancamento -> {
			lancamento = this.lancamentoService.obtemPorId(lancamento.getId());
			lancamento.setIdFatura(savedFatura.getId());
			savedLancamentos.add(this.lancamentoService.alterar(lancamento));

			final BigDecimal valorDoItem = lancamento.getValor().multiply(BigDecimal.valueOf(lancamento.getQuantidade()));
			savedFatura.setValor(savedFatura.getValor().add(valorDoItem));
		});

		savedFatura.setLancamentos(savedLancamentos);

		return this.alterar(savedFatura);

	}

	@Override
	public Fatura faturar(final Integer idEmpresa, final Integer idCliente) {

		final Fatura savedFatura = this.buildFatura(idEmpresa, idCliente, new Fatura());
		final List<Lancamento> lancamentos = this.lancamentoService.listarPendentes(idCliente, idEmpresa);

		// Totaliza a cobrança e inclui a fatura no lançamento
		lancamentos.stream().forEach(lancamento -> {
			lancamento = this.lancamentoService.obtemPorId(lancamento.getId());
			lancamento.setIdFatura(savedFatura.getId());
			savedFatura.addLancamentos(this.lancamentoService.alterar(lancamento));

			final BigDecimal valorDoItem = lancamento.getValor().multiply(BigDecimal.valueOf(lancamento.getQuantidade()));
			savedFatura.setValor(savedFatura.getValor().add(valorDoItem));
		});

		return this.alterar(savedFatura);

	}

	private Fatura buildFatura(final Integer idEmpresa, final Integer idCliente, final Fatura fatura) {

		final Fatura savedFatura = new Fatura();

		final Calendar hoje = Calendar.getInstance();
		final Calendar vencimento = Calendar.getInstance();

		Integer diaVencimento = this.obterDiaVencimento(idEmpresa, idCliente);
		Integer mesVencimento = 1;

		if (vencimento.get(Calendar.DAY_OF_MONTH) >= diaVencimento) {
			mesVencimento = 2;
		}
		vencimento.add(Calendar.MONTH, mesVencimento);
		vencimento.set(Calendar.DAY_OF_MONTH, diaVencimento);

		final Familiar familiar = this.familiarService.obterResponsavelFinanceiro(idCliente, idEmpresa);
		if (familiar != null) {
			savedFatura.setIdFamiliar(familiar.getIdFamiliar());
		}

		savedFatura.setIdEmpresa(idEmpresa);
		savedFatura.setIdCliente(idCliente);
		savedFatura.setData(hoje.getTime());
		savedFatura.setVencimento(vencimento.getTime());
		savedFatura.setValor(BigDecimal.ZERO);
		savedFatura.setSituacao(StatusFaturaEnum.ABERTA.getCodigo());

		savedFatura.setTipo(this.obterTipoFatura(idEmpresa, idCliente));

		return this.alterar(savedFatura);
	}

	private Lancamento buildLancamento(final Fatura fatura, final Lancamento lancamento) {

		final Lancamento savedLancamento = new Lancamento();

		final LancamentoPK lancamentoPk = new LancamentoPK();
		lancamentoPk.setIdCliente(fatura.getIdCliente());
		lancamentoPk.setIdEmpresa(fatura.getIdEmpresa());
		savedLancamento.setId(lancamentoPk);

		savedLancamento.setIdFatura(fatura.getId());
		savedLancamento.setNome(lancamento.getNome());
		savedLancamento.setQuantidade(lancamento.getQuantidade());
		savedLancamento.setValor(lancamento.getValor());
		savedLancamento.setCriacao(Calendar.getInstance().getTime());

		return savedLancamento;

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

	private String obterTipoFatura(final Integer idEmpresa, final Integer idCliente) {

		String diaVencimento = "B";
		try {
			diaVencimento = this.clienteService.obterTipoFatura(idCliente, idEmpresa);
		} catch (final Exception e) {
			diaVencimento = this.empresaService.obterTipoFatura(idEmpresa);
		}
		return diaVencimento;
	}

	@Override
	public List<Fatura> listarPorEmpresa(final Integer idEmpresa) {

		final List<Fatura> faturas = new ArrayList<Fatura>();

		final List<Object[]> listaEntidades = this.repository.listarPorEmpresa(idEmpresa);
		listaEntidades.stream().forEach(entidade -> {

			final Fatura fatura = (Fatura) entidade[0];
			final Cliente cliente = (Cliente) entidade[1];
			fatura.setCliente(cliente);

			faturas.add(fatura);
		});

		return faturas;
	}

	@Override
	public List<Fatura> listarPorEmpresa(final Integer idEmpresa, final String mesano) {

		final List<Fatura> faturas = new ArrayList<Fatura>();

		final Integer ano = Integer.valueOf(mesano.substring(0, 4));
		final Integer mes = Integer.valueOf(mesano.substring(5));

		final List<Object[]> listaEntidades = this.repository.listarPorEmpresa(idEmpresa, mes, ano);
		listaEntidades.stream().forEach(entidade -> {

			final Fatura fatura = (Fatura) entidade[0];
			final Cliente cliente = (Cliente) entidade[1];
			fatura.setCliente(cliente);

			faturas.add(fatura);
		});

		return faturas;
	}

	@Override
	public Fatura obterPorIdEmpresa(final Integer idEmpresa, final Integer idFatura) {

		final List<Fatura> faturas = this.parseFaturas(this.repository.obterPorIdEmpresa(idEmpresa, idFatura));
		final Fatura fatura = (!faturas.isEmpty()) ? faturas.get(0) : new Fatura();

		if (fatura.getIdFamiliar() != null) {
			fatura.setFamiliar(this.familiarService.obtemPorId(fatura.getIdFamiliar()));
		}

		return fatura;
	}

	private List<Fatura> parseFaturas(final List<Object[]> listaEntidades) {

		final List<Fatura> faturas = new ArrayList<Fatura>();

		listaEntidades.stream().forEach(entidade -> {

			final Fatura fatura = (Fatura) entidade[0];
			final Cliente cliente = (Cliente) entidade[1];
			fatura.setCliente(cliente);

			final Lancamento lancamento = (Lancamento) entidade[2];

			if (faturas.contains(fatura)) {
				faturas.get(faturas.indexOf(fatura)).addLancamentos(lancamento);
			} else {
				fatura.addLancamentos(lancamento);
				faturas.add(fatura);
			}
		});

		return faturas;

	}

}
