package pt.gnr.gestaoescalas.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.dao.ConfiguracaoDAOImpl;
import pt.gnr.gestaoescalas.model.Configuracao;

@Controller
@RequestMapping("/configuracao")
public class ConfiguracaoController {
	
	private ConfiguracaoDAOImpl configuracaoDAOImpl = new ConfiguracaoDAOImpl(); 
	/**
	 * 
	 * Metodo devolte objecto pelo "/{id}"
	 * 
	 * @param id
	 *            do objecto
	 * @return configuracao retorna um objecto
	 * 
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody Configuracao getConfiguracao(
			@PathVariable("id") int id) throws Exception {

		try {
			Configuracao configuracao = configuracaoDAOImpl.getConfiguracao(id);
			return configuracao;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * 
	 * Adiciona novo objecto
	 * 
	 * @param configuracao
	 *            objecto para adicionar à BD
	 * 
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void addConfiguracao(
			@RequestBody Configuracao configuracao) throws Exception {
		
		try {
			configuracaoDAOImpl.addConfiguracao(configuracao);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * Modifica objecto
	 * 
	 * @param configuracao
	 *            objecto para modificar na BD
	 * 
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody void updateConfiguracao(
			@RequestBody Configuracao configuracao) throws Exception {
		try {
			configuracaoDAOImpl.updateConfiguracao(configuracao);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * Apaga objecto
	 * 
	 * @param configuracao
	 *            objecto para apagar na BD
	 * 
	 * 
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void deleteConfiguracao(
			@RequestBody int id) throws Exception {

		try {
			configuracaoDAOImpl.deleteConfiguracao(id);
		} catch (Exception e) {
			throw e;
		}
	}
}