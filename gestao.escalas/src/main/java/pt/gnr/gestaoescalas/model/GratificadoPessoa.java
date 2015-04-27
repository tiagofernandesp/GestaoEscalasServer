package pt.gnr.gestaoescalas.model;

import java.sql.Date;

public class GratificadoPessoa {
	private int id;
	private Gratificado gratificado;
	private Pessoa pessoa;
	private int status;
	private String erro;
	private Date data;
	
	
	public GratificadoPessoa() {
		this(-1, null, null, 0, null,null);
	}


	public GratificadoPessoa(int id, Gratificado gratificado, Pessoa pessoa,
			int status, String erro, Date data) {
		super();
		this.id = id;
		this.gratificado = gratificado;
		this.pessoa = pessoa;
		this.status = status;
		this.erro = erro;
		this.data = data;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Gratificado getGratificado() {
		return gratificado;
	}


	public void setGratificado(Gratificado gratificado) {
		this.gratificado = gratificado;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getErro() {
		return erro;
	}


	public void setErro(String erro) {
		this.erro = erro;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}