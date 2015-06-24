package pt.gnr.gestaoescalas.dao;

import java.sql.Date;
import java.util.List;

import pt.gnr.gestaoescalas.model.Servico;

public interface ServicoDAO {
	public List<Servico> getServicos () throws Exception;
	public List<Servico> getServicosByDate (Date data) throws Exception;
	public Servico getServico (int id) throws Exception;
	public int addServico (Servico servico) throws Exception;
	public int deleteServico (int id) throws Exception;
	public int updateServico (Servico servico) throws Exception;
}
