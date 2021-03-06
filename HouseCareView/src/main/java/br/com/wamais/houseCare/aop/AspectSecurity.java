package br.com.wamais.houseCare.aop;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Produces;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.wamais.houseCare.domain.Usuario;
import br.com.wamais.houseCare.exception.SessaoExpiradaException;
import br.com.wamais.houseCare.exception.UsuarioNaoEncontradoException;
import br.com.wamais.houseCare.service.ILoginService;

@Configuration
@EnableAspectJAutoProxy()
@Aspect
public class AspectSecurity {

	private final Logger logger = LoggerFactory.getLogger(AspectSecurity.class);

	@Autowired
	private ILoginService service;

	@Produces
	// @Around("@annotation(br.com.wamais.houseCare.annotation.UserRequired)")
	@Around("execution(* br.com.wamais.houseCare.controller.secure..*Controller.*(..)) && !@annotation(br.com.wamais.houseCare.annotation.PublicApi)")
	public Object doBasicProfilingAtAnnotated(final ProceedingJoinPoint pjp) throws Throwable {

		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		final String hash = request.getHeader("user-token");
		return this.performProfilling(pjp, hash);

	}

	Object performProfilling(final ProceedingJoinPoint pjp, final String hash) throws Throwable {

		final Object[] signatureArgs = pjp.getArgs();
		this.logger.info("hash " + hash);

		try {
			if (null == hash) {
				throw new UsuarioNaoEncontradoException("Hash não encontrado");
			}
			final Usuario usuario = this.service.validarSessao(hash);
			if (null == usuario) {
				throw new SessaoExpiradaException("Sessão Expirada");
			}

			int signatureIndex = 0;
			for (final Object signatureArg : signatureArgs) {
				if (signatureArg instanceof Usuario) {
					signatureArgs[signatureIndex] = usuario;
					break;
				}
				signatureIndex++;
			}

		} catch (final Exception e) {
			throw new UsuarioNaoEncontradoException("Hash inválido", e);
		}

		return pjp.proceed(signatureArgs);
	}

}
