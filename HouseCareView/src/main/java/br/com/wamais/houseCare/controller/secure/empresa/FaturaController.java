package br.com.wamais.houseCare.controller.secure.empresa;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.wamais.houseCare.controller.AbstractController;
import br.com.wamais.houseCare.domain.Fatura;
import br.com.wamais.houseCare.service.IFaturaService;

@RestController
@Transactional
@RequestMapping("/empresa/{idEmpresa}/fatura")
public class FaturaController extends AbstractController {

	@Autowired
	private transient IFaturaService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody List<Fatura> listar(@PathVariable final Integer idEmpresa) {

		return this.service.listarPorEmpresa(idEmpresa);
	}

	@RequestMapping(value = "/detalhar/{idFatura}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Fatura detalhar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idFatura) {

		return this.service.obterPorIdEmpresa(idEmpresa, idFatura);
	}
	
	@RequestMapping(value = "/clonar/{idFatura}", method = RequestMethod.PUT)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Fatura clonar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idFatura) {

		return this.service.clonar(idEmpresa, idFatura);
	}


}
