package pt.gnr.gestaoescalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pt.gnr.gestaoescalas.model.DataService;
import pt.gnr.gestaoescalas.model.TipoServico;

public class TipoServicoDAOImpl implements TipoServicoDAO {

	public List<TipoServico> getTipoServicos() throws Exception {
		List<TipoServico> tipoServicos = new ArrayList<TipoServico>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.tiposervico;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tipoServicos.add(new TipoServico(resultSet.getInt("Id"),
						resultSet.getString("Nome"), resultSet
								.getString("Prefixo"), resultSet
								.getInt("HoraInicio"), resultSet
								.getInt("HoraFim"), resultSet
								.getBoolean("ServicoMinimo")));
			}
			return tipoServicos;
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

	public TipoServico getTipoServico(int id) throws Exception {
		TipoServico tipoServico = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.tiposervico where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tipoServico = new TipoServico(resultSet.getInt("Id"),
						resultSet.getString("Nome"),
						resultSet.getString("Prefixo"),
						resultSet.getInt("HoraInicio"),
						resultSet.getInt("HoraFim"),
						resultSet.getBoolean("ServicoMinimo"));
			}
			return tipoServico;
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

	public void addTipoServico(TipoServico tipoServico) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.tiposervico (Nome,Prefixo,HoraInicio,HoraFim,ServicoMinimo) values ( ?, ?,?, ?,?)");
			preparedStatement.setString(1, tipoServico.getNome());
			preparedStatement.setString(2, tipoServico.getPrefixo());
			preparedStatement.setInt(3, tipoServico.getHoraInicio());
			preparedStatement.setInt(4, tipoServico.getHoraFim());
			preparedStatement.setBoolean(5, tipoServico.getServicoMinimo());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (connect != null)
				dataService.close(connect);
		}

	}

	public void deleteTipoServico(int id) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.tiposervico where Id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (connect != null)
				dataService.close(connect);
		}

	}

	public void updateTipoServico(TipoServico tipoServico) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("update gestaoescalas.tiposervico set Nome = ?, Prefixo = ?, HoraInicio = ?, HoraFim = ?, ServicoMinimo = ? where Id = ?");
			preparedStatement.setString(1, tipoServico.getNome());
			preparedStatement.setString(2, tipoServico.getPrefixo());
			preparedStatement.setInt(3, tipoServico.getHoraInicio());
			preparedStatement.setInt(4, tipoServico.getHoraFim());
			preparedStatement.setBoolean(5, tipoServico.getServicoMinimo());
			preparedStatement.setInt(6, tipoServico.getId());
			preparedStatement.executeUpdate();
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
