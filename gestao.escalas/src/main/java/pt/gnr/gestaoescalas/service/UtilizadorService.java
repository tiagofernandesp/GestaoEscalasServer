package pt.gnr.gestaoescalas.service;

import java.util.List;

import pt.gnr.gestaoescalas.dao.UtilizadorDAOImpl;
import pt.gnr.gestaoescalas.model.Utilizador;

public class UtilizadorService {

	private UtilizadorDAOImpl utilizadorDAOImpl = new UtilizadorDAOImpl();
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	public List<Utilizador> getUtilizadores()
			throws Exception {
		try {
			List<Utilizador> utilizadores = utilizadorDAOImpl.getUtilizadores();
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
	public Utilizador getUtilizador(int id) throws Exception {

		try {
			Utilizador utilizador = utilizadorDAOImpl.getUtilizador(id);
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
	public int addUtilizador(Utilizador utilizador) throws Exception {
		try {
			return utilizadorDAOImpl.addUtilizador(utilizador);
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
	public int updateUtilizador(Utilizador utilizador) throws Exception {

		try {
			return utilizadorDAOImpl.updateUtilizador(utilizador);
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
	public int deleteUtilizador(int id) throws Exception {

		try {
			return utilizadorDAOImpl.deleteUtilizador(id);
		} catch (Exception e) {
			throw e;
		}

	}
}