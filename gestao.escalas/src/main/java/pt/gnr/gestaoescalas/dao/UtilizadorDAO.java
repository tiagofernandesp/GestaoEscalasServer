package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.Utilizador;

public interface UtilizadorDAO {
	public List<Utilizador> getUtilizadores () throws Exception;
	public Utilizador getUtilizador (int id) throws Exception;
	public Utilizador getUtilizadorByUserPass (String user, String pass) throws Exception;
	public Utilizador utilizadorExits (String user) throws Exception;
	public int addUtilizador (Utilizador utilizador) throws Exception;
	public int deleteUtilizador (int id) throws Exception;
	public int updateUtilizador (Utilizador utilizador) throws Exception;
}
