package pt.gnr.gestaoescalas.model;

public class PessoaEscala {

	private Pessoa pessoa;
	private ServicoPessoa day1;
	private ServicoPessoa day2;
	private ServicoPessoa day3;
	private ServicoPessoa day4;
	private ServicoPessoa day5;
	private ServicoPessoa day6;
	private ServicoPessoa day7;


	public PessoaEscala() {
		this(null, null, null, null, null, null, null, null);
	}


	public PessoaEscala(Pessoa pessoa, ServicoPessoa day1, ServicoPessoa day2,
			ServicoPessoa day3, ServicoPessoa day4, ServicoPessoa day5,
			ServicoPessoa day6, ServicoPessoa day7) {
		super();
		this.pessoa = pessoa;
		this.day1 = day1;
		this.day2 = day2;
		this.day3 = day3;
		this.day4 = day4;
		this.day5 = day5;
		this.day6 = day6;
		this.day7 = day7;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public ServicoPessoa getDay1() {
		return day1;
	}


	public void setDay1(ServicoPessoa day1) {
		this.day1 = day1;
	}


	public ServicoPessoa getDay2() {
		return day2;
	}


	public void setDay2(ServicoPessoa day2) {
		this.day2 = day2;
	}


	public ServicoPessoa getDay3() {
		return day3;
	}


	public void setDay3(ServicoPessoa day3) {
		this.day3 = day3;
	}


	public ServicoPessoa getDay4() {
		return day4;
	}


	public void setDay4(ServicoPessoa day4) {
		this.day4 = day4;
	}


	public ServicoPessoa getDay5() {
		return day5;
	}


	public void setDay5(ServicoPessoa day5) {
		this.day5 = day5;
	}


	public ServicoPessoa getDay6() {
		return day6;
	}


	public void setDay6(ServicoPessoa day6) {
		this.day6 = day6;
	}


	public ServicoPessoa getDay7() {
		return day7;
	}


	public void setDay7(ServicoPessoa day7) {
		this.day7 = day7;
	}


}
