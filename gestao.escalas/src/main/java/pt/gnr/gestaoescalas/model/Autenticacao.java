package pt.gnr.gestaoescalas.model;

import java.sql.Date;

public class Autenticacao {
	private int id;
	private String rule;
	private Date data;
	private int utilizador_Id;
	
	public Autenticacao() {
		this(-1, null,null,-1);
	}

	public Autenticacao(int id, String rule, Date data, int utilizador_Id) {
		super();
		this.id = id;
		this.rule = rule;
		this.data = data;
		this.utilizador_Id = utilizador_Id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getUtilizador_Id() {
		return utilizador_Id;
	}

	public void setUtilizador_Id(int utilizador_Id) {
		this.utilizador_Id = utilizador_Id;
	}

	
	
	
}
