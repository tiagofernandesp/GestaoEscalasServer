package pt.gnr.gestaoescalas.domain;

import java.sql.Date;

public class Pessoa {
	private int id;
	private String pNome;
	private String uNome;
	private String apelido;
	private String telemovel;
	private String telefone;
	private String cP;
	private String rua;
	private int porta;
	private String cidade;
	private String numeroGNR;
	private String numeroPosto;
	private boolean ativo;
	private Date dataIngresso;
	private Categoria categoria;
	
	
	public Pessoa() {
		this(-1, null, null, null, null, null, null, null, -1, null, null, null, false, null, null);
	}


	public Pessoa(int id, String pNome, String uNome, String apelido,
			String telemovel, String telefone, String cP, String rua, int porta,
			String cidade, String numeroGNR, String numeroPosto, boolean ativo,
			Date dataIngresso, Categoria categoria) {
		super();
		this.id = id;
		this.pNome = pNome;
		this.uNome = uNome;
		this.apelido = apelido;
		this.telemovel = telemovel;
		this.telefone = telefone;
		this.cP = cP;
		this.rua = rua;
		this.porta = porta;
		this.cidade = cidade;
		this.numeroGNR = numeroGNR;
		this.numeroPosto = numeroPosto;
		this.ativo = ativo;
		this.dataIngresso = dataIngresso;
		this.categoria = categoria;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getpNome() {
		return pNome;
	}


	public void setpNome(String pNome) {
		this.pNome = pNome;
	}


	public String getuNome() {
		return uNome;
	}


	public void setuNome(String uNome) {
		this.uNome = uNome;
	}


	public String getApelido() {
		return apelido;
	}


	public void setApelido(String apelido) {
		this.apelido = apelido;
	}


	public String getTelemovel() {
		return telemovel;
	}


	public void setTelemovel(String telemovel) {
		this.telemovel = telemovel;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getcP() {
		return cP;
	}


	public void setcP(String cP) {
		this.cP = cP;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public int getPorta() {
		return porta;
	}


	public void setPorta(int porta) {
		this.porta = porta;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getNumeroGNR() {
		return numeroGNR;
	}


	public void setNumeroGNR(String numeroGNR) {
		this.numeroGNR = numeroGNR;
	}


	public String getNumeroPosto() {
		return numeroPosto;
	}


	public void setNumeroPosto(String numeroPosto) {
		this.numeroPosto = numeroPosto;
	}


	public boolean getAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public Date getDataIngresso() {
		return dataIngresso;
	}


	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	
}
