package pt.gnr.gestaoescalas.domain;

public class GratificadoPessoa {
	private int id;
	private int gratificado_Id;
	private int pessoa_Id;
	
	
	public GratificadoPessoa() {
		this(-1, 0, 0);
	}


	public GratificadoPessoa(int id, int gratificado_Id, int pessoa_Id) {
		super();
		this.id = id;
		this.gratificado_Id = gratificado_Id;
		this.pessoa_Id = pessoa_Id;
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
	
	
}
