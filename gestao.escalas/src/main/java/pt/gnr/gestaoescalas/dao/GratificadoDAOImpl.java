package pt.gnr.gestaoescalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pt.gnr.gestaoescalas.model.DataService;
import pt.gnr.gestaoescalas.model.Gratificado;


public class GratificadoDAOImpl implements GratificadoDAO{

	private ViaturaDAOImpl viaturaDAOImpl = new ViaturaDAOImpl();
	private TipoGratificadoDAOImpl tipoGratificadoDAOImpl = new TipoGratificadoDAOImpl();

	public GratificadoDAOImpl ()
	{

	}
	public List<Gratificado> getGratificados() throws Exception {
		List<Gratificado> gratificados = new ArrayList<Gratificado>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.gratificado;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				gratificados.add(new Gratificado(
						resultSet.getInt("Id"),
						resultSet.getDate("HoraInicio"),
						resultSet.getDate("HoraFim"),
						resultSet.getString("Observacao"),
						resultSet.getString("Local"),
						tipoGratificadoDAOImpl.getTipoGratificado(resultSet.getInt("TipoGratificado_Id")),
						viaturaDAOImpl.getViatura(resultSet.getInt("Viatura_Id")),
						resultSet.getString("FRadio")));
			}
			return gratificados;
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

	public Gratificado getGratificado(int id) throws Exception {
		Gratificado gratificado = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.gratificado where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				gratificado = new Gratificado(
						resultSet.getInt("Id"),
						resultSet.getDate("HoraInicio"),
						resultSet.getDate("HoraFim"),
						resultSet.getString("Observacao"),
						resultSet.getString("Local"),
						tipoGratificadoDAOImpl.getTipoGratificado(resultSet.getInt("TipoGratificado_Id")),
						viaturaDAOImpl.getViatura(resultSet.getInt("Viatura_Id")),
						resultSet.getString("FRadio"));
			}
			return gratificado;
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

	public void addGratificado(Gratificado gratificado) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.gratificado (HoraInicio,HoraFim,Observacao,Local,TipoGratificado_Id,Viatura_Id,FRadio) values ( ?, ?,?, ?,?, ?,?)");
			preparedStatement.setDate(1, gratificado.getHoraInicio());
			preparedStatement.setDate(2, gratificado.getHoraFim());
			preparedStatement.setString(3, gratificado.getObservacao());
			preparedStatement.setString(4, gratificado.getLocal());
			preparedStatement.setInt(5, gratificado.getTipoGratificado().getId());
			preparedStatement.setInt(6, gratificado.getViatua().getId());
			preparedStatement.setString(7, gratificado.getFRadio());
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

	public void deleteGratificado(int id) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.gratificado where Id = ?");
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

	public void updateGratificado(Gratificado gratificado) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.gratificado set HoraInicio = ?, HoraFim = ?, Observacao = ?, Local = ?, TipoGratificado_Id = ?, Viatura_Id = ?, FRadio = ? where Id = ?");
			preparedStatement.setDate(1, gratificado.getHoraInicio());
			preparedStatement.setDate(2, gratificado.getHoraFim());
			preparedStatement.setString(3, gratificado.getObservacao());
			preparedStatement.setString(4, gratificado.getLocal());
			preparedStatement.setInt(5, gratificado.getTipoGratificado().getId());
			preparedStatement.setInt(6, gratificado.getViatua().getId());
			preparedStatement.setString(7, gratificado.getFRadio());
			preparedStatement.setInt(8, gratificado.getId());
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
