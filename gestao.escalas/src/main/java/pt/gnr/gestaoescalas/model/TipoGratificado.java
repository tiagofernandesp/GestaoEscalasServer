package pt.gnr.gestaoescalas.model;

public class TipoGratificado {
	
	private int id;
	private String nome;
	private String prefixo;
	
	public TipoGratificado() {
		this(-1, null,  null);
	}
	
	public TipoGratificado(int id, String nome, String prefixo) {
		super();
		this.id = id;
		this.nome = nome;
		this.prefixo = prefixo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}	
}
