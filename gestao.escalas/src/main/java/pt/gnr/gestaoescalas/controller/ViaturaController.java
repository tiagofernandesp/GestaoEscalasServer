package pt.gnr.gestaoescalas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.dao.ViaturaDAOImpl;
import pt.gnr.gestaoescalas.model.Viatura;

@Controller
@RequestMapping("/viatura")
public class ViaturaController {

	private ViaturaDAOImpl viaturaDAOImpl = new ViaturaDAOImpl();
	/**
	 * 
	 * Devolve todos objetos da tabela
	 * 
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Viatura> getViaturas()
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
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody Viatura getViatura(
			@PathVariable("id") int id) throws Exception {

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
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void addViatura(
			@RequestBody Viatura viatura) throws Exception {
		try {
			viaturaDAOImpl.addViatura(viatura);
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
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody void updateViatura(
			@RequestBody Viatura viatura) throws Exception {
		
		try {
			viaturaDAOImpl.updateViatura(viatura);
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
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void deleteViatura(
			@RequestBody int id) throws Exception {

		try {
			viaturaDAOImpl.deleteViatura(id);
		} catch (Exception e) {
			throw e;
		}

	}
}