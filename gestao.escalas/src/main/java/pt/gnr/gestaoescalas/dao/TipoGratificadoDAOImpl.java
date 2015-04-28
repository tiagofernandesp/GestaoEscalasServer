package pt.gnr.gestaoescalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pt.gnr.gestaoescalas.model.DataService;
import pt.gnr.gestaoescalas.model.TipoGratificado;

public class TipoGratificadoDAOImpl implements TipoGratificadoDAO{

	public List<TipoGratificado> getTipoGratificados() throws Exception {
		List<TipoGratificado> tipoGratificados = new ArrayList<TipoGratificado>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.tipogratificado;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tipoGratificados.add(new TipoGratificado(
						resultSet.getInt("Id"), resultSet.getString("Nome"),
						resultSet.getString("Prefixo")));
			}
			return tipoGratificados;
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

	public TipoGratificado getTipoGratificado(int id) throws Exception {
		TipoGratificado tipoGratificado = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.tipogratificado where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tipoGratificado = new TipoGratificado(resultSet.getInt("Id"),
						resultSet.getString("Nome"),
						resultSet.getString("Prefixo"));
			}
			return tipoGratificado;
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

	public int addTipoGratificado(TipoGratificado tipoGratificado)
			throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.tipogratificado (Nome,Prefixo) values ( ?, ?)");
			preparedStatement.setString(1, tipoGratificado.getNome());
			preparedStatement.setString(2, tipoGratificado.getPrefixo());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connect!=null)
				dataService.close(connect);
		}

	}

	public int deleteTipoGratificado(int id) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.tipogratificado where Id = ?");
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connect!=null)
				dataService.close(connect);
		}

	}

	public int updateTipoGratificado(TipoGratificado tipoGratificado)
			throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.tipogratificado set Nome = ?, Prefixo = ? where Id = ?");
			preparedStatement.setString(1, tipoGratificado.getNome());
			preparedStatement.setString(2, tipoGratificado.getPrefixo());
			preparedStatement.setInt(3, tipoGratificado.getId());
			return preparedStatement.executeUpdate();
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
