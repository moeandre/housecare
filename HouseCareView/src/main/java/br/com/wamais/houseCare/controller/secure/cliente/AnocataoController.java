package br.com.wamais.houseCare.controller.secure.cliente;

import java.util.List;

import javax.validation.Valid;
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
import br.com.wamais.houseCare.domain.Anotacao;
import br.com.wamais.houseCare.domain.AnotacaoPK;
import br.com.wamais.houseCare.domain.Usuario;
import br.com.wamais.houseCare.service.IAnotacaoService;

@RestController
@Transactional
@RequestMapping("/empresa/{idEmpresa}/cliente/{idCliente}/anotacao")
public class AnocataoController extends AbstractController {

	@Autowired
	private transient IAnotacaoService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody List<Anotacao> listar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente) {

		return this.service.listarPorIdClienteIdEmpresa(idCliente, idEmpresa);
	}

	@RequestMapping(value = "/detalhar/{id}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Anotacao detalhar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente,
			@PathVariable final Integer id) {

		return this.service.obterPorIdClienteIdEmpresaIdAnotacao(idCliente, idEmpresa, id);

	}

	@RequestMapping(value = "/criar", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Anotacao criar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente,
			@Valid @RequestBody final Anotacao anotacao, final Usuario usuario) {

		final AnotacaoPK anotacaoPk = new AnotacaoPK();
		anotacaoPk.setIdEmpresa(idEmpresa);
		anotacaoPk.setIdCliente(idCliente);
		anotacaoPk.setIdUsuario(usuario.getId());

		anotacao.setId(anotacaoPk);

		return this.service.alterar(anotacao);
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody Anotacao editar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente,
			@Valid @RequestBody final Anotacao anotacao, @PathVariable final Integer id, final Usuario usuario) {

		final AnotacaoPK anotacaoPk = new AnotacaoPK();
		anotacaoPk.setIdEmpresa(idEmpresa);
		anotacaoPk.setIdCliente(idCliente);
		anotacaoPk.setIdUsuario(usuario.getId());
		anotacaoPk.setId(id);

		anotacao.setId(anotacaoPk);

		return this.service.alterar(anotacao);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente, @PathVariable final Integer id) {

		this.service.excluirPorIdClienteIdEmpresaIdAnotacao(idCliente, idEmpresa, id);

	}

}
