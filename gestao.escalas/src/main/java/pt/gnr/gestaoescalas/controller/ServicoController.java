package pt.gnr.gestaoescalas.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.service.ServicoService;
import pt.gnr.gestaoescalas.model.Servico;

@Controller
@RequestMapping("/servico")
public class ServicoController {

	private ServicoService servicoService = new ServicoService();
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Servico> getServicos()
			throws Exception {
		try {
			List<Servico> servicos = servicoService.getServicos();
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

	@RequestMapping(method = RequestMethod.GET, value = "/date/{data}")
	public @ResponseBody List<Servico> getServicosByDate(@PathVariable("data") Date data)
			throws Exception {
		try {
			List<Servico> servicos = servicoService.getServicosByDate(data);
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
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody Servico getServico(
			@PathVariable("id") int id) throws Exception {

		try {
			Servico servico = servicoService.getServico(id);
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
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addServico(
			@RequestBody Servico servico) throws Exception {

		try {
			return servicoService.addServico(servico);
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
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updateServico(
			@RequestBody Servico servico) throws Exception {
		try {
			return servicoService.updateServico(servico);
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
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deleteServico(
			@RequestBody Servico s) throws Exception {

		try {
			return servicoService.deleteServico(s);
		} catch (Exception e) {
			throw e;
		}
	}
}