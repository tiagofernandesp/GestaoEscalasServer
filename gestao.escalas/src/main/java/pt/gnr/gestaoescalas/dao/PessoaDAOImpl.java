package pt.gnr.gestaoescalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pt.gnr.gestaoescalas.model.DataService;
import pt.gnr.gestaoescalas.model.Pessoa;

public class PessoaDAOImpl implements PessoaDAO{

	private CategoriaDAOImpl categoriaDAOImpl = new CategoriaDAOImpl();
	public PessoaDAOImpl ()
	{

	}

	public List<Pessoa> getPessoas() throws Exception {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.Pessoa;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				pessoas.add(new Pessoa(
						resultSet.getInt("Id"),
						resultSet.getString("PNome"),
						resultSet.getString("UNome"),
						resultSet.getString("Apelido"),
						resultSet.getString("Telemovel"),
						resultSet.getString("Telefone"),
						resultSet.getString("CP"),
						resultSet.getString("Rua"),
						resultSet.getInt("Porta"),
						resultSet.getString("Cidade"),
						resultSet.getString("NumeroGNR"),
						resultSet.getString("NumeroPosto"),
						resultSet.getBoolean("Ativo"),
						resultSet.getDate("DataIngresso"),
						categoriaDAOImpl.getCategoria(resultSet.getInt("Categoria_Id"))
						));

			}
			return pessoas;
		} catch (Exception e) {
			throw e;
		} finally {
			if(resultSet!=null)
				resultSet.close();
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connect!=null)
				dataService.close(connect);
		}
	}

	public Pessoa getPessoa(int id) throws Exception {
		Pessoa Pessoa = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.Pessoa where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Pessoa = new Pessoa(
						resultSet.getInt("Id"),
						resultSet.getString("PNome"),
						resultSet.getString("UNome"),
						resultSet.getString("Apelido"),
						resultSet.getString("Telemovel"),
						resultSet.getString("Telefone"),
						resultSet.getString("CP"),
						resultSet.getString("Rua"),
						resultSet.getInt("Porta"),
						resultSet.getString("Cidade"),
						resultSet.getString("NumeroGNR"),
						resultSet.getString("NumeroPosto"),
						resultSet.getBoolean("Ativo"),
						resultSet.getDate("DataIngresso"),
						categoriaDAOImpl.getCategoria(resultSet.getInt("Categoria_Id"))
						);
			}
			return Pessoa;
		} catch (Exception e) {
			throw e;
		} finally {
			if(resultSet!=null)
				resultSet.close();
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connect!=null)
				dataService.close(connect);
		}
	}

	public void addPessoa(Pessoa pessoa) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.Pessoa (PNome, UNome, Apelido, Telemovel, Telefone, CP, Rua, Porta, Cidade, NumeroGNR, NumeroPosto, Ativo, DataIngresso, Categoria_Id) values ( ?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?,?)");
			preparedStatement.setString(1, pessoa.getpNome());
			preparedStatement.setString(2, pessoa.getuNome());
			preparedStatement.setString(3, pessoa.getApelido());
			preparedStatement.setString(4, pessoa.getTelemovel());
			preparedStatement.setString(5, pessoa.getTelefone());
			preparedStatement.setString(6, pessoa.getcP());
			preparedStatement.setString(7, pessoa.getRua());
			preparedStatement.setInt(8, pessoa.getPorta());
			preparedStatement.setString(9, pessoa.getCidade());
			preparedStatement.setString(10, pessoa.getNumeroGNR());
			preparedStatement.setString(11, pessoa.getNumeroPosto());
			preparedStatement.setBoolean(12, pessoa.getAtivo());
			preparedStatement.setDate(13, pessoa.getDataIngresso());
			preparedStatement.setInt(14, pessoa.getCategoria().getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connect!=null)
				dataService.close(connect);
		}

	}

	public void deletePessoa(int id) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.Pessoa where Id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connect!=null)
				dataService.close(connect);
		}

	}

	public void updatePessoa(Pessoa pessoa) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.Pessoa set PNome = ?, UNome = ?, Apelido = ?, Telemovel = ?, Telefone = ?, CP = ?, Rua = ?, Porta = ?, Cidade = ?, NumeroGNR = ?, NumeroPosto = ?, Ativo = ?, DataIngresso = ?, Categoria_Id = ? where Id = ?");
			preparedStatement.setString(1, pessoa.getpNome());
			preparedStatement.setString(2, pessoa.getuNome());
			preparedStatement.setString(3, pessoa.getApelido());
			preparedStatement.setString(4, pessoa.getTelemovel());
			preparedStatement.setString(5, pessoa.getTelefone());
			preparedStatement.setString(6, pessoa.getcP());
			preparedStatement.setString(7, pessoa.getRua());
			preparedStatement.setInt(8, pessoa.getPorta());
			preparedStatement.setString(9, pessoa.getCidade());
			preparedStatement.setString(10, pessoa.getNumeroGNR());
			preparedStatement.setString(11, pessoa.getNumeroPosto());
			preparedStatement.setBoolean(12, pessoa.getAtivo());
			preparedStatement.setDate(13, pessoa.getDataIngresso());
			preparedStatement.setInt(14, pessoa.getCategoria().getId());
			preparedStatement.setInt(15, pessoa.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connect!=null)
				dataService.close(connect);
		}

	}

}
