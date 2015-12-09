package pt.gnr.gestaoescalas.service;

import java.util.List;

import pt.gnr.gestaoescalas.dao.TipoServicoDAOImpl;
import pt.gnr.gestaoescalas.model.TipoServico;

public class TipoServicoService {

	private TipoServicoDAOImpl tipoServicoDAOImpl = new TipoServicoDAOImpl();
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	public List<TipoServico> getTipoServicos()
			throws Exception {

		try {
			List<TipoServico> tipoServicos = tipoServicoDAOImpl.getTipoServicos();
			return tipoServicos;
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
	 * @return tipoServico retorna um objecto
	 *
	 * */
	public TipoServico getTipoServico(int id) throws Exception {

		try {
			TipoServico tipoServico = tipoServicoDAOImpl.getTipoServico(id);
			return tipoServico;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 *
	 * Adiciona novo objecto
	 *
	 * @param tipoServico
	 *            objecto para adicionar à BD
	 *
	 * */
	public int addTipoServico(TipoServico tipoServico) throws Exception {

		try {
			return tipoServicoDAOImpl.addTipoServico(tipoServico);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Modifica objecto
	 *
	 * @param tipoServico
	 *            objecto para modificar na BD
	 *
	 * */
	public int updateTipoServico(TipoServico tipoServico) throws Exception {

		try {
			return tipoServicoDAOImpl.updateTipoServico(tipoServico);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Apaga objecto
	 *
	 * @param tipoServico
	 *            objecto para apagar na BD
	 *
	 *
	 * */
	public int deleteTipoServico(int id) throws Exception {

		try {
			return tipoServicoDAOImpl.deleteTipoServico(id);
		} catch (Exception e) {
			throw e;
		}
	}
}