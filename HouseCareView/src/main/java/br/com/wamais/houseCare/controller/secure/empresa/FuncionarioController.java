package br.com.wamais.houseCare.controller.secure.empresa;

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
import br.com.wamais.houseCare.domain.Funcionario;
import br.com.wamais.houseCare.domain.FuncionarioPK;
import br.com.wamais.houseCare.service.IFuncionarioService;

@RestController
@Transactional
@RequestMapping("/empresa/{idEmpresa}/funcionario")
public class FuncionarioController extends AbstractController {

	@Autowired
	private transient IFuncionarioService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody List<Funcionario> listar(@PathVariable final Integer idEmpresa) {

		return this.service.listarPorEmpresa(idEmpresa);
	}

	@RequestMapping(value = "/detalhar/{idUsuario}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Funcionario detalhar(@PathVariable final Integer idEmpresa, @PathVariable final Integer idUsuario) {

		return this.service.obterPorIdEmpresaIdUsuario(idEmpresa, idUsuario);
	}

	@RequestMapping(value = "/criar", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Funcionario criar(@PathVariable final Integer idEmpresa, @RequestBody final Funcionario funcionario) {

		final FuncionarioPK funcionarioPk = new FuncionarioPK();
		funcionarioPk.setIdEmpresa(idEmpresa);
		
		funcionario.setId(funcionarioPk);

		return this.service.alterar(funcionario);
	}

	@RequestMapping(value = "/editar/{idUsuario}", method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody Funcionario editar(@PathVariable final Integer idEmpresa, @RequestBody final Funcionario funcionario, @PathVariable final Integer idUsuario) {

		final FuncionarioPK funcionarioPk = new FuncionarioPK();
		funcionarioPk.setIdEmpresa(idEmpresa);
		funcionarioPk.setIdUsuario(idUsuario);
		
		funcionario.setId(funcionarioPk);
		
		return this.service.alterar(funcionario);
		
	}

}
