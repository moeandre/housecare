package br.com.wamais.houseCare.controller.secure.cliente;

import java.util.HashMap;
import java.util.Map;

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
	public @ResponseBody Map<String, Object> listar() {

		final Map<String, Object> retval = new HashMap<String, Object>();
		retval.put("success", Boolean.TRUE);
		retval.put("results", this.service.listarTodos());
		return retval;
	}

	@RequestMapping(value = "/detalhar/{id}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Map<String, Object> detalhar(@PathVariable final Integer id) {

		final Map<String, Object> retval = new HashMap<String, Object>();
		retval.put("success", Boolean.TRUE);
		final ClientePK cp = new ClientePK();
		cp.setId(id);
		retval.put("result", this.service.obtemPorId(cp));

		return retval;
	}

	@RequestMapping(value = "/criar", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map<String, Object> criar(@RequestBody final Cliente cliente) {

		final ClientePK cp = new ClientePK();
		cliente.setId(cp);
		this.service.alterar(cliente);

		final Map<String, Object> retval = new HashMap<String, Object>();
		retval.put("success", Boolean.TRUE);
		retval.put("result", cliente);
		return retval;
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody Map<String, Object> editar(@RequestBody final Cliente cliente, @PathVariable final Integer id) {

		final ClientePK cp = new ClientePK();
		cp.setId(id);
		cliente.setId(cp);
		this.service.alterar(cliente);

		final Map<String, Object> retval = new HashMap<String, Object>();
		retval.put("success", Boolean.TRUE);
		return retval;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> delete(@PathVariable final Integer id) {

		final ClientePK cp = new ClientePK();
		cp.setId(id);
		this.service.excluirPorId(cp);

		final Map<String, Object> retval = new HashMap<String, Object>();
		retval.put("success", Boolean.TRUE);
		return retval;
	}

}
