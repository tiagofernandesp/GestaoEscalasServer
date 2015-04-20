package pt.gnr.gestaoescalas.domain;

public class Categoria {
	private int id;
	private String designacao;
	
	public Categoria() {
		this(-1, null);
	}
	public Categoria(int id, String designacao) {
		super();
		this.id = id;
		this.designacao = designacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignacao() {
		return designacao;
	}
	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}
	
}
