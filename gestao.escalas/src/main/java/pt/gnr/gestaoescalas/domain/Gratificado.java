package pt.gnr.gestaoescalas.domain;

import java.sql.Date;

public class Gratificado {
	private int id;
	private Date horaInicio;
	private Date horaFim;
	private String observacao;
	private String local;
	private int tipoGratificado_Id;
	private int viatua_Id;
	private String fRadio;
	
	public Gratificado() {
		this(-1, null,  null, null, null,0,0,null);
	}
	
	public Gratificado(int id, Date horaInicio, Date horaFim,
			String observacao, String local, int tipoGratificado_Id,
			int viatua_Id, String fRadio) {
		super();
		this.id = id;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.observacao = observacao;
		this.local = local;
		this.tipoGratificado_Id = tipoGratificado_Id;
		this.viatua_Id = viatua_Id;
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

	public void setLocal(String localString) {
		this.local = localString;
	}

	public int getTipoGratificado_Id() {
		return tipoGratificado_Id;
	}

	public void setTipoGratificado_Id(int tipoGratificado_Id) {
		this.tipoGratificado_Id = tipoGratificado_Id;
	}

	public int getViatua_Id() {
		return viatua_Id;
	}

	public void setViatua_Id(int viatua_Id) {
		this.viatua_Id = viatua_Id;
	}

	public String getFRadio() {
		return fRadio;
	}

	public void setFRadio(String fRadio) {
		this.fRadio = fRadio;
	}

	
}
