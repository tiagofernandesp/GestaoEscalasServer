package pt.gnr.gestaoescalas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.dao.HabilitaServicoDAOImpl;
import pt.gnr.gestaoescalas.dao.PessoaDAOImpl;
import pt.gnr.gestaoescalas.model.HabilitaServico;
import pt.gnr.gestaoescalas.model.TipoServico;

@Controller
@RequestMapping("/habilitaservico")
public class HabilitaServicoController {

	private HabilitaServicoDAOImpl habilitaServicoDAOImpl = new HabilitaServicoDAOImpl();
	private PessoaDAOImpl pessoaDAOImpl = new PessoaDAOImpl();
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<HabilitaServico> getHabilitaServicos()
			throws Exception {
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
	@RequestMapping(method = RequestMethod.GET, value = "/pessoa/{id}")
	public @ResponseBody List<TipoServico> getHabilitaServicoByPerson(
			@PathVariable("id") int id) throws Exception {

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
	@RequestMapping(method = RequestMethod.PUT, value = "/pessoa/{id}")
	public @ResponseBody int updateHabilitaServicos(
			@PathVariable("id") int id ,@RequestBody  List<TipoServico> tipoServicos) throws Exception {

		try {
			boolean b = false;
			HabilitaServico hServico = new HabilitaServico();
			List<TipoServico> oldTipoServicos = getHabilitaServicoByPerson(id);
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
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody HabilitaServico getHabilitaServico(
			@PathVariable("id") int id) throws Exception {

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
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addHabilitaServico(
			@RequestBody HabilitaServico habilitaServico) throws Exception {

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
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updateHabilitaServico(
			@RequestBody HabilitaServico habilitaServico) throws Exception {

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
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deleteHabilitaServico(
			@RequestBody int id) throws Exception {

		try {

			return habilitaServicoDAOImpl.deleteHabilitaServico(id);
		} catch (Exception e) {
			throw e;
		}
	}
}