package pt.gnr.gestaoescalas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.service.TipoGratificadoService;
import pt.gnr.gestaoescalas.model.TipoGratificado;

@Controller
@RequestMapping("/tipogratificado")
public class TipoGratificadoController {

	private TipoGratificadoService tipoGratificadoService = new TipoGratificadoService();
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<TipoGratificado> getTipoGratificados()
			throws Exception {
		try {
			List<TipoGratificado> tipoGratificados = tipoGratificadoService.getTipoGratificados();
			return tipoGratificados;
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
	 * @return tipoGratificado retorna um objecto
	 *
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody TipoGratificado getTipoGratificado(
			@PathVariable("id") int id) throws Exception {

		try {
			TipoGratificado tipoGratificado = tipoGratificadoService.getTipoGratificado(id);
			return tipoGratificado;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 *
	 * Adiciona novo objecto
	 *
	 * @param tipoGratificado
	 *            objecto para adicionar à BD
	 *
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addTipoGratificado(
			@RequestBody TipoGratificado tipoGratificado) throws Exception {

		try {
			return tipoGratificadoService.addTipoGratificado(tipoGratificado);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Modifica objecto
	 *
	 * @param tipoGratificado
	 *            objecto para modificar na BD
	 *
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updateTipoGratificado(
			@RequestBody TipoGratificado tipoGratificado) throws Exception {

		try {
			return tipoGratificadoService.updateTipoGratificado(tipoGratificado);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 *
	 * Apaga objecto
	 *
	 * @param tipoGratificado
	 *            objecto para apagar na BD
	 *
	 *
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deleteTipoGratificado(
			@RequestBody int id) throws Exception {

		try {
			return tipoGratificadoService.deleteTipoGratificado(id);
		} catch (Exception e) {
			throw e;
		}
	}
}