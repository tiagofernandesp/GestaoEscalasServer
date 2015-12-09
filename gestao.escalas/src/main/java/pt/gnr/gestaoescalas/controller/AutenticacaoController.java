package pt.gnr.gestaoescalas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.service.AutenticacaoService;
import pt.gnr.gestaoescalas.model.Autenticacao;
import pt.gnr.gestaoescalas.model.Utilizador;

@Controller
@RequestMapping("/autenticacao")
public class AutenticacaoController {

	private AutenticacaoService autenticacaoService = new AutenticacaoService();
	
	/**
	 * 
	 * @param utilizador
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public @ResponseBody Autenticacao login(
			@RequestBody Utilizador utilizador) throws Exception {
		try {
			
			return autenticacaoService.login(utilizador);
				
		} catch (Exception e) {
			throw e;
		}


	}
	/***
	 * 
	 * @param autenticacao
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	public @ResponseBody int logout(
			@RequestBody Autenticacao autenticacao) throws Exception {
		try {
			return autenticacaoService.logout(autenticacao);
		} catch (Exception e) {
			throw e;
		}


	}	
}