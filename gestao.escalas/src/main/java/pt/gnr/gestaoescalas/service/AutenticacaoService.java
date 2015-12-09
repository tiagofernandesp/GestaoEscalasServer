package pt.gnr.gestaoescalas.service;

import java.sql.Date;
import java.util.Calendar;

import pt.gnr.gestaoescalas.dao.AutenticacaoDAOImpl;
import pt.gnr.gestaoescalas.model.Autenticacao;
import pt.gnr.gestaoescalas.dao.UtilizadorDAOImpl;
import pt.gnr.gestaoescalas.model.Utilizador;

public class AutenticacaoService {

	private AutenticacaoDAOImpl autenticacaoDAOImpl = new AutenticacaoDAOImpl();
	private UtilizadorDAOImpl utilizadorDAOImpl = new UtilizadorDAOImpl();
	
	/**
	 * 
	 * @param utilizador
	 * @return
	 * @throws Exception
	 */
	public Autenticacao login(Utilizador utilizador) throws Exception {
		try {
			Utilizador newUtilizador = new Utilizador();
			Autenticacao autenticacao = new Autenticacao();
			newUtilizador = utilizadorDAOImpl.getUtilizadorByUserPass(utilizador.getUser(), utilizador.getPass());
			if(newUtilizador.getId()==-1){
				return null;
			}
			autenticacao=autenticacaoDAOImpl.getAutenticacao(newUtilizador.getId());
			//se existe autenticaçao para esse utilizador apaga
			if(autenticacao.getId()==-1){
				if(autenticacaoDAOImpl.deleteAutenticacao(autenticacao.getId(), autenticacao.getRule())!=1){
					return null;
				}
			}
			//cria nova autenticacao
			Date date = new Date(Calendar.getInstance().getTimeInMillis());
			
			Autenticacao newAutenticacao = new Autenticacao();
			newAutenticacao.setUtilizador_Id(utilizador.getId());
			newAutenticacao.setData(date);
			newAutenticacao.setRule(generateRule());
			
			return newAutenticacao;
				
		} catch (Exception e) {
			throw e;
		}


	}
	/**
	 * 
	 * @return
	 */
	public String generateRule () throws Exception{
		try {
			return "Tiago";
		} catch (Exception e) {
			throw e;
		}
	}
	
	public int logout(Autenticacao autenticacao) throws Exception {
		try {
			return autenticacaoDAOImpl.deleteAutenticacao(autenticacao.getId(),autenticacao.getRule());
		} catch (Exception e) {
			throw e;
		}


	}
	public Autenticacao isLoged(Autenticacao aut) throws Exception {
		try {
			return autenticacaoDAOImpl.getAutenticacaoByRule(aut.getUtilizador_Id(),aut.getRule());
		} catch (Exception e) {
			throw e;
		}


	}
	
}