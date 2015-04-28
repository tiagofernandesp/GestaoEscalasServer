package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.Viatura;

public interface ViaturaDAO {
	public List<Viatura> getViaturas () throws Exception;
	public Viatura getViatura (int id) throws Exception;
	public int addViatura (Viatura viatura) throws Exception;
	public int deleteViatura (int id) throws Exception;
	public int updateViatura (Viatura viatura) throws Exception;
}
