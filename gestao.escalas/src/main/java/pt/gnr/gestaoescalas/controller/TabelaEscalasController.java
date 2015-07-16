package pt.gnr.gestaoescalas.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.dao.GratificadoPessoaDAOImpl;
import pt.gnr.gestaoescalas.dao.ListaPrioridadesDAOImpl;
import pt.gnr.gestaoescalas.dao.PessoaDAOImpl;
import pt.gnr.gestaoescalas.dao.ServicoPessoaDAOImpl;
import pt.gnr.gestaoescalas.dao.TipoServicoDAOImpl;
import pt.gnr.gestaoescalas.model.GratificadoPessoa;
import pt.gnr.gestaoescalas.model.LinhaListaPrioridade;
import pt.gnr.gestaoescalas.model.Pessoa;
import pt.gnr.gestaoescalas.model.PessoaEscala;
import pt.gnr.gestaoescalas.model.PessoaEscalasGratificado;
import pt.gnr.gestaoescalas.model.ServicoPessoa;
import pt.gnr.gestaoescalas.model.TipoServico;

@Controller
@RequestMapping("/tabelaescalas")
public class TabelaEscalasController {

	private ServicoPessoaDAOImpl servicoPessoaDAOImpl = new ServicoPessoaDAOImpl();
	private GratificadoPessoaDAOImpl gratificadoPessoaDAOImpl = new GratificadoPessoaDAOImpl();
	private PessoaDAOImpl pessoaDAOImpl = new PessoaDAOImpl();
	private ListaPrioridadesDAOImpl listaPrioridadesDAOImpl = new ListaPrioridadesDAOImpl();
	private TipoServicoDAOImpl tipoServicoDAOImpl = new TipoServicoDAOImpl();

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
			ServicoPessoa spNull=new ServicoPessoa();
			List<PessoaEscala> pessoasEscalas = new ArrayList<PessoaEscala>();;
			List<Pessoa> pessoasAtivasList = pessoaDAOImpl.getPessoasAtivas();
			String dt = date.toString();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(dt));
			c.add(Calendar.DATE, 7);
			Date finalDate =  new Date(c.getTimeInMillis());
			List<ServicoPessoa> servicoPessoas = servicoPessoaDAOImpl.getServicoPessoasbetweenDates(date, finalDate);
			for (int i = 0; i < pessoasAtivasList.size(); i++) {
				c.setTime(sdf.parse(dt));
				PessoaEscala pessoaEscala = new PessoaEscala();
				pessoaEscala.setPessoa(pessoasAtivasList.get(i));

				for(int j=0;j < 7;j++)
				{
					Date newDate =  new Date(c.getTimeInMillis());
					pessoaEscala.setEscalasById(spNull, j);
					for(ServicoPessoa sp : servicoPessoas){
				        if(sp.getData().equals(newDate) && sp.getPessoa().getId()==pessoaEscala.getPessoa().getId())
				        {
				        	pessoaEscala.setEscalasById(sp, j);
				        }
				    }
					c.add(Calendar.DATE, 1);
				}
				pessoasEscalas.add(pessoaEscala);
			}

			return pessoasEscalas;
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
			GratificadoPessoa spNull=new GratificadoPessoa();
			List<PessoaEscalasGratificado> PessoasEscalasGratificados = new ArrayList<PessoaEscalasGratificado>();;
			List<Pessoa> pessoasAtivasList = pessoaDAOImpl.getPessoasAtivas();
			String dt = date.toString();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(dt));
			c.add(Calendar.DATE, 7);
			Date finalDate =  new Date(c.getTimeInMillis());
			List<GratificadoPessoa> gratificadosPessoas = gratificadoPessoaDAOImpl.getGratificadoPessoasbetweenDates(date, finalDate);
			for (int i = 0; i < pessoasAtivasList.size(); i++) {
				c.setTime(sdf.parse(dt));
				PessoaEscalasGratificado pessoaEscalaGratificado = new PessoaEscalasGratificado();
				pessoaEscalaGratificado.setPessoa(pessoasAtivasList.get(i));

				for(int j=0;j < 7;j++)
				{
					Date newDate =  new Date(c.getTimeInMillis());
					pessoaEscalaGratificado.setEscalasById(spNull, j);
					for(GratificadoPessoa sp : gratificadosPessoas){
				        if(sp.getData().equals(newDate) && sp.getPessoa().getId()==pessoaEscalaGratificado.getPessoa().getId())
				        {
				        	pessoaEscalaGratificado.setEscalasById(sp, j);
				        }
				    }
					c.add(Calendar.DATE, 1);
				}
				PessoasEscalasGratificados.add(pessoaEscalaGratificado);
			}

			return PessoasEscalasGratificados;
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
			boolean encontrou = false;
			int numeroDias =7;
			List<List<TipoServico>> servicosMinimos = new  ArrayList<List<TipoServico>>();
			List<TipoServico> tipoServicos = new  ArrayList<TipoServico>();
			String dt = date.toString();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(dt));
			tipoServicos=tipoServicoDAOImpl.getTipoServicoMinimos();
			for (int i = 0; i < numeroDias; i++) {
				List<TipoServico> tempTipoServicos = new ArrayList<TipoServico>();
				Date finalDate =  new Date(c.getTimeInMillis());
				List<ServicoPessoa> servicoPessoas = servicoPessoaDAOImpl.getServicoPessoasbetweenDates(finalDate, finalDate);
				for(TipoServico ts : tipoServicos){
					for(ServicoPessoa sp : servicoPessoas){
						if (ts.getId()==sp.getServico().getTipoServico().getId()) {
							encontrou = true;
							break;
						}
					}
					if (encontrou==false) {
						tempTipoServicos.add(ts);
					}
					encontrou=false;
				}
				servicosMinimos.add(tempTipoServicos);
				c.add(Calendar.DATE, 1);
			}
			return servicosMinimos;
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
	public @ResponseBody List<LinhaListaPrioridade> getListaPrioridade(@PathVariable("date") Date date, @PathVariable("id") int id)
			throws Exception {
		try {
			List<LinhaListaPrioridade> listaPrioridade=  listaPrioridadesDAOImpl.getListByIdDate(date, id);
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
	public @ResponseBody List<LinhaListaPrioridade> getListaPrioridadeGratificado(@PathVariable("date") Date date, @PathVariable("id") int id)
			throws Exception {
		try {
			List<LinhaListaPrioridade> listaPrioridade=  listaPrioridadesDAOImpl.getListGratificadoByIdDate(date, id);
			return listaPrioridade;
		} catch (Exception e) {
			throw e;
		}
	}
	}

