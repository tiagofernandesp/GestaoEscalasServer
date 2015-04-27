package pt.gnr.gestaoescalas.model;

import java.sql.Date;

public class Gratificado {
	private int id;
	private Date horaInicio;
	private Date horaFim;
	private String observacao;
	private String local;
	private TipoGratificado tipoGratificado;
	private Viatura viatua;
	private String fRadio;
	
	public Gratificado() {
		this(-1, null,  null, null, null,null,null,null);
	}

	public Gratificado(int id, Date horaInicio, Date horaFim,
			String observacao, String local, TipoGratificado tipoGratificado,
			Viatura viatua, String fRadio) {
		super();
		this.id = id;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.observacao = observacao;
		this.local = local;
		this.tipoGratificado = tipoGratificado;
		this.viatua = viatua;
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

	public Viatura getViatua() {
		return viatua;
	}

	public void setViatua(Viatura viatua) {
		this.viatua = viatua;
	}

	public String getFRadio() {
		return fRadio;
	}

	public void setFRadio(String fRadio) {
		this.fRadio = fRadio;
	}
}