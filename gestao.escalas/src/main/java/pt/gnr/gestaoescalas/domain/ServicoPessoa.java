package pt.gnr.gestaoescalas.domain;

public class ServicoPessoa {
	private int id;
	private int servico_Id;
	private int pessoa_Id;
	
	
	public ServicoPessoa() {
		this(-1, 0, 0);
	}


	public ServicoPessoa(int id, int servico_Id, int pessoa_Id) {
		super();
		this.id = id;
		this.servico_Id = servico_Id;
		this.pessoa_Id = pessoa_Id;
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
	
	
}
