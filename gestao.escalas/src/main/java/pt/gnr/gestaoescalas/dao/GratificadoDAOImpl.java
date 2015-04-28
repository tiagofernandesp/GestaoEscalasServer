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
						resultSet.getTime("HoraInicio"),
						resultSet.getTime("HoraFim"),
						resultSet.getString("Observacao"),
						resultSet.getString("Local"),
						tipoGratificadoDAOImpl.getTipoGratificado(resultSet.getInt("TipoGratificado_Id")),
						viaturaDAOImpl.getViatura(resultSet.getInt("Viatura_Id")),
						resultSet.getString("FRadio"),
						resultSet.getDate("DataInicio"),
						resultSet.getDate("DataFim")));
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
						resultSet.getTime("HoraInicio"),
						resultSet.getTime("HoraFim"),
						resultSet.getString("Observacao"),
						resultSet.getString("Local"),
						tipoGratificadoDAOImpl.getTipoGratificado(resultSet.getInt("TipoGratificado_Id")),
						viaturaDAOImpl.getViatura(resultSet.getInt("Viatura_Id")),
						resultSet.getString("FRadio"),
						resultSet.getDate("DataInicio"),
						resultSet.getDate("DataFim"));
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

	public int addGratificado(Gratificado gratificado) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.gratificado (HoraInicio,HoraFim,Observacao,Local,TipoGratificado_Id,Viatura_Id,FRadio,DataInicio,DataFim) values ( ?, ?,?, ?,?, ?,?,?,?)");
			preparedStatement.setTime(1, gratificado.getHoraInicio());
			preparedStatement.setTime(2, gratificado.getHoraFim());
			preparedStatement.setString(3, gratificado.getObservacao());
			preparedStatement.setString(4, gratificado.getLocal());
			preparedStatement.setInt(5, gratificado.getTipoGratificado().getId());
			preparedStatement.setInt(6, gratificado.getViatua().getId());
			preparedStatement.setString(7, gratificado.getfRadio());
			preparedStatement.setDate(8, gratificado.getDataInicio());
			preparedStatement.setDate(9, gratificado.getDataFim());
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

	public int deleteGratificado(int id) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.gratificado where Id = ?");
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

	public int updateGratificado(Gratificado gratificado) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.gratificado set HoraInicio = ?, HoraFim = ?, Observacao = ?, Local = ?, TipoGratificado_Id = ?, Viatura_Id = ?, FRadio = ?, DataInicio =?, DataFim=? where Id = ?");
			preparedStatement.setTime(1, gratificado.getHoraInicio());
			preparedStatement.setTime(2, gratificado.getHoraFim());
			preparedStatement.setString(3, gratificado.getObservacao());
			preparedStatement.setString(4, gratificado.getLocal());
			preparedStatement.setInt(5, gratificado.getTipoGratificado().getId());
			preparedStatement.setInt(6, gratificado.getViatua().getId());
			preparedStatement.setString(7, gratificado.getfRadio());
			preparedStatement.setDate(8, gratificado.getDataInicio());
			preparedStatement.setDate(9, gratificado.getDataFim());
			preparedStatement.setInt(10, gratificado.getId());
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
