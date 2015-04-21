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

import pt.gnr.gestaoescalas.domain.GratificadoPessoa;
import pt.gnr.gestaoescalas.domain.DataService;

@Controller
@RequestMapping("/gratificadopessoa")
public class GratificadoPessoaController {

	/**
	 * 
	 * Devolve todos objetos da tabela
	 * 
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<GratificadoPessoa> getGratificadoPessoas()
			throws Exception {
		List<GratificadoPessoa> gratificadoPessoas = new ArrayList<GratificadoPessoa>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connect = DataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.gratificadopessoa;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				gratificadoPessoas.add(new GratificadoPessoa(
						resultSet.getInt("Id"),
						resultSet.getInt("Gratificado_Id"),
						resultSet.getInt("Pessoa_Id"),
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
				DataService.close(connect);
		}

	}

	/**
	 * 
	 * Metodo devolte objecto pelo "/{id}"
	 * 
	 * @param id
	 *            do objecto
	 * @return gratificadoPessoa retorna um objecto
	 * 
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody GratificadoPessoa getGratificadoPessoa(
			@PathVariable("id") int id) throws Exception {

		GratificadoPessoa gratificadoPessoa = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.gratificadopessoa where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				gratificadoPessoa = new GratificadoPessoa(
						resultSet.getInt("Id"),
						resultSet.getInt("Gratificado_Id"),
						resultSet.getInt("Pessoa_Id"),
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
				DataService.close(connect);
		}

	}

	/**
	 * 
	 * Adiciona novo objecto
	 * 
	 * @param gratificadoPessoa
	 *            objecto para adicionar à BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addGratificadoPessoa(
			@RequestBody GratificadoPessoa gratificadoPessoa) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.gratificadopessoa (Gratificado_Id,Pessoa_Id,Status,Erro,Data) values ( ?, ?,?, ?,?)");
			preparedStatement.setInt(1, gratificadoPessoa.getGratificado_Id());
			preparedStatement.setInt(2, gratificadoPessoa.getPessoa_Id());
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
				DataService.close(connect);
		}
	}

	/**
	 * 
	 * Modifica objecto
	 * 
	 * @param gratificadoPessoa
	 *            objecto para modificar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updateGratificadoPessoa(
			@RequestBody GratificadoPessoa gratificadoPessoa) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.gratificadopessoa set Gratificado_Id = ?, Pessoa_Id = ?, Status = ? , Erro = ?, Data = ? where Id = ?");
			preparedStatement.setInt(1, gratificadoPessoa.getGratificado_Id());
			preparedStatement.setInt(2, gratificadoPessoa.getPessoa_Id());
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
				DataService.close(connect);
		}
	}

	/**
	 * 
	 * Apaga objecto
	 * 
	 * @param gratificadoPessoa
	 *            objecto para apagar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * 
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deleteGratificadoPessoa(
			@RequestBody GratificadoPessoa gratificadoPessoa) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.gratificadopessoa where Id = ?");
			preparedStatement.setInt(1, gratificadoPessoa.getId());

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