package pt.gnr.gestaoescalas.model;

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
	private Viatura viatua;
	private TipoServico tipoServico;
	private String fRadio;

	public Servico() {
		this(-1, null, null, null, null, -1, null, null, null, null,null, null);
	}

	public Servico(int id, Date horaInicio, Date horaFim, Date data,
			String observacao, int numero, String composicao, String titulo,
			String itenerario, Viatura viatua, TipoServico tipoServico,
			String fRadio) {
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
		this.viatua = viatua;
		this.tipoServico = tipoServico;
		this.fRadio = fRadio;
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

	public Viatura getViatua() {
		return viatua;
	}

	public void setViatua(Viatura viatua) {
		this.viatua = viatua;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getfRadio() {
		return fRadio;
	}

	public void setfRadio(String fRadio) {
		this.fRadio = fRadio;
	}



}
