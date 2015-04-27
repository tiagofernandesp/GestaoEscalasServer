package pt.gnr.gestaoescalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pt.gnr.gestaoescalas.model.DataService;
import pt.gnr.gestaoescalas.model.ServicoPessoa;

public class ServicoPessoaDAOImpl implements ServicoPessoaDAO{

	private PessoaDAOImpl pessoaDAOImpl = new PessoaDAOImpl();
	private ServicoDAOImpl servicoDAOImpl = new ServicoDAOImpl();

	public ServicoPessoaDAOImpl ()
	{

	}

	public List<ServicoPessoa> getServicoPessoas() throws Exception {
		List<ServicoPessoa> servicoPessoas = new ArrayList<ServicoPessoa>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.servicopessoa;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				servicoPessoas.add(new ServicoPessoa(
						resultSet.getInt("Id"),
						servicoDAOImpl.getServico(resultSet.getInt("Servico_Id")),
						pessoaDAOImpl.getPessoa(resultSet.getInt("Pessoa_Id")),
						resultSet.getInt("Status"),
						resultSet.getString("Erro"),
						resultSet.getDate("Data")));
			}
			return servicoPessoas;
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

	public ServicoPessoa getServicoPessoa(int id) throws Exception {
		ServicoPessoa servicoPessoa = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.servicopessoa where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				servicoPessoa = new ServicoPessoa(
						resultSet.getInt("Id"),
						servicoDAOImpl.getServico(resultSet.getInt("Servico_Id")),
						pessoaDAOImpl.getPessoa(resultSet.getInt("Pessoa_Id")),
						resultSet.getInt("Status"),
						resultSet.getString("Erro"),
						resultSet.getDate("Data"));
			}
			return servicoPessoa;
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

	public void addServicoPessoa(ServicoPessoa servicoPessoa) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.servicopessoa (Servico_Id,Pessoa_Id,Status,Erro,Data) values ( ?, ?,?, ?,?)");
			preparedStatement.setInt(1, servicoPessoa.getServico().getId());
			preparedStatement.setInt(2, servicoPessoa.getPessoa().getId());
			preparedStatement.setInt(3, servicoPessoa.getStatus());
			preparedStatement.setString(4, servicoPessoa.getErro());
			preparedStatement.setDate(5, servicoPessoa.getData());
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

	public void deleteServicoPessoa(int id) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.servicopessoa where Id = ?");
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

	public void updateServicoPessoa(ServicoPessoa servicoPessoa)
			throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.servicopessoa set Servico_Id = ?, Pessoa_Id = ?, Status = ? , Erro = ?, Data = ? where Id = ?");
			preparedStatement.setInt(1, servicoPessoa.getServico().getId());
			preparedStatement.setInt(2, servicoPessoa.getPessoa().getId());
			preparedStatement.setInt(3, servicoPessoa.getStatus());
			preparedStatement.setString(4, servicoPessoa.getErro());
			preparedStatement.setDate(5, servicoPessoa.getData());
			preparedStatement.setInt(6, servicoPessoa.getId());
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