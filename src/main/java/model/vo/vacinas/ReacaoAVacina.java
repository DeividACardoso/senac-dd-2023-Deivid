package model.vo.vacinas;

public enum ReacaoAVacina {
	PESSIMA (1), 
	RUIM (2),
	INDIFERENTE (3),
	BOA (4),
	OTIMA (5);
	
	private int valor;
	
	private ReacaoAVacina(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public static ReacaoAVacina getReacaoAVacinaPorValor(int valor) {
		ReacaoAVacina reacaoAVacina = null;
		for(ReacaoAVacina elemento : ReacaoAVacina.values()) {
			if(elemento.getValor() == valor) {
				reacaoAVacina = elemento;
			}
		}
		return reacaoAVacina;
	}
	
	
}
