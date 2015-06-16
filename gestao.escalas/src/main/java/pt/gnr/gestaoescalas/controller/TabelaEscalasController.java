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

import pt.gnr.gestaoescalas.dao.ListaPrioridadesDAOImpl;
import pt.gnr.gestaoescalas.dao.PessoaDAOImpl;
import pt.gnr.gestaoescalas.dao.ServicoPessoaDAOImpl;
import pt.gnr.gestaoescalas.model.LinhaListaPrioridade;
import pt.gnr.gestaoescalas.model.Pessoa;
import pt.gnr.gestaoescalas.model.PessoaEscala;
import pt.gnr.gestaoescalas.model.ServicoPessoa;

@Controller
@RequestMapping("/tabelaescalas")
public class TabelaEscalasController {

	private ServicoPessoaDAOImpl servicoPessoaDAOImpl = new ServicoPessoaDAOImpl();
	private PessoaDAOImpl pessoaDAOImpl = new PessoaDAOImpl();
	private ListaPrioridadesDAOImpl listaPrioridadesDAOImpl = new ListaPrioridadesDAOImpl();

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
					pessoaEscala.setEscalasById(null, j);
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
	}

