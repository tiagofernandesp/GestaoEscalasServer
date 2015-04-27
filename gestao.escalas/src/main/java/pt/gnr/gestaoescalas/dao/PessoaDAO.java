package pt.gnr.gestaoescalas.dao;

import java.util.List;

import pt.gnr.gestaoescalas.model.Pessoa;

public interface PessoaDAO {
	public List<Pessoa> getPessoas () throws Exception;
	public Pessoa getPessoa (int id) throws Exception;
	public void addPessoa (Pessoa pessoa) throws Exception;
	public void deletePessoa (int id) throws Exception;
	public void updatePessoa (Pessoa pessoa) throws Exception;
}
