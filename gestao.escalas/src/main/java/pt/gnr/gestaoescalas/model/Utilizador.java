package pt.gnr.gestaoescalas.model;

public class Utilizador {
	private int id;
	private String user;
	private String pass;
	private boolean estado;
	private String nome;
	
	public Utilizador() {
		this(-1, null,null,false,null);
	}

	public Utilizador(int id, String user, String pass, boolean estado, String nome) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.estado = estado;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
