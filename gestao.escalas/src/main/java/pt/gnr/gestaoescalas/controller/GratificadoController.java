package pt.gnr.gestaoescalas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import pt.gnr.gestaoescalas.dao.GratificadoDAOImpl;
import pt.gnr.gestaoescalas.model.Gratificado;

@Controller
@RequestMapping("/gratificado")
public class GratificadoController {
	
	private GratificadoDAOImpl gratificadoDAOImpl = new GratificadoDAOImpl();
	/**
	 * 
	 * Devolve todos objetos da tabela
	 * 
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Gratificado> getGratificados()
			throws Exception {
		try {
			List<Gratificado> gratificados = gratificadoDAOImpl.getGratificados();
			return gratificados;
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
	 * @return gratificado retorna um objecto
	 * 
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody Gratificado getGratificado(
			@PathVariable("id") int id) throws Exception {
		try {
			Gratificado gratificado = gratificadoDAOImpl.getGratificado(id);
			return gratificado;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * 
	 * Adiciona novo objecto
	 * 
	 * @param gratificado
	 *            objecto para adicionar à BD
	 * 
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void addGratificado(
			@RequestBody Gratificado gratificado) throws Exception {
		try {
			gratificadoDAOImpl.addGratificado(gratificado);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * Modifica objecto
	 * 
	 * @param gratificado
	 *            objecto para modificar na BD
	 * 
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody void updateGratificado(
			@RequestBody Gratificado gratificado) throws Exception {
		try {
			gratificadoDAOImpl.updateGratificado(gratificado);
		} catch (Exception e) {
			throw e;
		}		
	}

	/**
	 * 
	 * Apaga objecto
	 * 
	 * @param gratificado
	 *            id objecto para apagar na BD
	 * 
	 * 
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void deleteGratificado(
			@RequestBody int id) throws Exception {
		try {
			gratificadoDAOImpl.deleteGratificado(id);
		} catch (Exception e) {
			throw e;
		}
	}
}