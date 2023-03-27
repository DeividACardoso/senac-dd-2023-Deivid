package executavel;

import model.dao.vacinas.PessoaDAO;
import model.vo.vacinas.Pessoa;
import model.vo.vacinas.ReacaoAVacina;
import model.vo.vacinas.TipoPessoa;

public class ExecutavelVacina {
	
	public static void main(String[] args) {
		
		Pessoa pessoa1 = new Pessoa("Deivid", "1112223334", "M", "1999-09-05", TipoPessoa.PUBLICO_GERAL, ReacaoAVacina.INDIFERENTE);
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Pessoa pessoa2 = pessoaDAO.consultarPorId(1);
		
		//System.out.println(pessoa2);
		
		System.out.println(pessoaDAO.consultarTodasPessoas());
		
		if(pessoaDAO.excluirPessoa(2)) {
			System.out.println("Pessoa excluida com sucesso.");
		} else {
			System.out.println("Pessoa não pode ser excluida.");
		}
	}
}
