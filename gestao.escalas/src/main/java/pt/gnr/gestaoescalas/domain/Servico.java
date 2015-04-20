package pt.gnr.gestaoescalas.domain;

import java.sql.Date;

public class Servico {
	private int id;
	private Date horaInicio;
	private Date horaFim;
	private Date data;
	private String observacao;
	private int numero;
	private String composicao;
	private String titulo;
	private String itenerario;
	private int viatua_Id;
	private int tipoServico_Id;
	private String fRadio;
	
	public Servico() {
		this(-1, null, null, null, null, -1, null, null, null, 0, 0, null);
	}
	
	public Servico(int id, Date horaInicio, Date horaFim, Date data,
			String observacao, int numero, String composicao, String titulo,
			String itenerario, int viatua_Id, int tipoServico_Id, String fRadio) {
		super();
		this.id = id;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.data = data;
		this.observacao = observacao;
		this.numero = numero;
		this.composicao = composicao;
		this.titulo = titulo;
		this.itenerario = itenerario;
		this.viatua_Id = viatua_Id;
		this.fRadio = fRadio;
		this.tipoServico_Id = tipoServico_Id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComposicao() {
		return composicao;
	}
	public void setComposicao(String composicao) {
		this.composicao = composicao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getItenerario() {
		return itenerario;
	}
	public void setItenerario(String itenerario) {
		this.itenerario = itenerario;
	}
	public int getViatua_Id() {
		return viatua_Id;
	}
	public void setViatua_Id(int viatua_Id) {
		this.viatua_Id = viatua_Id;
	}
	public int getTipoServico_Id() {
		return tipoServico_Id;
	}
	public void setTipoServico_Id(int tipoServico_Id) {
		this.tipoServico_Id = tipoServico_Id;
	}

	public String getFRadio() {
		return fRadio;
	}

	public void setFRadio(String fRadio) {
		this.fRadio = fRadio;
	}
	
}
