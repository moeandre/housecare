package br.com.wamais.houseCare.controller.configuracao;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.wamais.houseCare.controller.AbstractController;
import br.com.wamais.houseCare.service.IEmpresaService;

@RestController
@Transactional
@RequestMapping("/empresa")
public class EmpresaController extends AbstractController {

	@Autowired
	private transient IEmpresaService service;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody Map<String, Object> listar(final HttpServletResponse response) {

		final Map<String, Object> retval = new HashMap<String, Object>();
		retval.put("success", Boolean.TRUE);
		retval.put("results", this.service.listarTodos());
		return retval;

	}

}
