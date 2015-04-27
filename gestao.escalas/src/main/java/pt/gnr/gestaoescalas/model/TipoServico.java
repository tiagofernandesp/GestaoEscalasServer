package pt.gnr.gestaoescalas.model;

public class TipoServico {
	private int id;
	private String nome;
	private String prefixo;
	private int horaInicio;
	private int horaFim;
	private boolean servicoMinimo;
	
	public TipoServico() {
		this(-1,"","",0,0,false);
	}

	public TipoServico(int id, String nome, String prefixo, int horaInicio,
			int horaFim, boolean servicoMinimo) {
		super();
		this.id = id;
		this.nome = nome;
		this.prefixo = prefixo;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.servicoMinimo = servicoMinimo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim;
	}

	public boolean getServicoMinimo() {
		return servicoMinimo;
	}

	public void setServicoMinimo(boolean servicoMinimo) {
		this.servicoMinimo = servicoMinimo;
	}
	
}
