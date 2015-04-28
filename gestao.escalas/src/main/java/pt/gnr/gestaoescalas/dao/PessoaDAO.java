package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.Pessoa;

public interface PessoaDAO {
	public List<Pessoa> getPessoas () throws Exception;
	public Pessoa getPessoa (int id) throws Exception;
	public int addPessoa (Pessoa pessoa) throws Exception;
	public int deletePessoa (int id) throws Exception;
	public int updatePessoa (Pessoa pessoa) throws Exception;
}
