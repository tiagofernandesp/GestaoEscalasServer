package pt.gnr.gestaoescalas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.dao.PessoaDAOImpl;
import pt.gnr.gestaoescalas.model.Pessoa;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	private PessoaDAOImpl pessoaDAOImpl = new PessoaDAOImpl();
	
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
			List<Pessoa> pessoas = pessoaDAOImpl.getPessoas();
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
			Pessoa pessoa = pessoaDAOImpl.getPessoa(id);
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
	public @ResponseBody void addPessoa(
			@RequestBody Pessoa pessoa) throws Exception {

		try {
			pessoaDAOImpl.addPessoa(pessoa);
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
	public @ResponseBody void updatePessoa(
			@RequestBody Pessoa pessoa) throws Exception {
		
		try {
			pessoaDAOImpl.updatePessoa(pessoa);
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
	public @ResponseBody void deletePessoa(
			@RequestBody int id) throws Exception {

		try {
			pessoaDAOImpl.deletePessoa(id);
		} catch (Exception e) {
			throw e;
		}
	}
}