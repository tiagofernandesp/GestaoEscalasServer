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

import pt.gnr.gestaoescalas.domain.ServicoPessoa;
import pt.gnr.gestaoescalas.domain.DataService;

@Controller
@RequestMapping("/servicopessoa")
public class ServicoPessoaController {

	/**
	 * 
	 * Devolve todos objetos da tabela
	 * 
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<ServicoPessoa> getServicoPessoas()
			throws Exception {
		List<ServicoPessoa> servicoPessoas = new ArrayList<ServicoPessoa>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connect = DataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.servicopessoa;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				servicoPessoas.add(new ServicoPessoa(
						resultSet.getInt("Id"),
						resultSet.getInt("Servico_Id"),
						resultSet.getInt("Pessoa_Id")));
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
				DataService.close(connect);
		}

	}

	/**
	 * 
	 * Metodo devolte objecto pelo "/{id}"
	 * 
	 * @param id
	 *            do objecto
	 * @return servicoPessoa retorna um objecto
	 * 
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody ServicoPessoa getServicoPessoa(
			@PathVariable("id") int id) throws Exception {

		ServicoPessoa servicoPessoa = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.servicopessoa where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				servicoPessoa = new ServicoPessoa(
						resultSet.getInt("Id"),
						resultSet.getInt("Servico_Id"),
						resultSet.getInt("Pessoa_Id"));
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
				DataService.close(connect);
		}

	}

	/**
	 * 
	 * Adiciona novo objecto
	 * 
	 * @param servicoPessoa
	 *            objecto para adicionar à BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addServicoPessoa(
			@RequestBody ServicoPessoa servicoPessoa) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.servicopessoa (Servico_Id,Pessoa_Id) values ( ?, ?)");
			preparedStatement.setInt(1, servicoPessoa.getServico_Id());
			preparedStatement.setInt(2, servicoPessoa.getPessoa_Id());

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
	 * @param servicoPessoa
	 *            objecto para modificar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updateServicoPessoa(
			@RequestBody ServicoPessoa servicoPessoa) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.servicopessoa set Servico_Id = ?, Pessoa_Id = ? where Id = ?");
			preparedStatement.setInt(1, servicoPessoa.getServico_Id());
			preparedStatement.setInt(2, servicoPessoa.getPessoa_Id());
			preparedStatement.setInt(3, servicoPessoa.getId());

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
	 * @param servicoPessoa
	 *            objecto para apagar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * 
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deleteServicoPessoa(
			@RequestBody ServicoPessoa servicoPessoa) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.servicopessoa where Id = ?");
			preparedStatement.setInt(1, servicoPessoa.getId());

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