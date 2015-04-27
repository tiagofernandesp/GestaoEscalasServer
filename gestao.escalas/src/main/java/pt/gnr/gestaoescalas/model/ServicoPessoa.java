package pt.gnr.gestaoescalas.model;

import java.sql.Date;

public class ServicoPessoa {
	private int id;
	private Servico servico;
	private Pessoa pessoa;
	private int Status;
	private String erro;
	private Date data;
	
	
	public ServicoPessoa() {
		this(-1, null,null, 0, null,null);
	}


	public ServicoPessoa(int id, Servico servico, Pessoa pessoa, int status,
			String erro, Date data) {
		super();
		this.id = id;
		this.servico = servico;
		this.pessoa = pessoa;
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


	public Servico getServico() {
		return servico;
	}


	public void setServico(Servico servico) {
		this.servico = servico;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
