package model.vo.vacinas;

import java.sql.Date;
import java.time.LocalDateTime;

public class Pessoa {
	
	private Integer id;
	private String nome;
	private String cpf;
	private String sexo;
	private String dataNascimento;
	private TipoPessoa tipoPessoa;
	private ReacaoAVacina reacaoAVacina;
	
	//Construtores
	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pessoa(Integer id, String nome, String cpf, String sexo, String dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}
	public Pessoa(String nome, String cpf, String sexo, String dataNascimento, TipoPessoa tipoPessoa,
			ReacaoAVacina reacaoAVacina) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.tipoPessoa = tipoPessoa;
		this.reacaoAVacina = reacaoAVacina;
	}
	public Pessoa(Integer id, String nome, String cpf, String sexo, String dataNascimento, TipoPessoa tipoPessoa,
			ReacaoAVacina reacaoAVacina) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.tipoPessoa = tipoPessoa;
		this.reacaoAVacina = reacaoAVacina;
	}
	//Getters e Setters
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	//Métodos
	public String toString() {
		return 	  "\nNome: " + nome
				+ "\nCPF: " + cpf
				+ "\nTipo de Pessoa: " + tipoPessoa
				+ "\nReação a vacina: " + reacaoAVacina
				+ "\nData Nascimento: " + dataNascimento;
	}
}
