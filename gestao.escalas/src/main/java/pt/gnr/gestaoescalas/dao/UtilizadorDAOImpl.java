package pt.gnr.gestaoescalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pt.gnr.gestaoescalas.model.DataService;
import pt.gnr.gestaoescalas.model.Utilizador;

public class UtilizadorDAOImpl implements UtilizadorDAO {

	public List<Utilizador> getUtilizadores() throws Exception {
		List<Utilizador> utilizadores = new ArrayList<Utilizador>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.utilizador;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				utilizadores.add(new Utilizador(
						resultSet.getInt("Id"),
						resultSet.getString("User"),
						resultSet.getString("Pass"),
						resultSet.getBoolean("Estado"),
						resultSet.getString("Nome")));
			}
			return utilizadores;
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

	public Utilizador getUtilizador(int id) throws Exception {
		Utilizador utilizador = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.utilizador where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				utilizador = new Utilizador(
						resultSet.getInt("Id"),
						resultSet.getString("User"),
						resultSet.getString("Pass"),
						resultSet.getBoolean("Estado"),
						resultSet.getString("Nome"));
			}
			return utilizador;
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
	
	public Utilizador getUtilizadorByUserPass (String user, String pass) throws Exception{
		Utilizador utilizador = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.utilizador where User= ? and Pass= ?");
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				utilizador = new Utilizador(
						resultSet.getInt("Id"),
						resultSet.getString("User"),
						resultSet.getString("Pass"),
						resultSet.getBoolean("Estado"),
						resultSet.getString("Nome"));
			}
			return utilizador;
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
	
	public Utilizador utilizadorExits (String user) throws Exception{
		Utilizador utilizador = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.utilizador where User= ?");
			preparedStatement.setString(1, user);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				utilizador = new Utilizador(
						resultSet.getInt("Id"),
						resultSet.getString("User"),
						resultSet.getString("Pass"),
						resultSet.getBoolean("Estado"),
						resultSet.getString("Nome"));
			}
			return utilizador;
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
	
	public int addUtilizador(Utilizador utilizador) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.utilizador (User,Pass,Estado,Nome) values ( ?, ?,?,?)");
			preparedStatement.setString(1, utilizador.getUser());
			preparedStatement.setString(2, utilizador.getPass());
			preparedStatement.setBoolean(3, utilizador.getEstado());
			preparedStatement.setString(4, utilizador.getNome());
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

	public int deleteUtilizador(int id) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.utilizador where Id = ?");
			preparedStatement.setInt(1, id);
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

	public int updateUtilizador(Utilizador utilizador) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("update gestaoescalas.utilizador set User = ?, Pass = ?, Estado = ?, Nome = ? where Id = ?");
			preparedStatement.setString(1, utilizador.getUser());
			preparedStatement.setString(2, utilizador.getPass());
			preparedStatement.setBoolean(3, utilizador.getEstado());
			preparedStatement.setString(4, utilizador.getNome());
			preparedStatement.setInt(5, utilizador.getId());
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
