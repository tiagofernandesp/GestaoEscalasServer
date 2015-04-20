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

import pt.gnr.gestaoescalas.domain.Servico;
import pt.gnr.gestaoescalas.domain.DataService;

@Controller
@RequestMapping("/servico")
public class ServicoController {

	/**
	 * 
	 * Devolve todos objetos da tabela
	 * 
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Servico> getServicos()
			throws Exception {
		List<Servico> servicos = new ArrayList<Servico>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connect = DataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.servico;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				servicos.add(new Servico(
						resultSet.getInt("Id"),
						resultSet.getDate("HoraInicio"),
						resultSet.getDate("HoraFim"),
						resultSet.getDate("Data"),
						resultSet.getString("Observacao"),
						resultSet.getInt("Numero"),
						resultSet.getString("Composicao"),
						resultSet.getString("Titulo"),
						resultSet.getString("Itenerario"),
						resultSet.getInt("Viatura_Id"),
						resultSet.getInt("TipoServico_Id"),
						resultSet.getString("FRadio")));
			}
			return servicos;
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
	 * @return servico retorna um objecto
	 * 
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody Servico getServico(
			@PathVariable("id") int id) throws Exception {

		Servico servico = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.servico where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				servico = new Servico(
						resultSet.getInt("Id"),
						resultSet.getDate("HoraInicio"),
						resultSet.getDate("HoraFim"),
						resultSet.getDate("Data"),
						resultSet.getString("Observacao"),
						resultSet.getInt("Numero"),
						resultSet.getString("Composicao"),
						resultSet.getString("Titulo"),
						resultSet.getString("Itenerario"),
						resultSet.getInt("Viatura_Id"),
						resultSet.getInt("TipoServico_Id"),
						resultSet.getString("FRadio"));
			}
			return servico;
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
	 * @param servico
	 *            objecto para adicionar à BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addServico(
			@RequestBody Servico servico) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.servico (HoraInicio,HoraFim,Data,Observacao,Numero,Composicao,Titulo,Itenerario,Viatura_Id,TipoServico_Id,FRadio) values ( ?, ?,?, ?,?, ?,?, ?,?, ?,?)");
			preparedStatement.setDate(1, servico.getHoraInicio());
			preparedStatement.setDate(2, servico.getHoraFim());
			preparedStatement.setDate(3, servico.getData());
			preparedStatement.setString(4, servico.getObservacao());
			preparedStatement.setInt(5, servico.getNumero());
			preparedStatement.setString(6, servico.getComposicao());
			preparedStatement.setString(7, servico.getTitulo());
			preparedStatement.setString(8, servico.getItenerario());
			preparedStatement.setInt(9, servico.getViatua_Id());
			preparedStatement.setInt(10, servico.getTipoServico_Id());
			preparedStatement.setString(11, servico.getFRadio());

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
	 * @param servico
	 *            objecto para modificar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updateServico(
			@RequestBody Servico servico) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.servico set HoraInicio = ?,HoraFim = ?,Data = ?,Observacao = ?,Numero = ?,Composicao = ?,Titulo = ?,Itenerario = ?,Viatura_Id = ?,TipoServico_Id = ?,FRadio = ? where Id = ?");
			preparedStatement.setDate(1, servico.getHoraInicio());
			preparedStatement.setDate(2, servico.getHoraFim());
			preparedStatement.setDate(3, servico.getData());
			preparedStatement.setString(4, servico.getObservacao());
			preparedStatement.setInt(5, servico.getNumero());
			preparedStatement.setString(6, servico.getComposicao());
			preparedStatement.setString(7, servico.getTitulo());
			preparedStatement.setString(8, servico.getItenerario());
			preparedStatement.setInt(9, servico.getViatua_Id());
			preparedStatement.setInt(10, servico.getTipoServico_Id());
			preparedStatement.setString(11, servico.getFRadio());
			preparedStatement.setInt(12, servico.getId());

			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		finally {
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
	 * @param servico
	 *            objecto para apagar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * 
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deleteServico(
			@RequestBody Servico servico) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.servico where Id = ?");
			preparedStatement.setInt(1, servico.getId());

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