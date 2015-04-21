package pt.gnr.gestaoescalas.domain;

import java.sql.Date;

public class ServicoPessoa {
	private int id;
	private int servico_Id;
	private int pessoa_Id;
	private int Status;
	private String erro;
	private Date data;
	
	
	public ServicoPessoa() {
		this(-1, 0, 0, 0, null,null);
	}


	public ServicoPessoa(int id, int servico_Id, int pessoa_Id, int status,
			String erro, Date data) {
		super();
		this.id = id;
		this.servico_Id = servico_Id;
		this.pessoa_Id = pessoa_Id;
		Status = status;
		this.erro = erro;
		this.data = data;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getServico_Id() {
		return servico_Id;
	}


	public void setServico_Id(int servico_Id) {
		this.servico_Id = servico_Id;
	}


	public int getPessoa_Id() {
		return pessoa_Id;
	}


	public void setPessoa_Id(int pessoa_Id) {
		this.pessoa_Id = pessoa_Id;
	}


	public int getStatus() {
		return Status;
	}


	public void setStatus(int status) {
		Status = status;
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
