package pt.gnr.gestaoescalas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.service.HabilitaServicoService;
import pt.gnr.gestaoescalas.model.HabilitaServico;
import pt.gnr.gestaoescalas.model.TipoServico;

@Controller
@RequestMapping("/habilitaservico")
public class HabilitaServicoController {

	private HabilitaServicoService habilitaServicoService = new HabilitaServicoService();
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
			List<HabilitaServico> habilitaServicos = habilitaServicoService.getHabilitaServicos();
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
			return habilitaServicoService.getHabilitaServicosByPerson(id);

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
			
			return habilitaServicoService.updateHabilitaServicos(id, tipoServicos);
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
			return habilitaServicoService.getHabilitaServico(id);

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

			return habilitaServicoService.addHabilitaServico(habilitaServico);
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

			return habilitaServicoService.updateHabilitaServico(habilitaServico);
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

			return habilitaServicoService.deleteHabilitaServico(id);
		} catch (Exception e) {
			throw e;
		}
	}
}