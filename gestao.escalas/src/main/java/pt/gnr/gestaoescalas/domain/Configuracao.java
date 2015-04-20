package pt.gnr.gestaoescalas.domain;

public class Configuracao {
	private int id;
	private String nomePosto;
	private int nFolgasSemanais;
	private int nDiasFeriasAnuais;
	
	
	public Configuracao() {
		this(-1, null, -1, -1);
	}


	public Configuracao(int id, String nomePosto, int nFolgasSemanais,
			int nDiasFeriasAnuais) {
		super();
		this.id = id;
		this.nomePosto = nomePosto;
		this.nFolgasSemanais = nFolgasSemanais;
		this.nDiasFeriasAnuais = nDiasFeriasAnuais;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomePosto() {
		return nomePosto;
	}


	public void setNomePosto(String nomePosto) {
		this.nomePosto = nomePosto;
	}


	public int getnFolgasSemanais() {
		return nFolgasSemanais;
	}


	public void setnFolgasSemanais(int nFolgasSemanais) {
		this.nFolgasSemanais = nFolgasSemanais;
	}


	public int getnDiasFeriasAnuais() {
		return nDiasFeriasAnuais;
	}


	public void setnDiasFeriasAnuais(int nDiasFeriasAnuais) {
		this.nDiasFeriasAnuais = nDiasFeriasAnuais;
	}
	
}
