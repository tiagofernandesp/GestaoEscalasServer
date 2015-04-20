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

import pt.gnr.gestaoescalas.domain.Pessoa;
import pt.gnr.gestaoescalas.domain.DataService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	/**
	 * 
	 * Devolve todos objetos da tabela
	 * 
	 * @return Lista de objectos
	 * */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Pessoa> getPessoas()
			throws Exception {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			connect = DataService.loadDriver();
			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.Pessoa;");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				pessoas.add(new Pessoa(
						resultSet.getInt("Id"),
						resultSet.getString("PNome"),
						resultSet.getString("UNome"),
						resultSet.getString("Apelido"),
						resultSet.getString("Telemovel"),
						resultSet.getString("Telefone"),
						resultSet.getString("CP"),
						resultSet.getString("Rua"),
						resultSet.getInt("Porta"),
						resultSet.getString("Cidade"),
						resultSet.getString("NumeroGNR"),
						resultSet.getString("NumeroPosto"),
						resultSet.getBoolean("Ativo"),
						resultSet.getDate("DataIngresso"),
						resultSet.getInt("Categoria_Id")));
			}
			return pessoas;
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
	 * @return Pessoa retorna um objecto
	 * 
	 * */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody Pessoa getPessoa(
			@PathVariable("id") int id) throws Exception {

		Pessoa Pessoa = null;
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("SELECT * from gestaoescalas.Pessoa where Id= ?");
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Pessoa = new Pessoa(
						resultSet.getInt("Id"),
						resultSet.getString("PNome"),
						resultSet.getString("UNome"),
						resultSet.getString("Apelido"),
						resultSet.getString("Telemovel"),
						resultSet.getString("Telefone"),
						resultSet.getString("CP"),
						resultSet.getString("Rua"),
						resultSet.getInt("Porta"),
						resultSet.getString("Cidade"),
						resultSet.getString("NumeroGNR"),
						resultSet.getString("NumeroPosto"),
						resultSet.getBoolean("Ativo"),
						resultSet.getDate("DataIngresso"),
						resultSet.getInt("Categoria_Id"));
			}
			return Pessoa;
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
	 * @param Pessoa
	 *            objecto para adicionar à BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody int addPessoa(
			@RequestBody Pessoa Pessoa) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("insert into gestaoescalas.Pessoa (PNome, UNome, Apelido, Telemovel, Telefone, CP, Rua, Porta, Cidade, NumeroGNR, NumeroPosto, Ativo, DataIngresso, Categoria_Id) values ( ?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?,?)");
			preparedStatement.setString(1, Pessoa.getpNome());
			preparedStatement.setString(2, Pessoa.getuNome());
			preparedStatement.setString(3, Pessoa.getApelido());
			preparedStatement.setString(4, Pessoa.getTelemovel());
			preparedStatement.setString(5, Pessoa.getTelefone());
			preparedStatement.setString(6, Pessoa.getcP());
			preparedStatement.setString(7, Pessoa.getRua());
			preparedStatement.setInt(8, Pessoa.getPorta());
			preparedStatement.setString(9, Pessoa.getCidade());
			preparedStatement.setString(10, Pessoa.getNumeroGNR());
			preparedStatement.setString(11, Pessoa.getNumeroPosto());
			preparedStatement.setBoolean(12, Pessoa.getAtivo());
			preparedStatement.setDate(13, Pessoa.getDataIngresso());
			preparedStatement.setInt(14, Pessoa.getCategoria_Id());

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
	 * @param Pessoa
	 *            objecto para modificar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * */
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody int updatePessoa(
			@RequestBody Pessoa Pessoa) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("update gestaoescalas.Pessoa set PNome = ?, UNome = ?, Apelido = ?, Telemovel = ?, Telefone = ?, CP = ?, Rua = ?, Porta = ?, Cidade = ?, NumeroGNR = ?, NumeroPosto = ?, Ativo = ?, DataIngresso = ?, Categoria_Id = ? where Id = ?");
			preparedStatement.setString(1, Pessoa.getpNome());
			preparedStatement.setString(2, Pessoa.getuNome());
			preparedStatement.setString(3, Pessoa.getApelido());
			preparedStatement.setString(4, Pessoa.getTelemovel());
			preparedStatement.setString(5, Pessoa.getTelefone());
			preparedStatement.setString(6, Pessoa.getcP());
			preparedStatement.setString(7, Pessoa.getRua());
			preparedStatement.setInt(8, Pessoa.getPorta());
			preparedStatement.setString(9, Pessoa.getCidade());
			preparedStatement.setString(10, Pessoa.getNumeroGNR());
			preparedStatement.setString(11, Pessoa.getNumeroPosto());
			preparedStatement.setBoolean(12, Pessoa.getAtivo());
			preparedStatement.setDate(13, Pessoa.getDataIngresso());
			preparedStatement.setInt(14, Pessoa.getCategoria_Id());
			preparedStatement.setInt(15, Pessoa.getId());

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
	 * @param Pessoa
	 *            objecto para apagar na BD
	 * 
	 * @return inteiro 1 = ok & 0 = fail
	 * 
	 * */
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody int deletePessoa(
			@RequestBody Pessoa Pessoa) throws Exception {

		Connection connect = null;
		PreparedStatement preparedStatement = null;

		try {

			connect = DataService.loadDriver();

			preparedStatement = connect
					.prepareStatement("DELETE FROM gestaoescalas.Pessoa where Id = ?");
			preparedStatement.setInt(1, Pessoa.getId());

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