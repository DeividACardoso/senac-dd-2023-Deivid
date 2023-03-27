package model.vo.vacinas;

public class Pessoa {
	
	private Integer id;
	private String nome;
	private String cpf;
	private TipoPessoa tipoPessoa;
	private ReacaoAVacina reacaoAVacina;
	
	public Pessoa(int id, String nome, String cpf, TipoPessoa tipoPessoa, ReacaoAVacina reacaoAVacina) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.tipoPessoa = tipoPessoa;
		this.reacaoAVacina = reacaoAVacina;
	}
	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public ReacaoAVacina getReacaoAVacina() {
		return reacaoAVacina;
	}
	public void setReacaoAVacina(ReacaoAVacina reacaoAVacina) {
		this.reacaoAVacina = reacaoAVacina;
	}
	
	public String toString() {
		return 	  "Nome: " + nome
				+ "CPF: " + cpf
				+ "Tipo de Pessoa: " + tipoPessoa
				+ "Reação a vacina: " + reacaoAVacina;
	}
}
