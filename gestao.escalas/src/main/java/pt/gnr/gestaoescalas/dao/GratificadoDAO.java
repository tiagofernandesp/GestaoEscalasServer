package pt.gnr.gestaoescalas.dao;

import java.sql.Date;
import java.util.List;

import pt.gnr.gestaoescalas.model.Gratificado;

public interface GratificadoDAO {
	public List<Gratificado> getGratificados () throws Exception;
	public Gratificado getGratificado (int id) throws Exception;
	public List<Gratificado> getGratificadosByDate (Date data) throws Exception;
	public int addGratificado (Gratificado gratificado) throws Exception;
	public int deleteGratificado (int id) throws Exception;
	public int updateGratificado (Gratificado gratificado) throws Exception;
}
