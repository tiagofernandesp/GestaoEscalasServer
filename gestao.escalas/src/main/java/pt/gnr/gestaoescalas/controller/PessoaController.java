package pt.gnr.gestaoescalas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.service.PessoaService;
import pt.gnr.gestaoescalas.model.Pessoa;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	private PessoaService pessoaService = new PessoaService();

	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Pessoa> getPessoas()
			throws Exception {
		try {
			List<Pessoa> pessoas = pessoaService.getPessoas();
			return pessoas;
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	@RequestMapping(value="/ativa", method = RequestMethod.GET)
	public @ResponseBody List<Pessoa> getPessoasAtivas()
			throws Exception {
		try {
			List<Pessoa> pessoas = pessoaService.getPessoasAtivas();
			return pessoas;
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
	 * @return Pessoa retorna um objecto
	 *
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody Pessoa getPessoa(
			@PathVariable("id") int id) throws Exception {

		try {
			Pessoa pessoa = pessoaService.getPessoa(id);
			return pessoa;
		} catch (Exception e) {
			throw e;
		}


	}

	/**
	 *
	 * Adiciona novo objecto
	 *
	 * @param Pessoa
	 *            objecto para adicionar à BD
	 *
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addPessoa(
			@RequestBody Pessoa pessoa) throws Exception {

		try {
			return pessoaService.addPessoa(pessoa);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Modifica objecto
	 *
	 * @param Pessoa
	 *            objecto para modificar na BD
	 *
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updatePessoa(
			@RequestBody Pessoa pessoa) throws Exception {

		try {
			return pessoaService.updatePessoa(pessoa);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Apaga objecto
	 *
	 * @param Pessoa
	 *            objecto para apagar na BD
	 *
	 *
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deletePessoa(
			@RequestBody int id) throws Exception {

		try {
			return pessoaService.deletePessoa(id);
		} catch (Exception e) {
			throw e;
		}
	}
}