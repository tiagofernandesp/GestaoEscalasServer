package pt.gnr.gestaoescalas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.dao.HabilitaServicoDAOImpl;
import pt.gnr.gestaoescalas.model.HabilitaServico;

@Controller
@RequestMapping("/habilitaservico")
public class HabilitaServicoController {

	private HabilitaServicoDAOImpl habilitaServicoDAOImpl = new HabilitaServicoDAOImpl();
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
	public @ResponseBody void addHabilitaServico(
			@RequestBody HabilitaServico habilitaServico) throws Exception {

		try {

			habilitaServicoDAOImpl.addHabilitaServico(habilitaServico);
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
	public @ResponseBody void updateHabilitaServico(
			@RequestBody HabilitaServico habilitaServico) throws Exception {

		try {

			habilitaServicoDAOImpl.updateHabilitaServico(habilitaServico);
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
	public @ResponseBody void deleteHabilitaServico(
			@RequestBody int id) throws Exception {

		try {

			habilitaServicoDAOImpl.deleteHabilitaServico(id);
		} catch (Exception e) {
			throw e;
		}
	}
}