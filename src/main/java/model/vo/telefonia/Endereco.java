package model.vo.telefonia;

public class Endereco {
	
	//Atributos
	private Integer id;
	private String cep;
	private String Bairro;
	private String rua;
	private String cidade;
	private String estado;
	private String numero;



	
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Endereco(Integer id, String cep, String bairro, String rua, String cidade, String estado, String numero) {
		super();
		this.id = id;
		this.cep = cep;
		Bairro = bairro;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
	}


	public Endereco(String cep, String bairro, String rua, String cidade, String estado, String numero) {
		super();
		this.cep = cep;
		Bairro = bairro;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return 	"\nCep = " + cep
				+ "\nRua = " + rua
				+ "\nCidade = " + cidade
				+ "\nEstado = " + estado + "\n";
	}
	
	
}
