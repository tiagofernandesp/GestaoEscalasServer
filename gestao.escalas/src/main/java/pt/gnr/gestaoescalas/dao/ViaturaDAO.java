package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.Viatura;

public interface ViaturaDAO {
	public List<Viatura> getViaturas () throws Exception;
	public Viatura getViatura (int id) throws Exception;
	public void addViatura (Viatura viatura) throws Exception;
	public void deleteViatura (int id) throws Exception;
	public void updateViatura (Viatura viatura) throws Exception;
}
