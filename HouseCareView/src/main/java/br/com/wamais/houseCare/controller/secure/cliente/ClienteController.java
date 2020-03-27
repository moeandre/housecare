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
@RequestMapping("/cliente")
public class ClienteController extends AbstractController {

	@Autowired
	private transient IClienteService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody List<Cliente> listar() {

		return (List<Cliente>) this.service.listarTodos();
	}

	@RequestMapping(value = "/detalhar/{id}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Cliente detalhar(@PathVariable final Integer id) {

		final ClientePK cp = new ClientePK();
		cp.setId(id);

		return this.service.obtemPorId(cp);
	}

	@RequestMapping(value = "/criar", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Cliente criar(@RequestBody final Cliente cliente) {

		final ClientePK cp = new ClientePK();
		cliente.setId(cp);

		return this.service.alterar(cliente);
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody Cliente editar(@RequestBody final Cliente cliente, @PathVariable final Integer id) {

		final ClientePK cp = new ClientePK();
		cp.setId(id);
		cliente.setId(cp);

		return this.service.alterar(cliente);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable final Integer id) {

		final ClientePK cp = new ClientePK();
		cp.setId(id);
		this.service.excluirPorId(cp);

	}

}
