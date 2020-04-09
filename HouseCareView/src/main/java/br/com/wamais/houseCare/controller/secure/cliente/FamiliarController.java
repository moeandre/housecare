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
import br.com.wamais.houseCare.domain.Familiar;
import br.com.wamais.houseCare.service.IFamiliarService;

@RestController
@Transactional
@RequestMapping("/empresa/{idEmpresa}")
public class FamiliarController extends AbstractController {

	@Autowired
	private transient IFamiliarService service;

	@RequestMapping(value = "/cliente/{idCliente}/familiar/listar", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody List<Familiar> listar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente) {

		return this.service.listarPorIdClienteIdEmpresa(idCliente, idEmpresa);
	}

	@RequestMapping(value = "/familiar/listar", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody List<Familiar> listar(@PathVariable final Integer idEmpresa) {

		return this.service.listarPorIdEmpresa(idEmpresa);
	}

	@RequestMapping(value = "/cliente/{idCliente}/familiar/detalhar/{id}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Familiar detalhar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente,
			@PathVariable final Integer id) {

		/**
		 * 
		 TODO: Implementar
		final FamiliarPK familiarPk = new FamiliarPK();
		familiarPk.setIdEmpresa(idEmpresa);
		familiarPk.setIdCliente(idCliente);
		familiarPk.setIdFamiliar(id);
		 */
		return this.service.obtemPorId(id);
	}

	@RequestMapping(value = "/familiar/detalhar/{idFamiliar}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Familiar detalhar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idFamiliar) {

		return this.service.obterPorIdFamiliar(idFamiliar, idEmpresa);
	}

	@RequestMapping(value = "/cliente/{idCliente}/familiar/criar", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Familiar criar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente,
			@Valid @RequestBody final Familiar familiar) {

		/**
		 * 
		 * TODO: implementar
		final FamiliarPK familiarPk = new FamiliarPK();
		familiarPk.setIdEmpresa(idEmpresa);
		familiarPk.setIdCliente(idCliente);
		familiar.setId(familiarPk);*/

		return this.service.alterar(familiar);
	}

	@RequestMapping(value = "/cliente/{idCliente}/familiar/editar/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody Familiar editar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente,
			@Valid @RequestBody final Familiar familiar, @PathVariable final Integer id) {

//		familiarPk.setIdCliente(idCliente);

		familiar.setIdFamiliar(id);
		familiar.setIdEmpresa(idEmpresa);

		return this.service.alterar(familiar);
	}

	@RequestMapping(value = "/cliente/{idCliente}/familiar/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable final Integer idEmpresa, @PathVariable final Integer idCliente, @PathVariable final Integer id) {

		/**
		TODO: implementar
		*/ 
//		familiar.setIdFamiliar(id);
//		familiar.setIdEmpresa(idEmpresa);

		this.service.excluirPorId(id);

	}

	@RequestMapping(value = "/familiar/delete/{idFamiliar}", method = RequestMethod.DELETE)
	public @ResponseBody void delete(@PathVariable final Integer idEmpresa, @PathVariable final Integer idFamiliar) {

		this.service.excluirPorIdFamiliar(idFamiliar, idEmpresa);

	}

}
