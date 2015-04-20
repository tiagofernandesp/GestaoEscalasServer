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

import pt.gnr.gestaoescalas.domain.TipoServico;
import pt.gnr.gestaoescalas.domain.DataService;

@Controller
@RequestMapping("/tiposervico")
public class TipoServicoController {

	/**
	 * 
	 * Devolve todos objetos da tabela
	 * 
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<TipoServico> getTipoServicos()
			throws Exception {
		List<TipoServico> tipoServicos = new ArrayList<TipoServico>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connect = DataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.tiposervico;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tipoServicos.add(new TipoServico(
						resultSet.getInt("Id"),
						resultSet.getString("Nome"),
						resultSet.getString("Prefixo"),
						resultSet.getInt("HoraInicio"),
						resultSet.getInt("HoraFim"),
						resultSet.getBoolean("ServicoMinimo")));
			}
			return tipoServicos;
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
	 * @return tipoServico retorna um objecto
	 * 
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody TipoServico getTipoServico(
			@PathVariable("id") int id) throws Exception {

		TipoServico tipoServico = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.tiposervico where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tipoServico = new TipoServico(
						resultSet.getInt("Id"),
						resultSet.getString("Nome"),
						resultSet.getString("Prefixo"),
						resultSet.getInt("HoraInicio"),
						resultSet.getInt("HoraFim"),
						resultSet.getBoolean("ServicoMinimo"));
			}
			return tipoServico;
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
	 * @param tipoServico
	 *            objecto para adicionar à BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addTipoServico(
			@RequestBody TipoServico tipoServico) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.tiposervico (Nome,Prefixo,HoraInicio,HoraFim,ServicoMinimo) values ( ?, ?,?, ?,?)");
			preparedStatement.setString(1, tipoServico.getNome());
			preparedStatement.setString(2, tipoServico.getPrefixo());
			preparedStatement.setInt(3, tipoServico.getHoraInicio());
			preparedStatement.setInt(4, tipoServico.getHoraFim());
			preparedStatement.setBoolean(5, tipoServico.getServicoMinimo());

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
	 * @param tipoServico
	 *            objecto para modificar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updateTipoServico(
			@RequestBody TipoServico tipoServico) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.tiposervico set Nome = ?, Prefixo = ?, HoraInicio = ?, HoraFim = ?, ServicoMinimo = ? where Id = ?");
			preparedStatement.setString(1, tipoServico.getNome());
			preparedStatement.setString(2, tipoServico.getPrefixo());
			preparedStatement.setInt(3, tipoServico.getHoraInicio());
			preparedStatement.setInt(4, tipoServico.getHoraFim());
			preparedStatement.setBoolean(5, tipoServico.getServicoMinimo());
			preparedStatement.setInt(6, tipoServico.getId());

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
	 * @param tipoServico
	 *            objecto para apagar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * 
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deleteTipoServico(
			@RequestBody TipoServico tipoServico) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.tiposervico where Id = ?");
			preparedStatement.setInt(1, tipoServico.getId());

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