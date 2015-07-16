package pt.gnr.gestaoescalas.dao;

import java.sql.Date;
import java.util.List;

import pt.gnr.gestaoescalas.model.ServicoPessoa;

public interface ServicoPessoaDAO {
	public List<ServicoPessoa> getServicoPessoas () throws Exception;
	public List<ServicoPessoa> getServicoPessoasByDate (Date dat) throws Exception;
	public List<ServicoPessoa> getServicoPessoasByDataPessoa (Date data, int idPessoa) throws Exception;
	public List<ServicoPessoa> getServicoPessoasbetweenDates(Date dataI, Date dataF) throws Exception;
	public ServicoPessoa getServicoPessoa (int id) throws Exception;
	public int addServicoPessoa (ServicoPessoa servicoPessoa) throws Exception;
	public int deleteServicoPessoa (int id) throws Exception;
	public int updateServicoPessoa (ServicoPessoa servicoPessoa) throws Exception;
}
