package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.ServicoPessoa;

public interface ServicoPessoaDAO {
	public List<ServicoPessoa> getServicoPessoas () throws Exception;
	public ServicoPessoa getServicoPessoa (int id) throws Exception;
	public int addServicoPessoa (ServicoPessoa servicoPessoa) throws Exception;
	public int deleteServicoPessoa (int id) throws Exception;
	public int updateServicoPessoa (ServicoPessoa servicoPessoa) throws Exception;
}
