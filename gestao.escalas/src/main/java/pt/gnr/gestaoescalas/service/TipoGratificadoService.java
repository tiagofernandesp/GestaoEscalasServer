package pt.gnr.gestaoescalas.service;

import java.util.List;

import pt.gnr.gestaoescalas.dao.TipoGratificadoDAOImpl;
import pt.gnr.gestaoescalas.model.TipoGratificado;

public class TipoGratificadoService {

	private TipoGratificadoDAOImpl tipoGratificadoDAOImpl = new TipoGratificadoDAOImpl();
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	public List<TipoGratificado> getTipoGratificados() throws Exception {
		try {
			List<TipoGratificado> tipoGratificados = tipoGratificadoDAOImpl.getTipoGratificados();
			return tipoGratificados;
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
	 * @return tipoGratificado retorna um objecto
	 *
	 * */
	public TipoGratificado getTipoGratificado(int id) throws Exception {

		try {
			TipoGratificado tipoGratificado = tipoGratificadoDAOImpl.getTipoGratificado(id);
			return tipoGratificado;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 *
	 * Adiciona novo objecto
	 *
	 * @param tipoGratificado
	 *            objecto para adicionar à BD
	 *
	 * */
	public int addTipoGratificado(TipoGratificado tipoGratificado) throws Exception {

		try {
			return tipoGratificadoDAOImpl.addTipoGratificado(tipoGratificado);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Modifica objecto
	 *
	 * @param tipoGratificado
	 *            objecto para modificar na BD
	 *
	 * */
	public int updateTipoGratificado(TipoGratificado tipoGratificado) throws Exception {

		try {
			return tipoGratificadoDAOImpl.updateTipoGratificado(tipoGratificado);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Apaga objecto
	 *
	 * @param tipoGratificado
	 *            objecto para apagar na BD
	 *
	 *
	 * */
	public int deleteTipoGratificado( int id) throws Exception {

		try {
			return tipoGratificadoDAOImpl.deleteTipoGratificado(id);
		} catch (Exception e) {
			throw e;
		}
	}
}