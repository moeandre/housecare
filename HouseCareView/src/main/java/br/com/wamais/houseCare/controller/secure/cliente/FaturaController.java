package br.com.wamais.houseCare.controller.secure.cliente;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.wamais.houseCare.controller.AbstractController;
import br.com.wamais.houseCare.domain.Lancamento;
import br.com.wamais.houseCare.domain.LancamentoPK;
import br.com.wamais.houseCare.service.ILancamentoService;

@RestController
@Transactional
@RequestMapping("/empresa/{idEmpresa}/cliente/{idCliente}/fatura")
public class FaturaController extends AbstractController {

	@Autowired
	private transient ILancamentoService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody List<Lancamento> listar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente) {

		return this.service.listarPorIdClienteIdEmpresa(idCliente, idEmpresa);
	}

	@RequestMapping(value = "/detalhar/{id}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Lancamento detalhar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente,
			@PathVariable final Integer id) {

		final LancamentoPK lancamentoPk = new LancamentoPK();
		lancamentoPk.setIdEmpresa(idEmpresa);
		lancamentoPk.setIdCliente(idCliente);
		lancamentoPk.setId(id);

		return this.service.obtemPorId(lancamentoPk);
	}

	@RequestMapping(value = "/criar", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Lancamento criar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente,
			@RequestBody final Lancamento lancamento) {

		final LancamentoPK lancamentoPk = new LancamentoPK();
		lancamentoPk.setIdEmpresa(idEmpresa);
		lancamentoPk.setIdCliente(idCliente);

		lancamento.setId(lancamentoPk);

		return this.service.alterar(lancamento);
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody Lancamento editar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente,
			@RequestBody final Lancamento lancamento, @PathVariable final Integer id) {

		final LancamentoPK lancamentoPk = new LancamentoPK();
		lancamentoPk.setIdEmpresa(idEmpresa);
		lancamentoPk.setIdCliente(idCliente);
		lancamentoPk.setId(id);

		lancamento.setId(lancamentoPk);

		return this.service.alterar(lancamento);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente, @PathVariable final Integer id) {

		final LancamentoPK lancamentoPk = new LancamentoPK();
		lancamentoPk.setIdEmpresa(idEmpresa);
		lancamentoPk.setIdCliente(idCliente);
		lancamentoPk.setId(id);

		this.service.excluirPorId(lancamentoPk);

	}

}
