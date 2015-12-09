package pt.gnr.gestaoescalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pt.gnr.gestaoescalas.model.DataService;
import pt.gnr.gestaoescalas.model.Autenticacao;

public class AutenticacaoDAOImpl implements AutenticacaoDAO {


	public Autenticacao getAutenticacao(int userId) throws Exception {
		Autenticacao autenticacao = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.autenticacao where Utilizador_Id= ?");
			preparedStatement.setInt(1, userId);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				autenticacao = new Autenticacao(
						resultSet.getInt("Id"),
						resultSet.getString("Rule"),
						resultSet.getDate("Data"),
						resultSet.getInt("Utilizador_Id"));
			}
			return autenticacao;
		} catch (Exception e) {
			throw e;
		} finally {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connect != null)
				dataService.close(connect);
		}
	}
	
	public Autenticacao getAutenticacaoByRule(int userId, String rule) throws Exception {
		Autenticacao autenticacao = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.autenticacao where Utilizador_Id= ? and Rule= ?");
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, rule);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				autenticacao = new Autenticacao(
						resultSet.getInt("Id"),
						resultSet.getString("Rule"),
						resultSet.getDate("Data"),
						resultSet.getInt("Utilizador_Id"));
			}
			return autenticacao;
		} catch (Exception e) {
			throw e;
		} finally {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connect != null)
				dataService.close(connect);
		}
	}
	
	public int addAutenticacao(Autenticacao autenticacao) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.autenticacao (Rule,Data,Utilizador_Id) values ( ?, ?,?)");
			preparedStatement.setString(1, autenticacao.getRule());
			preparedStatement.setDate(2, autenticacao.getData());
			preparedStatement.setInt(3, autenticacao.getUtilizador_Id());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (connect != null)
				dataService.close(connect);
		}

	}

	public int deleteAutenticacao(int id , String rule) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.autenticacao where Id = ? and Rule= ?");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, rule);
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (connect != null)
				dataService.close(connect);
		}

	}

}
