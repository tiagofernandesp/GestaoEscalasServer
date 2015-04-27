package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.TipoServico;

public interface TipoServicoDAO {
	public List<TipoServico> getTipoServicos () throws Exception;
	public TipoServico getTipoServico (int id) throws Exception;
	public void addTipoServico (TipoServico tipoServico) throws Exception;
	public void deleteTipoServico (int id) throws Exception;
	public void updateTipoServico (TipoServico tipoServico) throws Exception;
}
