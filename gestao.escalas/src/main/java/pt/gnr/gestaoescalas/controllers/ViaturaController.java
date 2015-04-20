package pt.gnr.gestaoescalas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

import pt.gnr.gestaoescalas.domain.Viatura;
import pt.gnr.gestaoescalas.domain.DataService;

@Controller
@RequestMapping("/viatura")
public class ViaturaController {

	/**
	 * 
	 * Devolve todos objetos da tabela
	 * 
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Viatura> getViaturas()
			throws Exception {
		List<Viatura> viaturas = new ArrayList<Viatura>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connect = DataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.viatura;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				viaturas.add(new Viatura(
						resultSet.getInt("Id"),
						resultSet.getString("Descricao"),
						resultSet.getString("Matricula")));
			}
			return viaturas;
		} catch (Exception e) {
			throw e;
		} finally {
			if(resultSet!=null)
				resultSet.close();
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connect!=null)
				DataService.close(connect);
		}

	}

	/**
	 * 
	 * Metodo devolte objecto pelo "/{id}"
	 * 
	 * @param id
	 *            do objecto
	 * @return viatura retorna um objecto
	 * 
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody Viatura getViatura(
			@PathVariable("id") int id) throws Exception {

		Viatura viatura = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.viatura where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				viatura = new Viatura(
						resultSet.getInt("Id"),
						resultSet.getString("Descricao"),
						resultSet.getString("Matricula"));
			}
			return viatura;
		} catch (Exception e) {
			throw e;
		} finally {
			if(resultSet!=null)
				resultSet.close();
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connect!=null)
				DataService.close(connect);
		}

	}

	/**
	 * 
	 * Adiciona novo objecto
	 * 
	 * @param viatura
	 *            objecto para adicionar à BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addViatura(
			@RequestBody Viatura viatura) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.viatura (Descricao,Matricula) values ( ?, ?)");
			preparedStatement.setString(1, viatura.getDescricao());
			preparedStatement.setString(2, viatura.getMatricula());

			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connect!=null)
				DataService.close(connect);
		}
	}

	/**
	 * 
	 * Modifica objecto
	 * 
	 * @param viatura
	 *            objecto para modificar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updateViatura(
			@RequestBody Viatura viatura) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.viatura set Descricao = ?, Matricula = ? where Id = ?");
			preparedStatement.setString(1, viatura.getDescricao());
			preparedStatement.setString(2, viatura.getMatricula());
			preparedStatement.setInt(3, viatura.getId());

			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connect!=null)
				DataService.close(connect);
		}
	}

	/**
	 * 
	 * Apaga objecto
	 * 
	 * @param viatura
	 *            objecto para apagar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * 
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deleteViatura(
			@RequestBody Viatura viatura) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.viatura where Id = ?");
			preparedStatement.setInt(1, viatura.getId());

			return preparedStatement.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connect!=null)
				DataService.close(connect);
		}
	}
}