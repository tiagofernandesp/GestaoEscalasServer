package pt.gnr.gestaoescalas.service;

import java.sql.Date;
import java.util.List;

import pt.gnr.gestaoescalas.dao.GratificadoDAOImpl;
import pt.gnr.gestaoescalas.model.Gratificado;

public class GratificadoService {

	private GratificadoDAOImpl gratificadoDAOImpl = new GratificadoDAOImpl();
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	public List<Gratificado> getGratificados()
			throws Exception {
		try {
			List<Gratificado> gratificados = gratificadoDAOImpl.getGratificados();
			return gratificados;
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
	 * @return gratificado retorna um objecto
	 *
	 * */
	public Gratificado getGratificado(int id) throws Exception {
		try {
			Gratificado gratificado = gratificadoDAOImpl.getGratificado(id);
			return gratificado;
		} catch (Exception e) {
			throw e;
		}

	}
	/**
	 *
	 * Devolve todos objetos da tabela por data
	 *
	 * @return Lista de objectos
	 * */

	public List<Gratificado> getGratificadosByDate(Date data)
			throws Exception {
		try {
			List<Gratificado> gratificados = gratificadoDAOImpl.getGratificadosByDate(data);
			return gratificados;
		} catch (Exception e) {
			throw e;
		}

	}
	/**
	 *
	 * Adiciona novo objecto
	 *
	 * @param gratificado
	 *            objecto para adicionar à BD
	 *
	 * */
	public int addGratificado(Gratificado gratificado) throws Exception {
		try {
			return gratificadoDAOImpl.addGratificado(gratificado);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Modifica objecto
	 *
	 * @param gratificado
	 *            objecto para modificar na BD
	 *
	 * */
	public int updateGratificado(Gratificado gratificado) throws Exception {
		try {
			return gratificadoDAOImpl.updateGratificado(gratificado);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Apaga objecto
	 *
	 * @param gratificado
	 *            id objecto para apagar na BD
	 *
	 *
	 * */
	public int deleteGratificado(int id) throws Exception {
		try {
			return gratificadoDAOImpl.deleteGratificado(id);
		} catch (Exception e) {
			throw e;
		}
	}
}