package pt.gnr.gestaoescalas.controllers;


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

import pt.gnr.gestaoescalas.domain.Configuracao;
import pt.gnr.gestaoescalas.domain.DataService;

@Controller
@RequestMapping("/configuracao")
public class ConfiguracaoController {


	/**
	 * 
	 * Metodo devolte objecto pelo "/{id}"
	 * 
	 * @param id
	 *            do objecto
	 * @return configuracao retorna um objecto
	 * 
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody Configuracao getConfiguracao(
			@PathVariable("id") int id) throws Exception {

		Configuracao configuracao = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connect = DataService.loadDriver();

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
				DataService.close(connect);
		}

	}

	/**
	 * 
	 * Adiciona novo objecto
	 * 
	 * @param configuracao
	 *            objecto para adicionar à BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addConfiguracao(
			@RequestBody Configuracao configuracao) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

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
				DataService.close(connect);
		}
	}

	/**
	 * 
	 * Modifica objecto
	 * 
	 * @param configuracao
	 *            objecto para modificar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updateConfiguracao(
			@RequestBody Configuracao configuracao) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

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
				DataService.close(connect);
		}
	}

	/**
	 * 
	 * Apaga objecto
	 * 
	 * @param configuracao
	 *            objecto para apagar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * 
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deleteConfiguracao(
			@RequestBody Configuracao configuracao) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.configuracao where Id = ?");
			preparedStatement.setInt(1, configuracao.getId());

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