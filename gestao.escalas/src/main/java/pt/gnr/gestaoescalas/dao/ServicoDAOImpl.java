package pt.gnr.gestaoescalas.dao;

import java.sql.Connection;
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
						resultSet.getDate("HoraInicio"),
						resultSet.getDate("HoraFim"),
						resultSet.getDate("Data"),
						resultSet.getString("Observacao"),
						resultSet.getInt("Numero"),
						resultSet.getString("Composicao"),
						resultSet.getString("Titulo"),
						resultSet.getString("Itenerario"),
						viaturaDAOImpl.getViatura(resultSet.getInt("Viatura_Id")),
						tipoServicoDAOImpl.getTipoServico(resultSet.getInt("TipoServico_Id")),
						resultSet.getString("FRadio")));
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
						resultSet.getDate("HoraInicio"),
						resultSet.getDate("HoraFim"),
						resultSet.getDate("Data"),
						resultSet.getString("Observacao"),
						resultSet.getInt("Numero"),
						resultSet.getString("Composicao"),
						resultSet.getString("Titulo"),
						resultSet.getString("Itenerario"),
						viaturaDAOImpl.getViatura(resultSet.getInt("Viatura_Id")),
						tipoServicoDAOImpl.getTipoServico(resultSet.getInt("TipoServico_Id")),
						resultSet.getString("FRadio"));
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

	public void addServico(Servico servico) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.servico (HoraInicio,HoraFim,Data,Observacao,Numero,Composicao,Titulo,Itenerario,Viatura_Id,TipoServico_Id,FRadio) values ( ?, ?,?, ?,?, ?,?, ?,?, ?,?)");
			preparedStatement.setDate(1, servico.getHoraInicio());
			preparedStatement.setDate(2, servico.getHoraFim());
			preparedStatement.setDate(3, servico.getData());
			preparedStatement.setString(4, servico.getObservacao());
			preparedStatement.setInt(5, servico.getNumero());
			preparedStatement.setString(6, servico.getComposicao());
			preparedStatement.setString(7, servico.getTitulo());
			preparedStatement.setString(8, servico.getItenerario());
			preparedStatement.setInt(9, servico.getViatua().getId());
			preparedStatement.setInt(10, servico.getTipoServico().getId());
			preparedStatement.setString(11, servico.getfRadio());
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

	public void deleteServico(int id) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.servico where Id = ?");
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

	public void updateServico(Servico servico) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.servico set HoraInicio = ?,HoraFim = ?,Data = ?,Observacao = ?,Numero = ?,Composicao = ?,Titulo = ?,Itenerario = ?,Viatura_Id = ?,TipoServico_Id = ?,FRadio = ? where Id = ?");
			preparedStatement.setDate(1, servico.getHoraInicio());
			preparedStatement.setDate(2, servico.getHoraFim());
			preparedStatement.setDate(3, servico.getData());
			preparedStatement.setString(4, servico.getObservacao());
			preparedStatement.setInt(5, servico.getNumero());
			preparedStatement.setString(6, servico.getComposicao());
			preparedStatement.setString(7, servico.getTitulo());
			preparedStatement.setString(8, servico.getItenerario());
			preparedStatement.setInt(9, servico.getViatua().getId());
			preparedStatement.setInt(10, servico.getTipoServico().getId());
			preparedStatement.setString(11, servico.getfRadio());
			preparedStatement.setInt(12, servico.getId());
			preparedStatement.executeUpdate();
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
