package pt.gnr.gestaoescalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pt.gnr.gestaoescalas.model.Categoria;
import pt.gnr.gestaoescalas.model.DataService;

public class CategoriaDAOImpl implements CategoriaDAO {
	
	public CategoriaDAOImpl ()
	{
		
	}
	/**
	 * 
	 * Devolve todos objetos da tabela
	 * 
	 * @return Lista de objectos
	 * */
	public List<Categoria> getCategorias() throws Exception {
		List<Categoria> categorias = new ArrayList<Categoria>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {
			
			connect = dataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.categoria;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				categorias.add(new Categoria(
						resultSet.getInt("Id"),
						resultSet.getString("Designacao")));
			}
			return categorias;
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

	/**
	 * 
	 * @param id
	 *            do objecto
	 * @return categoria retorna um objecto
	 * 
	 * */
	public Categoria getCategoria(int id) throws Exception {

		Categoria categoria = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.categoria where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				categoria = new Categoria(
						resultSet.getInt("Id"),
						resultSet.getString("Designacao"));
			}
			return categoria;
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

	/**
	 * 
	 * Adiciona novo objecto
	 * 
	 * @param categoria
	 *            objecto para adicionar à BD
	 * */
	public void addCategoria(Categoria categoria) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.categoria (Designacao) values ( ?)");
			preparedStatement.setString(1, categoria.getDesignacao());
			
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

	/**
	 * 
	 * Modifica objecto
	 * 
	 * @param categoria
	 *            objecto para modificar na BD
	 * 
	 * */
	public void updateCategoria(Categoria categoria) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.categoria set Designacao = ? where Id = ?");
			preparedStatement.setString(1, categoria.getDesignacao());
			preparedStatement.setInt(2, categoria.getId());
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

	/**
	 * 
	 * Apaga objecto
	 * 
	 * @param categoria
	 *            objecto para apagar na BD
	 * 
	 * */
	public void deleteCategoria(int id) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;
		DataService dataService = new DataService();
		try {

			connect = dataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.categoria where Id = ?");
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
}
