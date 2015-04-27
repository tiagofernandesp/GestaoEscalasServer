package pt.gnr.gestaoescalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pt.gnr.gestaoescalas.model.DataService;
import pt.gnr.gestaoescalas.model.HabilitaServico;

public class HabilitaServicoDAOImpl implements HabilitaServicoDAO{

	private PessoaDAOImpl pessoaDAOImpl = new PessoaDAOImpl();
	private TipoServicoDAOImpl tipoServicoDAOImpl = new TipoServicoDAOImpl();

	public HabilitaServicoDAOImpl ()
	{

	}

	public List<HabilitaServico> getHabilitaServicos() throws Exception {
		List<HabilitaServico> habilitaServicos = new ArrayList<HabilitaServico>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.HabilitaServico;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				habilitaServicos.add(new HabilitaServico(
						resultSet.getInt("Id"),
						pessoaDAOImpl.getPessoa(resultSet.getInt("Pessoa_Id")),
						tipoServicoDAOImpl.getTipoServico(resultSet.getInt("TipoServico_Id"))));
			}
			return habilitaServicos;
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

	public HabilitaServico getHabilitaServico(int id) throws Exception {
		HabilitaServico habilitaServico = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.HabilitaServico where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				habilitaServico = new HabilitaServico(
						resultSet.getInt("Id"),
						pessoaDAOImpl.getPessoa(resultSet.getInt("Pessoa_Id")),
						tipoServicoDAOImpl.getTipoServico(resultSet.getInt("TipoServico_Id")));
			}
			return habilitaServico;
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

	public void addHabilitaServico(HabilitaServico habilitaServico)
			throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.HabilitaServico (Pessoa_Id,TipoServico_Id) values ( ?, ?)");
			preparedStatement.setInt(1, habilitaServico.getPessoa().getId());
			preparedStatement.setInt(2, habilitaServico.getTipoServico().getId());
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

	public void deleteHabilitaServico(int id) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.HabilitaServico where Id = ?");
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

	public void updateHabilitaServico(HabilitaServico habilitaServico)
			throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.HabilitaServico set Pessoa_Id = ?, TipoServico_Id = ? where Id = ?");
			preparedStatement.setInt(1, habilitaServico.getPessoa().getId());
			preparedStatement.setInt(2, habilitaServico.getTipoServico().getId());
			preparedStatement.setInt(3, habilitaServico.getId());
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
