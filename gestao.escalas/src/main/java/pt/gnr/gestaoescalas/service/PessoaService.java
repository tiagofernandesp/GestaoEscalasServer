package pt.gnr.gestaoescalas.service;

import java.util.List;

import pt.gnr.gestaoescalas.dao.PessoaDAOImpl;
import pt.gnr.gestaoescalas.model.Pessoa;

public class PessoaService {

	private PessoaDAOImpl pessoaDAOImpl = new PessoaDAOImpl();

	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	public List<Pessoa> getPessoas()
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
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	public List<Pessoa> getPessoasAtivas()
			throws Exception {
		try {
			List<Pessoa> pessoas = pessoaDAOImpl.getPessoasAtivas();
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
	public Pessoa getPessoa(int id) throws Exception {

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
	public int addPessoa(Pessoa pessoa) throws Exception {

		try {
			return pessoaDAOImpl.addPessoa(pessoa);
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
	public int updatePessoa(Pessoa pessoa) throws Exception {

		try {
			return pessoaDAOImpl.updatePessoa(pessoa);
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
	public int deletePessoa(int id) throws Exception {

		try {
			return pessoaDAOImpl.deletePessoa(id);
		} catch (Exception e) {
			throw e;
		}
	}
}