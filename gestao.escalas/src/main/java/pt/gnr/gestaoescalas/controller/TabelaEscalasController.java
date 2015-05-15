package pt.gnr.gestaoescalas.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.dao.PessoaDAOImpl;
import pt.gnr.gestaoescalas.dao.ServicoPessoaDAOImpl;
import pt.gnr.gestaoescalas.model.Pessoa;
import pt.gnr.gestaoescalas.model.PessoaEscala;
import pt.gnr.gestaoescalas.model.ServicoPessoa;

@Controller
@RequestMapping("/tabelaescalas")
public class TabelaEscalasController {

	private ServicoPessoaDAOImpl servicoPessoaDAOImpl = new ServicoPessoaDAOImpl();
	private PessoaDAOImpl pessoaDAOImpl = new PessoaDAOImpl();

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
			List<PessoaEscala> pessoasEscalas = null;
			List<Pessoa> pessoasAtivasList = pessoaDAOImpl.getPessoasAtivas();
			String dt = date.toString();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(dt));

			for (int i = 0; i < pessoasAtivasList.size(); i++) {
				PessoaEscala pessoaEscala = new PessoaEscala();

				List<ServicoPessoa> servicoPessoas = servicoPessoaDAOImpl.getServicoPessoasByDataPessoa((Date)sdf.parse(sdf.format(c.getTime())), 1);
				c.add(Calendar.DATE, 1);
				pessoaEscala.setDay1(servicoPessoas.get(0));
				pessoaEscala.setPessoa(pessoasAtivasList.get(0));
				pessoasEscalas.add(pessoaEscala);
			}

			return pessoasEscalas;
		} catch (Exception e) {
			throw e;
		}
	}

	}

