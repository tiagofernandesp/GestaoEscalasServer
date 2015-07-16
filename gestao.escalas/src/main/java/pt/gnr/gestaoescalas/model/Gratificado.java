package pt.gnr.gestaoescalas.model;

import java.sql.Date;
import java.sql.Time;

public class Gratificado {
	private int id;
	private Time horaInicio;
	private Time horaFim;
	private String observacao;
	private String local;
	private TipoGratificado tipoGratificado;
	private Viatura viatura;
	private String fRadio;
	private Date dataInicio;
	private Date dataFim;

	public Gratificado() {
		this(-1, null,  null, null, null,null,null,null,null,null);
	}

	public Gratificado(int id, Time horaInicio, Time horaFim,
			String observacao, String local, TipoGratificado tipoGratificado,
			Viatura viatura, String fRadio, Date dataInicio, Date dataFim) {
		super();
		this.id = id;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.observacao = observacao;
		this.local = local;
		this.tipoGratificado = tipoGratificado;
		this.viatura = viatura;
		this.fRadio = fRadio;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public TipoGratificado getTipoGratificado() {
		return tipoGratificado;
	}

	public void setTipoGratificado(TipoGratificado tipoGratificado) {
		this.tipoGratificado = tipoGratificado;
	}

	public Viatura getViatura() {
		return viatura;
	}

	public void setViatura(Viatura viatura) {
		this.viatura = viatura;
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