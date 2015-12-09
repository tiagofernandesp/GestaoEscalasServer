package pt.gnr.gestaoescalas.service;

import java.util.List;

import pt.gnr.gestaoescalas.dao.ViaturaDAOImpl;
import pt.gnr.gestaoescalas.model.Viatura;

public class ViaturaService {

	private ViaturaDAOImpl viaturaDAOImpl = new ViaturaDAOImpl();
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	public List<Viatura> getViaturas()
			throws Exception {
		try {
			List<Viatura> viaturas = viaturaDAOImpl.getViaturas();
			return viaturas;
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
	 * @return viatura retorna um objecto
	 *
	 * */
	public Viatura getViatura(int id) throws Exception {

		try {
			Viatura viatura = viaturaDAOImpl.getViatura(id);
			return viatura;
		} catch (Exception e) {
			throw e;
		}


	}

	/**
	 *
	 * Adiciona novo objecto
	 *
	 * @param viatura
	 *            objecto para adicionar à BD
	 *
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	public int addViatura(Viatura viatura) throws Exception {
		try {
			return viaturaDAOImpl.addViatura(viatura);
		} catch (Exception e) {
			throw e;
		}


	}

	/**
	 *
	 * Modifica objecto
	 *
	 * @param viatura
	 *            objecto para modificar na BD
	 *
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	public int updateViatura(Viatura viatura) throws Exception {

		try {
			return viaturaDAOImpl.updateViatura(viatura);
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 *
	 * Apaga objecto
	 *
	 * @param viatura
	 *            objecto para apagar na BD
	 *
	 * @return inteiro 1 = ok & 0 = fail
	 *
	 * */
	public int deleteViatura(int id) throws Exception {

		try {
			return viaturaDAOImpl.deleteViatura(id);
		} catch (Exception e) {
			throw e;
		}

	}
}