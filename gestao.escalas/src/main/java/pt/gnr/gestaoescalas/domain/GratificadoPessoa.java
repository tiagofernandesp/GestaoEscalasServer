package pt.gnr.gestaoescalas.domain;

import java.sql.Date;

public class GratificadoPessoa {
	private int id;
	private int gratificado_Id;
	private int pessoa_Id;
	private int status;
	private String erro;
	private Date data;
	
	
	public GratificadoPessoa() {
		this(-1, 0, 0, 0, null,null);
	}


	public GratificadoPessoa(int id, int gratificado_Id, int pessoa_Id,
			int status, String erro, Date data) {
		super();
		this.id = id;
		this.gratificado_Id = gratificado_Id;
		this.pessoa_Id = pessoa_Id;
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


	public int getGratificado_Id() {
		return gratificado_Id;
	}


	public void setGratificado_Id(int gratificado_Id) {
		this.gratificado_Id = gratificado_Id;
	}


	public int getPessoa_Id() {
		return pessoa_Id;
	}


	public void setPessoa_Id(int pessoa_Id) {
		this.pessoa_Id = pessoa_Id;
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