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
import br.com.wamais.houseCare.domain.Cliente;
import br.com.wamais.houseCare.domain.ClientePK;
import br.com.wamais.houseCare.service.IClienteService;

@RestController
@Transactional
@RequestMapping("/empresa/{idEmpresa}/cliente")
public class ClienteController extends AbstractController {

	@Autowired
	private transient IClienteService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody List<Cliente> listar(@PathVariable final Integer idEmpresa) {

		return (List<Cliente>) this.service.listarPorEmpresa(idEmpresa);
	}

	@RequestMapping(value = "/detalhar/{id}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Cliente detalhar(@PathVariable final Integer idEmpresa, @PathVariable final Integer id) {

		final ClientePK clientePk = new ClientePK();
		clientePk.setIdEmpresa(idEmpresa);
		clientePk.setId(id);

		return this.service.obtemPorId(clientePk);
	}

	@RequestMapping(value = "/criar", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Cliente criar(@PathVariable final Integer idEmpresa, @RequestBody final Cliente cliente) {

		final ClientePK clientePk = new ClientePK();
		clientePk.setIdEmpresa(idEmpresa);
		cliente.setId(clientePk);

		return this.service.alterar(cliente);
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody Cliente editar(@PathVariable final Integer idEmpresa, @RequestBody final Cliente cliente, @PathVariable final Integer id) {

		final ClientePK clientePk = new ClientePK();
		clientePk.setId(id);
		clientePk.setIdEmpresa(idEmpresa);

		cliente.setId(clientePk);

		return this.service.alterar(cliente);
	}

}
