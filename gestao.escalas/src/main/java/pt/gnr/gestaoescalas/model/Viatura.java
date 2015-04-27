package pt.gnr.gestaoescalas.model;

public class Viatura {
	private int id;
	private String descricao;
	private String matricula;
	
	
	public Viatura() {
		this(-1, null, null);
	}


	public Viatura(int id, String descricao, String matricula) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.matricula = matricula;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
}
