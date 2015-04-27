package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.Servico;

public interface ServicoDAO {
	public List<Servico> getServicos () throws Exception;
	public Servico getServico (int id) throws Exception;
	public void addServico (Servico servico) throws Exception;
	public void deleteServico (int id) throws Exception;
	public void updateServico (Servico servico) throws Exception;
}
