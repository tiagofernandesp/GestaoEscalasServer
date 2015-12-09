package pt.gnr.gestaoescalas.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.service.ServicoPessoaService;
import pt.gnr.gestaoescalas.model.ServicoPessoa;

@Controller
@RequestMapping("/servicopessoa")
public class ServicoPessoaController {

	private ServicoPessoaService servicoPessoaService = new ServicoPessoaService();

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
			List<ServicoPessoa> servicoPessoas = servicoPessoaService.getServicoPessoas();
			return servicoPessoas;
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/date/{date}")
	public @ResponseBody List<ServicoPessoa> getServicoPessoasByDate(@PathVariable("date") Date dat)
			throws Exception {
		try {
			List<ServicoPessoa> servicoPessoas = servicoPessoaService.getServicoPessoasByDate(dat);
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
			ServicoPessoa servicoPessoa = servicoPessoaService.getServicoPessoa(id);
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
	public @ResponseBody int addServicoPessoa(
			@RequestBody ServicoPessoa servicoPessoa) throws Exception {

		try {
			return servicoPessoaService.addServicoPessoa(servicoPessoa);
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
	public @ResponseBody int updateServicoPessoa(
			@RequestBody ServicoPessoa servicoPessoa) throws Exception {

		try {
			return servicoPessoaService.updateServicoPessoa(servicoPessoa);
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
	public @ResponseBody int deleteServicoPessoa(
			@RequestBody int id) throws Exception {

		try {
			return servicoPessoaService.deleteServicoPessoa(id);
		} catch (Exception e) {
			throw e;
		}

	}
}