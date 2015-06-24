package pt.gnr.gestaoescalas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pt.gnr.gestaoescalas.model.DataService;
import pt.gnr.gestaoescalas.model.Servico;

public class ServicoDAOImpl implements ServicoDAO{

	private TipoServicoDAOImpl tipoServicoDAOImpl = new TipoServicoDAOImpl();
	private ViaturaDAOImpl viaturaDAOImpl = new ViaturaDAOImpl();

	public List<Servico> getServicos() throws Exception {
		List<Servico> servicos = new ArrayList<Servico>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.servico;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				servicos.add(new Servico(
						resultSet.getInt("Id"),
						resultSet.getTime("HoraInicio"),
						resultSet.getTime("HoraFim"),
						resultSet.getDate("Data"),
						resultSet.getString("Observacao"),
						resultSet.getInt("Numero"),
						resultSet.getString("Composicao"),
						resultSet.getString("Titulo"),
						resultSet.getString("Itenerario"),
						viaturaDAOImpl.getViatura(resultSet.getInt("Viatura_Id")),
						tipoServicoDAOImpl.getTipoServico(resultSet.getInt("TipoServico_Id")),
						resultSet.getString("FRadio"),
						resultSet.getDate("DataInicio"),
						resultSet.getDate("DataFim")));
			}
			return servicos;
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

	public List<Servico> getServicosByDate(Date data) throws Exception {
		List<Servico> servicos = new ArrayList<Servico>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.servico where Data= ?;");
			preparedStatement.setDate(1, data);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				servicos.add(new Servico(
						resultSet.getInt("Id"),
						resultSet.getTime("HoraInicio"),
						resultSet.getTime("HoraFim"),
						resultSet.getDate("Data"),
						resultSet.getString("Observacao"),
						resultSet.getInt("Numero"),
						resultSet.getString("Composicao"),
						resultSet.getString("Titulo"),
						resultSet.getString("Itenerario"),
						viaturaDAOImpl.getViatura(resultSet.getInt("Viatura_Id")),
						tipoServicoDAOImpl.getTipoServico(resultSet.getInt("TipoServico_Id")),
						resultSet.getString("FRadio"),
						resultSet.getDate("DataInicio"),
						resultSet.getDate("DataFim")));
			}
			return servicos;
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

	public Servico getServico(int id) throws Exception {
		Servico servico = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.servico where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				servico = new Servico(
						resultSet.getInt("Id"),
						resultSet.getTime("HoraInicio"),
						resultSet.getTime("HoraFim"),
						resultSet.getDate("Data"),
						resultSet.getString("Observacao"),
						resultSet.getInt("Numero"),
						resultSet.getString("Composicao"),
						resultSet.getString("Titulo"),
						resultSet.getString("Itenerario"),
						viaturaDAOImpl.getViatura(resultSet.getInt("Viatura_Id")),
						tipoServicoDAOImpl.getTipoServico(resultSet.getInt("TipoServico_Id")),
						resultSet.getString("FRadio"),
						resultSet.getDate("DataInicio"),
						resultSet.getDate("DataFim"));
			}
			return servico;
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

	public int addServico(Servico servico) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.servico (HoraInicio,HoraFim,Data,Observacao,Numero,Composicao,Titulo,Itenerario,Viatura_Id,TipoServico_Id,FRadio,DataInicio,DataFim) values ( ?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?)");
			preparedStatement.setTime(1, servico.getHoraInicio());
			preparedStatement.setTime(2, servico.getHoraFim());
			preparedStatement.setDate(3, servico.getData());
			preparedStatement.setString(4, servico.getObservacao());
			preparedStatement.setInt(5, servico.getNumero());
			preparedStatement.setString(6, servico.getComposicao());
			preparedStatement.setString(7, servico.getTitulo());
			preparedStatement.setString(8, servico.getItenerario());
			preparedStatement.setInt(9, servico.getViatura().getId());
			preparedStatement.setInt(10, servico.getTipoServico().getId());
			preparedStatement.setString(11, servico.getfRadio());
			preparedStatement.setDate(12, servico.getDataInicio());
			preparedStatement.setDate(13, servico.getDataFim());
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

	public int deleteServico(int id) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.servico where Id = ?");
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

	public int updateServico(Servico servico) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.servico set HoraInicio = ?,HoraFim = ?,Data = ?,Observacao = ?,Numero = ?,Composicao = ?,Titulo = ?,Itenerario = ?,Viatura_Id = ?,TipoServico_Id = ?,FRadio = ?, DataInicio=?,DataFim=? where Id = ?");
			preparedStatement.setTime(1, servico.getHoraInicio());
			preparedStatement.setTime(2, servico.getHoraFim());
			preparedStatement.setDate(3, servico.getData());
			preparedStatement.setString(4, servico.getObservacao());
			preparedStatement.setInt(5, servico.getNumero());
			preparedStatement.setString(6, servico.getComposicao());
			preparedStatement.setString(7, servico.getTitulo());
			preparedStatement.setString(8, servico.getItenerario());
			preparedStatement.setInt(9, servico.getViatura().getId());
			preparedStatement.setInt(10, servico.getTipoServico().getId());
			preparedStatement.setString(11, servico.getfRadio());
			preparedStatement.setDate(12, servico.getDataInicio());
			preparedStatement.setDate(13, servico.getDataFim());
			preparedStatement.setInt(14, servico.getId());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		finally {
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connect!=null)
				dataService.close(connect);
		}

	}

}
