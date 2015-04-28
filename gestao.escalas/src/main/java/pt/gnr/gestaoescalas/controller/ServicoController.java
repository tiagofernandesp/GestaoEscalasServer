package pt.gnr.gestaoescalas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.dao.ServicoDAOImpl;
import pt.gnr.gestaoescalas.model.Servico;

@Controller
@RequestMapping("/servico")
public class ServicoController {

	private ServicoDAOImpl servicoDAOImpl = new ServicoDAOImpl();
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
			List<Servico> servicos = servicoDAOImpl.getServicos();
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
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addServico(
			@RequestBody Servico servico) throws Exception {

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
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updateServico(
			@RequestBody Servico servico) throws Exception {
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
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deleteServico(
			@RequestBody int id) throws Exception {

		try {
			return servicoDAOImpl.deleteServico(id);
		} catch (Exception e) {
			throw e;
		}
	}
}