package pt.gnr.gestaoescalas.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.service.TabelaEscalasService;
import pt.gnr.gestaoescalas.model.LinhaListaPrioridade;
import pt.gnr.gestaoescalas.model.PessoaEscala;
import pt.gnr.gestaoescalas.model.PessoaEscalasGratificado;
import pt.gnr.gestaoescalas.model.TipoServico;

@Controller
@RequestMapping("/tabelaescalas")
public class TabelaEscalasController {

	private TabelaEscalasService tabelaEscalasService = new TabelaEscalasService();

	/**
	 *
	 * Devolve todos objetos da tabela
	 *
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{date}")
	public @ResponseBody List<PessoaEscala> getServicoPessoas(@PathVariable("date") Date date)
			throws Exception {
		try {
			return tabelaEscalasService.getServicoPessoas(date);
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
	@RequestMapping(method = RequestMethod.GET, value = "/gratificado/{date}")
	public @ResponseBody List<PessoaEscalasGratificado> getGratificadoPessoas(@PathVariable("date") Date date)
			throws Exception {
		try {

			return tabelaEscalasService.getGratificadoPessoas(date);
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
	@RequestMapping(method = RequestMethod.GET, value = "/sminimo/{date}")
	public @ResponseBody List<List<TipoServico>> getListaServicosMinimos(@PathVariable("date") Date date)
			throws Exception {
		try {
			return tabelaEscalasService.getListaServicosMinimos(date);
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 *
	 * Devolve Lista de prioridades
	 *
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{date}/{id}")
	public @ResponseBody List<LinhaListaPrioridade> getListByIdDate(@PathVariable("date") Date date, @PathVariable("id") int id)
			throws Exception {
		try {
			List<LinhaListaPrioridade> listaPrioridade=  tabelaEscalasService.getListByIdDate(date, id);
			return listaPrioridade;
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 *
	 * Devolve Lista de prioridades
	 *
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/gratificado/{date}/{id}")
	public @ResponseBody List<LinhaListaPrioridade> getListGratificadoByIdDate(@PathVariable("date") Date date, @PathVariable("id") int id)
			throws Exception {
		try {
			List<LinhaListaPrioridade> listaPrioridade=  tabelaEscalasService.getListGratificadoByIdDate(date, id);
			return listaPrioridade;
		} catch (Exception e) {
			throw e;
		}
	}
	}

