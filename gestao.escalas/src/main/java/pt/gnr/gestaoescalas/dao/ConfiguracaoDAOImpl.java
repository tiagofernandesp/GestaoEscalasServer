package pt.gnr.gestaoescalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import pt.gnr.gestaoescalas.model.Configuracao;
import pt.gnr.gestaoescalas.model.DataService;

public class ConfiguracaoDAOImpl implements ConfiguracaoDAO {

	public ConfiguracaoDAOImpl ()
	{

	}

	public List<Configuracao> getConfiguracaos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Configuracao getConfiguracao(int id) throws Exception {
		Configuracao configuracao = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.configuracao where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				configuracao = new Configuracao(
						resultSet.getInt("Id"),
						resultSet.getString("NomePosto"),
						resultSet.getInt("NFolgasSemanais"),
						resultSet.getInt("NDiasFeriasAnuais"));
			}
			return configuracao;
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

	public int addConfiguracao(Configuracao configuracao) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.configuracao (Id, NomePosto,NFolgasSemanais,NDiasFeriasAnuais) values ( ?, ? ,?,?)");
			preparedStatement.setInt(1, configuracao.getId());
			preparedStatement.setString(2, configuracao.getNomePosto());
			preparedStatement.setInt(3, configuracao.getnFolgasSemanais());
			preparedStatement.setInt(4, configuracao.getnDiasFeriasAnuais());
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

	public int deleteConfiguracao(int id) throws Exception{
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.configuracao where Id = ?");
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

	public int updateConfiguracao(Configuracao configuracao) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.configuracao set NomePosto = ?, NFolgasSemanais = ?, NDiasFeriasAnuais = ? where Id = ?");
			preparedStatement.setString(1, configuracao.getNomePosto());
			preparedStatement.setInt(2, configuracao.getnFolgasSemanais());
			preparedStatement.setInt(3, configuracao.getnDiasFeriasAnuais());
			preparedStatement.setInt(4, configuracao.getId());
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
