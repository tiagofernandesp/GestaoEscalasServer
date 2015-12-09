package pt.gnr.gestaoescalas.service;

import java.util.ArrayList;
import java.util.List;


import pt.gnr.gestaoescalas.dao.HabilitaServicoDAOImpl;
import pt.gnr.gestaoescalas.dao.PessoaDAOImpl;
import pt.gnr.gestaoescalas.model.HabilitaServico;
import pt.gnr.gestaoescalas.model.TipoServico;

public class HabilitaServicoService {

	private HabilitaServicoDAOImpl habilitaServicoDAOImpl = new HabilitaServicoDAOImpl();
	private PessoaDAOImpl pessoaDAOImpl = new PessoaDAOImpl();
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	public List<HabilitaServico> getHabilitaServicos() throws Exception {
		try{
			List<HabilitaServico> habilitaServicos = habilitaServicoDAOImpl.getHabilitaServicos();
			return habilitaServicos;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Metodo devolte objectoS pelo "/{id }" da pessoa
	 *
	 * @param id
	 *            do objecto
	 * @return HabilitaServico retorna lista de objectos
	 *
	 * */
	public List<TipoServico> getHabilitaServicosByPerson(int id) throws Exception {

		try {
			List<HabilitaServico> habilitaServicos = habilitaServicoDAOImpl.getHabilitaServicosByPerson(id);
			List<TipoServico> tipoServico = new ArrayList<TipoServico>();
			for(HabilitaServico hServico : habilitaServicos) {
				tipoServico.add(hServico.getTipoServico());
			}
			return tipoServico;

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Adiciona novo objecto
	 *
	 * @param HabilitaServico
	 *            objecto para adicionar à BD
	 *
	 * */
	public int updateHabilitaServicos(int id , List<TipoServico> tipoServicos) throws Exception {

		try {
			boolean b = false;
			HabilitaServico hServico = new HabilitaServico();
			List<TipoServico> oldTipoServicos = getHabilitaServicosByPerson(id);
			for(TipoServico tServico : tipoServicos) {
				hServico = habilitaServicoDAOImpl.getByTServicoAndPessoa(tServico.getId(), id);
			    if (hServico==null) {
			    	hServico = new HabilitaServico();
			    	hServico.setPessoa(pessoaDAOImpl.getPessoa(id));
			    	hServico.setTipoServico(tServico);
			    	habilitaServicoDAOImpl.addHabilitaServico(hServico);
				}
			}

			for(TipoServico oldTServico : oldTipoServicos) {
				for(TipoServico tServico : tipoServicos) {
					if (oldTServico.getId()==tServico.getId()) {
						b=true;
					}
				}
				if (b==false) {
					hServico = habilitaServicoDAOImpl.getByTServicoAndPessoa(oldTServico.getId(), id);
					habilitaServicoDAOImpl.deleteHabilitaServico(hServico.getId());
				}
				b=false;
			}
			return 1;
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
	 * @return HabilitaServico retorna um objecto
	 *
	 * */
	public HabilitaServico getHabilitaServico( int id) throws Exception {

		try {
			HabilitaServico habilitaServico = habilitaServicoDAOImpl.getHabilitaServico(id);
			return habilitaServico;

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Adiciona novo objecto
	 *
	 * @param HabilitaServico
	 *            objecto para adicionar à BD
	 *
	 * */
	public int addHabilitaServico(HabilitaServico habilitaServico) throws Exception {

		try {

			return habilitaServicoDAOImpl.addHabilitaServico(habilitaServico);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Modifica objecto
	 *
	 * @param HabilitaServico
	 *            objecto para modificar na BD
	 *
	 * */
	public int updateHabilitaServico(HabilitaServico habilitaServico) throws Exception {

		try {

			return habilitaServicoDAOImpl.updateHabilitaServico(habilitaServico);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Apaga objecto
	 *
	 * @param HabilitaServico
	 *            objecto para apagar na BD
	 *
	 *
	 * */
	public int deleteHabilitaServico(int id) throws Exception {

		try {

			return habilitaServicoDAOImpl.deleteHabilitaServico(id);
		} catch (Exception e) {
			throw e;
		}
	}
}