package pt.gnr.gestaoescalas.model;

public class HabilitaServico {

	private int Id;
	private Pessoa pessoa = new Pessoa();
	private TipoServico tipoServico = new TipoServico();

	public HabilitaServico() {
		this(-1,null,null);
	}

	public HabilitaServico(int id, Pessoa pessoa, TipoServico tipoServico) {
		super();
		Id = id;
		this.pessoa = pessoa;
		this.tipoServico = tipoServico;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}




}
