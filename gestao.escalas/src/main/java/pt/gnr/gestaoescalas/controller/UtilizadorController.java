package pt.gnr.gestaoescalas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.service.UtilizadorService;
import pt.gnr.gestaoescalas.model.Utilizador;

@Controller
@RequestMapping("/utilizador")
public class UtilizadorController {

	private UtilizadorService utilizadorService = new UtilizadorService();
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Utilizador> getUtilizadores()
			throws Exception {
		try {
			List<Utilizador> utilizadores = utilizadorService.getUtilizadores();
			return utilizadores;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 *
	 * Metodo devolte objecto pelo "/{id}"
	 *
	 * @param id
	 *            do objecto
	 * @return utilizador retorna um objecto
	 *
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody Utilizador getUtilizador(
			@PathVariable("id") int id) throws Exception {

		try {
			Utilizador utilizador = utilizadorService.getUtilizador(id);
			return utilizador;
		} catch (Exception e) {
			throw e;
		}


	}

	/**
	 *
	 * Adiciona novo objecto
	 *
	 * @param utilizador
	 *            objecto para adicionar à BD
	 *
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addUtilizador(
			@RequestBody Utilizador utilizador) throws Exception {
		try {
			return utilizadorService.addUtilizador(utilizador);
		} catch (Exception e) {
			throw e;
		}


	}

	/**
	 *
	 * Modifica objecto
	 *
	 * @param utilizador
	 *            objecto para modificar na BD
	 *
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updateUtilizador(
			@RequestBody Utilizador utilizador) throws Exception {

		try {
			return utilizadorService.updateUtilizador(utilizador);
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 *
	 * Apaga objecto
	 *
	 * @param utilizador
	 *            objecto para apagar na BD
	 *
	 * @return inteiro 1 = ok & 0 = fail
	 *
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deleteUtilizador(
			@RequestBody int id) throws Exception {

		try {
			return utilizadorService.deleteUtilizador(id);
		} catch (Exception e) {
			throw e;
		}

	}
}