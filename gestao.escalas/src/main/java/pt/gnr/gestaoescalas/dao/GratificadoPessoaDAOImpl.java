package pt.gnr.gestaoescalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pt.gnr.gestaoescalas.model.DataService;
import pt.gnr.gestaoescalas.model.GratificadoPessoa;

public class GratificadoPessoaDAOImpl implements GratificadoPessoaDAO{

	private GratificadoDAOImpl gratificadoDAOImpl = new GratificadoDAOImpl();
	private PessoaDAOImpl pessoaDAOImpl = new PessoaDAOImpl();

	public GratificadoPessoaDAOImpl()
	{

	}

	public List<GratificadoPessoa> getGratificadoPessoas() throws Exception {
		List<GratificadoPessoa> gratificadoPessoas = new ArrayList<GratificadoPessoa>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.gratificadopessoa;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				gratificadoPessoas.add(new GratificadoPessoa(
						resultSet.getInt("Id"),
						gratificadoDAOImpl.getGratificado(resultSet.getInt("Gratificado_Id")),
						pessoaDAOImpl.getPessoa(resultSet.getInt("Pessoa_Id")),
						resultSet.getInt("Status"),
						resultSet.getString("Erro"),
						resultSet.getDate("Data")));
			}
			return gratificadoPessoas;
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

	public GratificadoPessoa getGratificadoPessoa(int id) throws Exception {
		GratificadoPessoa gratificadoPessoa = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.gratificadopessoa where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				gratificadoPessoa = new GratificadoPessoa(
						resultSet.getInt("Id"),
						gratificadoDAOImpl.getGratificado(resultSet.getInt("Gratificado_Id")),
						pessoaDAOImpl.getPessoa(resultSet.getInt("Pessoa_Id")),
						resultSet.getInt("Status"),
						resultSet.getString("Erro"),
						resultSet.getDate("Data"));
			}
			return gratificadoPessoa;
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

	public int addGratificadoPessoa(GratificadoPessoa gratificadoPessoa)
			throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.gratificadopessoa (Gratificado_Id,Pessoa_Id,Status,Erro,Data) values ( ?, ?,?, ?,?)");
			preparedStatement.setInt(1, gratificadoPessoa.getGratificado().getId());
			preparedStatement.setInt(2, gratificadoPessoa.getPessoa().getId());
			preparedStatement.setInt(3, gratificadoPessoa.getStatus());
			preparedStatement.setString(4, gratificadoPessoa.getErro());
			preparedStatement.setDate(5, gratificadoPessoa.getData());
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

	public int deleteGratificadoPessoa(int id) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.gratificadopessoa where Id = ?");
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

	public int updateGratificadoPessoa(GratificadoPessoa gratificadoPessoa)
			throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.gratificadopessoa set Gratificado_Id = ?, Pessoa_Id = ?, Status = ? , Erro = ?, Data = ? where Id = ?");
			preparedStatement.setInt(1, gratificadoPessoa.getGratificado().getId());
			preparedStatement.setInt(2, gratificadoPessoa.getPessoa().getId());
			preparedStatement.setInt(3, gratificadoPessoa.getStatus());
			preparedStatement.setString(4, gratificadoPessoa.getErro());
			preparedStatement.setDate(5, gratificadoPessoa.getData());
			preparedStatement.setInt(6, gratificadoPessoa.getId());
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
