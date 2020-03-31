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
import br.com.wamais.houseCare.domain.Familiar;
import br.com.wamais.houseCare.domain.FamiliarPK;
import br.com.wamais.houseCare.service.IFamiliarService;

@RestController
@Transactional
@RequestMapping("/empresa/{idEmpresa}/cliente/{idCliente}/familiar")
public class FamiliarController extends AbstractController {

	@Autowired
	private transient IFamiliarService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody List<Familiar> listar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente) {

		return this.service.listarPorIdClienteIdEmpresa(idCliente, idEmpresa);
	}

	@RequestMapping(value = "/detalhar/{id}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Familiar detalhar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente,
			@PathVariable final Integer id) {

		final FamiliarPK familiarPk = new FamiliarPK();
		familiarPk.setIdEmpresa(idEmpresa);
		familiarPk.setIdCliente(idCliente);
		familiarPk.setIdFamiliar(id);

		return this.service.obtemPorId(familiarPk);
	}

	@RequestMapping(value = "/criar", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Familiar criar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente,
			@RequestBody final Familiar familiar) {

		final FamiliarPK familiarPk = new FamiliarPK();
		familiarPk.setIdEmpresa(idEmpresa);
		familiarPk.setIdCliente(idCliente);
		familiar.setId(familiarPk);

		return this.service.alterar(familiar);
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody Familiar editar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente,
			@RequestBody final Familiar familiar, @PathVariable final Integer id) {

		final FamiliarPK familiarPk = new FamiliarPK();
		familiarPk.setIdEmpresa(idEmpresa);
		familiarPk.setIdCliente(idCliente);
		familiarPk.setIdFamiliar(id);

		familiar.setId(familiarPk);

		return this.service.alterar(familiar);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente, @PathVariable final Integer id) {

		final FamiliarPK familiarPk = new FamiliarPK();
		familiarPk.setIdEmpresa(idEmpresa);
		familiarPk.setIdCliente(idCliente);
		familiarPk.setIdFamiliar(id);

		this.service.excluirPorId(familiarPk);

	}

}
