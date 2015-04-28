package pt.gnr.gestaoescalas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.dao.GratificadoPessoaDAOImpl;
import pt.gnr.gestaoescalas.model.GratificadoPessoa;

@Controller
@RequestMapping("/gratificadopessoa")
public class GratificadoPessoaController {

	private GratificadoPessoaDAOImpl gratificadoPessoaDAOImpl = new GratificadoPessoaDAOImpl();

	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<GratificadoPessoa> getGratificadoPessoas()
			throws Exception {
		try {
			List<GratificadoPessoa> gratificadoPessoas = gratificadoPessoaDAOImpl.getGratificadoPessoas();
			return gratificadoPessoas;
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
	 * @return gratificadoPessoa retorna um objecto
	 *
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody GratificadoPessoa getGratificadoPessoa(
			@PathVariable("id") int id) throws Exception {

		try {
			GratificadoPessoa gratificadoPessoa = gratificadoPessoaDAOImpl.getGratificadoPessoa(id);
			return gratificadoPessoa;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 *
	 * Adiciona novo objecto
	 *
	 * @param gratificadoPessoa
	 *            objecto para adicionar à BD
	 *
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addGratificadoPessoa(
			@RequestBody GratificadoPessoa gratificadoPessoa) throws Exception {

		try {
			return gratificadoPessoaDAOImpl.addGratificadoPessoa(gratificadoPessoa);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Modifica objecto
	 *
	 * @param gratificadoPessoa
	 *            objecto para modificar na BD
	 *
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updateGratificadoPessoa(
			@RequestBody GratificadoPessoa gratificadoPessoa) throws Exception {

		try {
			return gratificadoPessoaDAOImpl.updateGratificadoPessoa(gratificadoPessoa);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Apaga objecto
	 *
	 * @param gratificadoPessoa
	 *            objecto para apagar na BD
	 *
	 *
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deleteGratificadoPessoa(
			@RequestBody int id) throws Exception {

		try {
			return gratificadoPessoaDAOImpl.deleteGratificadoPessoa(id);
		} catch (Exception e) {
			throw e;
		}
	}
}