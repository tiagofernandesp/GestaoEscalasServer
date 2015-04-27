package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.Gratificado;

public interface GratificadoDAO {
	public List<Gratificado> getGratificados () throws Exception;
	public Gratificado getGratificado (int id) throws Exception;
	public void addGratificado (Gratificado gratificado) throws Exception;
	public void deleteGratificado (int id) throws Exception;
	public void updateGratificado (Gratificado gratificado) throws Exception;
}
