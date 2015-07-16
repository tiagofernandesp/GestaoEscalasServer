package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.TipoServico;

public interface TipoServicoDAO {
	public List<TipoServico> getTipoServicos () throws Exception;
	public TipoServico getTipoServico (int id) throws Exception;
	public List<TipoServico> getTipoServicoMinimos () throws Exception;
	public int addTipoServico (TipoServico tipoServico) throws Exception;
	public int deleteTipoServico (int id) throws Exception;
	public int updateTipoServico (TipoServico tipoServico) throws Exception;
}
