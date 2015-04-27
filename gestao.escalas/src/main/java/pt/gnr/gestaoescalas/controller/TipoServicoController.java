package pt.gnr.gestaoescalas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.dao.TipoServicoDAOImpl;
import pt.gnr.gestaoescalas.model.TipoServico;

@Controller
@RequestMapping("/tiposervico")
public class TipoServicoController {

	private TipoServicoDAOImpl tipoServicoDAOImpl = new TipoServicoDAOImpl();
	/**
	 * 
	 * Devolve todos objetos da tabela
	 * 
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<TipoServico> getTipoServicos()
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
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody TipoServico getTipoServico(
			@PathVariable("id") int id) throws Exception {

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
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void addTipoServico(
			@RequestBody TipoServico tipoServico) throws Exception {

		try {
			tipoServicoDAOImpl.addTipoServico(tipoServico);
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
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody void updateTipoServico(
			@RequestBody TipoServico tipoServico) throws Exception {
		
		try {
			tipoServicoDAOImpl.updateTipoServico(tipoServico);
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
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void deleteTipoServico(
			@RequestBody int id) throws Exception {

		try {
			tipoServicoDAOImpl.deleteTipoServico(id);
		} catch (Exception e) {
			throw e;
		}
	}
}