package model.vo.vacinas;

public class Vacina {
	
	private Integer id;
	private String paisDeOrigem;
	private EstagioDaPesquisa estagioDaPesquisa;
	private String dataInicioDaPesquisa;
	private int idPesquisadorResponsavel;
	
	public Vacina(Integer id, String paisDeOrigem, EstagioDaPesquisa estagioDaPesquisa, String dataInicioDaPesquisa,
			int idPesquisadorResponsavel) {
		super();
		this.id = id;
		this.paisDeOrigem = paisDeOrigem;
		this.estagioDaPesquisa = estagioDaPesquisa;
		this.dataInicioDaPesquisa = dataInicioDaPesquisa;
		this.idPesquisadorResponsavel = idPesquisadorResponsavel;
	}

	public Vacina(String paisDeOrigem, EstagioDaPesquisa estagioDaPesquisa, String dataInicioDaPesquisa,
			int idPesquisadorResponsavel) {
		super();
		this.paisDeOrigem = paisDeOrigem;
		this.estagioDaPesquisa = estagioDaPesquisa;
		this.dataInicioDaPesquisa = dataInicioDaPesquisa;
		this.idPesquisadorResponsavel = idPesquisadorResponsavel;
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

	public int getIdPesquisadorResponsavel() {
		return idPesquisadorResponsavel;
	}

	public void setIdPesquisadorResponsavel(int idPesquisadorResponsavel) {
		this.idPesquisadorResponsavel = idPesquisadorResponsavel;
	}
	
	public String toString() {
		return 	  "\nPaís de Origem: " + paisDeOrigem
				+ "\nEstágio da pesquisa: " + estagioDaPesquisa
				+ "\nData inicio da Pesquisa: " + dataInicioDaPesquisa;
	}
	
	
}
