package model.vo.vacinas;

public class Vacina {
	
	private Integer id;
	private String paisDeOrigem;
	private EstagioDaPesquisa estagioDaPesquisa;
	private String dataInicioDaPesquisa;
	private String nomePesquisadorResponsavel;
	
	public Vacina(Integer id, String paisDeOrigem, EstagioDaPesquisa estagioDaPesquisa, String dataInicioDaPesquisa,
			String nomePesquisadorResponsavel) {
		super();
		this.id = id;
		this.paisDeOrigem = paisDeOrigem;
		this.estagioDaPesquisa = estagioDaPesquisa;
		this.dataInicioDaPesquisa = dataInicioDaPesquisa;
		this.nomePesquisadorResponsavel = nomePesquisadorResponsavel;
	}

	public Vacina(String paisDeOrigem, EstagioDaPesquisa estagioDaPesquisa, String dataInicioDaPesquisa,
			String nomePesquisadorResponsavel) {
		super();
		this.paisDeOrigem = paisDeOrigem;
		this.estagioDaPesquisa = estagioDaPesquisa;
		this.dataInicioDaPesquisa = dataInicioDaPesquisa;
		this.nomePesquisadorResponsavel = nomePesquisadorResponsavel;
	}

	public Vacina(String paisDeOrigem, String dataInicioDaPesquisa, String nomePesquisadorResponsavel) {
		super();
		this.paisDeOrigem = paisDeOrigem;
		this.dataInicioDaPesquisa = dataInicioDaPesquisa;
		this.nomePesquisadorResponsavel = nomePesquisadorResponsavel;
	}

	public Vacina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaisDeOrigem() {
		return paisDeOrigem;
	}

	public void setPaisDeOrigem(String paisDeOrigem) {
		this.paisDeOrigem = paisDeOrigem;
	}

	public EstagioDaPesquisa getEstagioDaPesquisa() {
		return estagioDaPesquisa;
	}

	public void setEstagioDaPesquisa(EstagioDaPesquisa estagioDaPesquisa) {
		this.estagioDaPesquisa = estagioDaPesquisa;
	}

	public String getDataInicioDaPesquisa() {
		return dataInicioDaPesquisa;
	}

	public void setDataInicioDaPesquisa(String dataInicioDaPesquisa) {
		this.dataInicioDaPesquisa = dataInicioDaPesquisa;
	}

	public String getNomePesquisadorResponsavel() {
		return nomePesquisadorResponsavel;
	}

	public void setNomePesquisadorResponsavel(String nomePesquisadorResponsavel) {
		this.nomePesquisadorResponsavel = nomePesquisadorResponsavel;
	}
	
	
	
	
}
