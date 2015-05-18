package pt.gnr.gestaoescalas.model;

public class PessoaEscala {

	private Pessoa pessoa;
	private ServicoPessoa [] escalas;

	public PessoaEscala() {
		this(null, null);
	}

	public PessoaEscala(Pessoa pessoa, ServicoPessoa[] escalas) {
		this.pessoa = pessoa;
		this.escalas = new ServicoPessoa[7];
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public ServicoPessoa[] getEscalas() {
		return escalas;
	}

	public void setEscalas(ServicoPessoa[] escalas) {
		this.escalas = escalas;
	}

	public ServicoPessoa getEscalasById(int id) {
		return escalas[id];
	}

	public void setEscalasById(ServicoPessoa servicoPessoa, int id) {
		this.escalas[id] = servicoPessoa;
	}
}
