package pt.gnr.gestaoescalas.service;

import java.sql.Date;
import java.util.List;


import pt.gnr.gestaoescalas.dao.ServicoDAOImpl;
import pt.gnr.gestaoescalas.model.Servico;

public class ServicoService {

	private ServicoDAOImpl servicoDAOImpl = new ServicoDAOImpl();
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	public List<Servico> getServicos()
			throws Exception {
		try {
			List<Servico> servicos = servicoDAOImpl.getServicos();
			return servicos;
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

	public List<Servico> getServicosByDate( Date data)
			throws Exception {
		try {
			List<Servico> servicos = servicoDAOImpl.getServicosByDate(data);
			return servicos;
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
	 * @return servico retorna um objecto
	 *
	 * */
	public Servico getServico(int id) throws Exception {

		try {
			Servico servico = servicoDAOImpl.getServico(id);
			return servico;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 *
	 * Adiciona novo objecto
	 *
	 * @param servico
	 *            objecto para adicionar à BD
	 *
	 * */
	public int addServico(Servico servico) throws Exception {

		try {
			return servicoDAOImpl.addServico(servico);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Modifica objecto
	 *
	 * @param servico
	 *            objecto para modificar na BD
	 *
	 * */
	public int updateServico(Servico servico) throws Exception {
		try {
			return servicoDAOImpl.updateServico(servico);
		} catch (Exception e) {
			throw e;
		}


	}

	/**
	 *
	 * Apaga objecto
	 *
	 * @param servico
	 *            objecto para apagar na BD
	 *
	 *
	 * */
	public int deleteServico(Servico s) throws Exception {

		try {
			return servicoDAOImpl.deleteServico(s.getId());
		} catch (Exception e) {
			throw e;
		}
	}
}