package model.vo.vacinas;

import java.time.LocalDateTime;

public class Vacina {
	
	private String paisDeOrigem;
	private EstagioDaPesquisa estagioDaPesquisa;
	private LocalDateTime dataInicioDaPesquisa;
	private String nomePesquisadorResponsavel;
	public Vacina(String paisDeOrigem, EstagioDaPesquisa estagioDaPesquisa, LocalDateTime dataInicioDaPesquisa,
			String nomePesquisadorResponsavel) {
		super();
		this.paisDeOrigem = paisDeOrigem;
		this.estagioDaPesquisa = estagioDaPesquisa;
		this.dataInicioDaPesquisa = dataInicioDaPesquisa;
		this.nomePesquisadorResponsavel = nomePesquisadorResponsavel;
	}
	public Vacina() {
		super();
		// TODO Auto-generated constructor stub
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
	public LocalDateTime getDataInicioDaPesquisa() {
		return dataInicioDaPesquisa;
	}
	public void setDataInicioDaPesquisa(LocalDateTime dataInicioDaPesquisa) {
		this.dataInicioDaPesquisa = dataInicioDaPesquisa;
	}
	public String getNomePesquisadorResponsavel() {
		return nomePesquisadorResponsavel;
	}
	public void setNomePesquisadorResponsavel(String nomePesquisadorResponsavel) {
		this.nomePesquisadorResponsavel = nomePesquisadorResponsavel;
	}
	
	
}
