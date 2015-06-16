package pt.gnr.gestaoescalas.dao;

import java.sql.Date;
import java.util.List;

import pt.gnr.gestaoescalas.model.LinhaListaPrioridade;

public interface ListaPrioridadesDAO {
	public List<LinhaListaPrioridade> getListByIdDate (Date data, int id) throws Exception;
}
