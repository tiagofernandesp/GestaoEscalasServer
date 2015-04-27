package pt.gnr.gestaoescalas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import pt.gnr.gestaoescalas.dao.ServicoPessoaDAOImpl;
import pt.gnr.gestaoescalas.model.ServicoPessoa;

@Controller
@RequestMapping("/servicopessoa")
public class ServicoPessoaController {

	private ServicoPessoaDAOImpl servicoPessoaDAOImpl = new ServicoPessoaDAOImpl();
	
	/**
	 * 
	 * Devolve todos objetos da tabela
	 * 
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<ServicoPessoa> getServicoPessoas()
			throws Exception {
		try {
			List<ServicoPessoa> servicoPessoas = servicoPessoaDAOImpl.getServicoPessoas();
			return servicoPessoas;
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
	 * @return servicoPessoa retorna um objecto
	 * 
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody ServicoPessoa getServicoPessoa(
			@PathVariable("id") int id) throws Exception {
		try {
			ServicoPessoa servicoPessoa = servicoPessoaDAOImpl.getServicoPessoa(id);
			return servicoPessoa;
		} catch (Exception e) {
			throw e;
		}
		

	}

	/**
	 * 
	 * Adiciona novo objecto
	 * 
	 * @param servicoPessoa
	 *            objecto para adicionar à BD
	 * 
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody void addServicoPessoa(
			@RequestBody ServicoPessoa servicoPessoa) throws Exception {

		try {
			servicoPessoaDAOImpl.addServicoPessoa(servicoPessoa);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * Modifica objecto
	 * 
	 * @param servicoPessoa
	 *            objecto para modificar na BD
	 * 
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody void updateServicoPessoa(
			@RequestBody ServicoPessoa servicoPessoa) throws Exception {
		
		try {
			servicoPessoaDAOImpl.updateServicoPessoa(servicoPessoa);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * Apaga objecto
	 * 
	 * @param servicoPessoa
	 *            objecto para apagar na BD
	 * 
	 * 
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody void deleteServicoPessoa(
			@RequestBody int id) throws Exception {
		
		try {
			servicoPessoaDAOImpl.deleteServicoPessoa(id);
		} catch (Exception e) {
			throw e;
		}
		
	}
}