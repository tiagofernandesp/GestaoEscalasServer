package pt.gnr.gestaoescalas.model;

public class PessoaEscalasGratificado {

	private Pessoa pessoa;
	private GratificadoPessoa [] escalas;

	public PessoaEscalasGratificado() {
		this(null, null);
	}

	public PessoaEscalasGratificado(Pessoa pessoa, ServicoPessoa[] escalas) {
		this.pessoa = pessoa;
		this.escalas = new GratificadoPessoa[7];
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public GratificadoPessoa[] getEscalas() {
		return escalas;
	}

	public void setEscalas(GratificadoPessoa[] escalas) {
		this.escalas = escalas;
	}

	public GratificadoPessoa getEscalasById(int id) {
		return escalas[id];
	}

	public void setEscalasById(GratificadoPessoa gratificadoPessoa, int id) {
		this.escalas[id] = gratificadoPessoa;
	}
}
