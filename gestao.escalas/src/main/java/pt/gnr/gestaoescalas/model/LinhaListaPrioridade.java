package pt.gnr.gestaoescalas.model;

import java.sql.Date;

public class LinhaListaPrioridade {
	private Date date;
	private String apelido;

	public LinhaListaPrioridade()
	{
		this(null,null);
	}

	public LinhaListaPrioridade(Date date, String apelido) {
		super();
		this.date = date;
		this.apelido = apelido;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}


}
