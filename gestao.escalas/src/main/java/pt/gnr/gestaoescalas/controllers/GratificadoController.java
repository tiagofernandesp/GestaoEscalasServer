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

import pt.gnr.gestaoescalas.domain.Gratificado;
import pt.gnr.gestaoescalas.domain.DataService;

@Controller
@RequestMapping("/gratificado")
public class GratificadoController {

	/**
	 * 
	 * Devolve todos objetos da tabela
	 * 
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Gratificado> getGratificados()
			throws Exception {
		List<Gratificado> gratificados = new ArrayList<Gratificado>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connect = DataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.gratificado;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				gratificados.add(new Gratificado(
						resultSet.getInt("Id"),
						resultSet.getDate("HoraInicio"),
						resultSet.getDate("HoraFim"),
						resultSet.getString("Observacao"),
						resultSet.getString("Local"),
						resultSet.getInt("TipoGratificado_Id"),
						resultSet.getInt("Viatura_Id"),
						resultSet.getString("FRadio")));
			}
			return gratificados;
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
	 * @return gratificado retorna um objecto
	 * 
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody Gratificado getGratificado(
			@PathVariable("id") int id) throws Exception {

		Gratificado gratificado = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.gratificado where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				gratificado = new Gratificado(
						resultSet.getInt("Id"),
						resultSet.getDate("HoraInicio"),
						resultSet.getDate("HoraFim"),
						resultSet.getString("Observacao"),
						resultSet.getString("Local"),
						resultSet.getInt("TipoGratificado_Id"),
						resultSet.getInt("Viatura_Id"),
						resultSet.getString("FRadio"));
			}
			return gratificado;
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
	 * @param gratificado
	 *            objecto para adicionar à BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addGratificado(
			@RequestBody Gratificado gratificado) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.gratificado (HoraInicio,HoraFim,Observacao,Local,TipoGratificado_Id,Viatura_Id,FRadio) values ( ?, ?,?, ?,?, ?,?)");
			preparedStatement.setDate(1, gratificado.getHoraInicio());
			preparedStatement.setDate(2, gratificado.getHoraFim());
			preparedStatement.setString(3, gratificado.getObservacao());
			preparedStatement.setString(4, gratificado.getLocal());
			preparedStatement.setInt(5, gratificado.getTipoGratificado_Id());
			preparedStatement.setInt(6, gratificado.getViatua_Id());
			preparedStatement.setString(7, gratificado.getFRadio());

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
	 * @param gratificado
	 *            objecto para modificar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updateGratificado(
			@RequestBody Gratificado gratificado) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.gratificado set HoraInicio = ?, HoraFim = ?, Observacao = ?, Local = ?, TipoGratificado_Id = ?, Viatura_Id = ?, FRadio = ? where Id = ?");
			preparedStatement.setDate(1, gratificado.getHoraInicio());
			preparedStatement.setDate(2, gratificado.getHoraFim());
			preparedStatement.setString(3, gratificado.getObservacao());
			preparedStatement.setString(4, gratificado.getLocal());
			preparedStatement.setInt(5, gratificado.getTipoGratificado_Id());
			preparedStatement.setInt(6, gratificado.getViatua_Id());
			preparedStatement.setString(7, gratificado.getFRadio());
			preparedStatement.setInt(8, gratificado.getId());

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
	 * @param gratificado
	 *            objecto para apagar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * 
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deleteGratificado(
			@RequestBody Gratificado gratificado) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.gratificado where Id = ?");
			preparedStatement.setInt(1, gratificado.getId());

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