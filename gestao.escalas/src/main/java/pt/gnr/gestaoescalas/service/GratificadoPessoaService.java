package pt.gnr.gestaoescalas.service;

import java.util.List;

import pt.gnr.gestaoescalas.dao.GratificadoPessoaDAOImpl;
import pt.gnr.gestaoescalas.model.GratificadoPessoa;

public class GratificadoPessoaService {

	private GratificadoPessoaDAOImpl gratificadoPessoaDAOImpl = new GratificadoPessoaDAOImpl();

	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	public List<GratificadoPessoa> getGratificadoPessoas() throws Exception {
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
	public GratificadoPessoa getGratificadoPessoa(int id) throws Exception {

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
	public int addGratificadoPessoa(GratificadoPessoa gratificadoPessoa) throws Exception {

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
	public int updateGratificadoPessoa( GratificadoPessoa gratificadoPessoa) throws Exception {

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
	public int deleteGratificadoPessoa(int id) throws Exception {

		try {
			return gratificadoPessoaDAOImpl.deleteGratificadoPessoa(id);
		} catch (Exception e) {
			throw e;
		}
	}
}