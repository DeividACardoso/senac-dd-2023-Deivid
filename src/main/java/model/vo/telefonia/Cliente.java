package model.vo.telefonia;

import java.util.List;

public class Cliente {
	
	private Integer id;
	private String nome;
	private String cpf;
	private List<Telefone> telefones;
	private boolean ativo;
	private boolean movel;
	private Endereco endereco;
	

	public Cliente() {

	}
	
	
	public boolean isMovel() {
		return movel;
	}


	public void setMovel(boolean movel) {
		this.movel = movel;
	}


	public Cliente(String nome, String cpf, List<Telefone> telefones, boolean ativo, boolean movel, Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefones = telefones;
		this.ativo = ativo;
		this.movel = movel;
		this.endereco = endereco;
	}


	public Cliente(Integer id, String nome, String cpf, List<Telefone> telefones, boolean ativo, boolean movel,
			Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefones = telefones;
		this.ativo = ativo;
		this.movel = movel;
		this.endereco = endereco;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return "Cliente: Nome = " + nome
				+ "\nCPF = " + cpf
				+ "\nTelefones : " + telefones
				+ "\nAtivo = " + ativo
				+ "\nEndereco : " + endereco;
	}
	
	
	
	
}
