package br.com.wamais.houseCare.controller.secure.configuracao;

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
import br.com.wamais.houseCare.domain.Usuario;
import br.com.wamais.houseCare.service.IUsuarioService;

@RestController
@Transactional
@RequestMapping("/admin/usuario")
public class UsuarioController extends AbstractController {

	@Autowired
	private transient IUsuarioService service;

	
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
		retval.put("result", this.service.obtemPorId(id));
		return retval;
	}

	
	@RequestMapping(value = "/criar", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map<String, Object> criar(@RequestBody final Usuario usuario) {

		usuario.setId(0);
		this.service.alterar(usuario);

		final Map<String, Object> retval = new HashMap<String, Object>();
		retval.put("success", Boolean.TRUE);
		retval.put("result", usuario);
		return retval;
	}

	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map<String, Object> editar(@RequestBody final Usuario usuario, @PathVariable final Integer id) {

		usuario.setId(id);
		this.service.alterar(usuario);

		final Map<String, Object> retval = new HashMap<String, Object>();
		retval.put("success", Boolean.TRUE);
		return retval;
	}

	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> delete(@PathVariable final Integer id) {

		this.service.excluirPorId(id);

		final Map<String, Object> retval = new HashMap<String, Object>();
		retval.put("success", Boolean.TRUE);
		return retval;
	}

}
