package pt.gnr.gestaoescalas.dao;

import pt.gnr.gestaoescalas.model.Autenticacao;

public interface AutenticacaoDAO {
	public Autenticacao getAutenticacao (int id) throws Exception;
	public Autenticacao getAutenticacaoByRule(int userId, String rule) throws Exception;
	public int addAutenticacao (Autenticacao utilizador) throws Exception;
	public int deleteAutenticacao (int userId, String rule) throws Exception;
}
