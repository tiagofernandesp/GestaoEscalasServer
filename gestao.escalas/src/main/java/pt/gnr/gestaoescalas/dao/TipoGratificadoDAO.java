package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.TipoGratificado;

public interface TipoGratificadoDAO {
	public List<TipoGratificado> getTipoGratificados () throws Exception;
	public TipoGratificado getTipoGratificado (int id) throws Exception;
	public void addTipoGratificado (TipoGratificado tipoGratificado) throws Exception;
	public void deleteTipoGratificado (int id) throws Exception;
	public void updateTipoGratificado (TipoGratificado tipoGratificado) throws Exception;
}
