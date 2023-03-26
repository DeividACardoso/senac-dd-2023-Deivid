package model.vo.vacinas;

public enum EstagioDaPesquisa {
	
	INICIAL (1),
	TESTES (2),
	APLICACAO_EM_MASSA (3);
	
	private int valor;
	
	private EstagioDaPesquisa(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public static EstagioDaPesquisa EstagioDaPesquisaPorValor(int valor) {
		EstagioDaPesquisa estagioDaPesquisa = null;
		for(EstagioDaPesquisa elemento : EstagioDaPesquisa.values()) {
			if(elemento.getValor() == valor) {
				estagioDaPesquisa = elemento;
			}
		}
		return estagioDaPesquisa;
	}
	
}
