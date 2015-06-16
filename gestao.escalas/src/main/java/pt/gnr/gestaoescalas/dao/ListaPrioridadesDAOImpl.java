package pt.gnr.gestaoescalas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pt.gnr.gestaoescalas.model.DataService;
import pt.gnr.gestaoescalas.model.LinhaListaPrioridade;

public class ListaPrioridadesDAOImpl implements ListaPrioridadesDAO{

	public ListaPrioridadesDAOImpl ()
	{

	}


	public List<LinhaListaPrioridade> getListByIdDate (Date data, int id) throws Exception {
		List<LinhaListaPrioridade> listaPrioridades = new ArrayList<LinhaListaPrioridade>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement(" SELECT * FROM gestaoescalas.pessoa AS P INNER JOIN (SELECT HS.Pessoa_Id, S.Data FROM gestaoescalas.HabilitaServico AS HS LEFT JOIN (SELECT max(Data) as Data , Pessoa_Id FROM gestaoescalas.ServicoPessoa WHERE Servico_Id = ? AND Data < ? GROUP BY Pessoa_Id) AS S ON S.Pessoa_Id = HS.Pessoa_Id where HS.TipoServico_Id = ?) AS N "
							+ "ON P.Id=N.Pessoa_Id where Ativo = '1' ORDER BY Data ASC;");
			preparedStatement.setInt(1, id);
			preparedStatement.setDate(2, data);
			preparedStatement.setInt(3, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listaPrioridades.add(new LinhaListaPrioridade(
						resultSet.getDate("Data"),
						resultSet.getString("Apelido")));
			}
			return listaPrioridades;
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

}
