package pt.gnr.gestaoescalas.model;

import java.sql.Date;
import java.sql.Time;

public class Servico {
	private int id;
	private Time horaInicio;
	private Time horaFim;
	private Date data;
	private String observacao;
	private int numero;
	private String composicao;
	private String titulo;
	private String itenerario;
	private Viatura viatura;
	private TipoServico tipoServico;
	private String fRadio;
	private Date dataInicio;
	private Date dataFim;

	public Servico() {
		this(-1, null, null, null, null, -1, null, null, null, null,null, null,null,null);
	}

	public Servico(int id, Time horaInicio, Time horaFim, Date data,
			String observacao, int numero, String composicao, String titulo,
			String itenerario, Viatura viatura, TipoServico tipoServico,
			String fRadio, Date dataInicio,Date dataFim) {
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
		this.viatura = viatura;
		this.tipoServico = tipoServico;
		this.fRadio = fRadio;
		this.dataInicio= dataInicio;
		this.dataFim=dataFim;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Time horaFim) {
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

	public Viatura getViatura() {
		return viatura;
	}

	public void setViatura(Viatura viatura) {
		this.viatura = viatura;
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}



}
