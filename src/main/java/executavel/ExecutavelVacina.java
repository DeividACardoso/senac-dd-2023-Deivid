package executavel;

import model.dao.vacinas.PessoaDAO;
import model.dao.vacinas.VacinaDAO;
import model.vo.vacinas.EstagioDaPesquisa;
import model.vo.vacinas.Pessoa;
import model.vo.vacinas.ReacaoAVacina;
import model.vo.vacinas.TipoPessoa;
import model.vo.vacinas.Vacina;

public class ExecutavelVacina {
	
	public static void main(String[] args) {
		
		//Criação/Inserção de pessoa nova
		System.out.println("-=-=-=-=-= Pessoa =-=-=-=-=-");
		Pessoa pessoa1 = new Pessoa(1, "Deivid", "11122233420", "M", "1999-09-05", TipoPessoa.PUBLICO_GERAL, ReacaoAVacina.INDIFERENTE);
		Pessoa pessoa2 = new Pessoa(2, "Wesley", "99988877769", "M", "2004-10-21", TipoPessoa.PUBLICO_GERAL, ReacaoAVacina.INDIFERENTE);
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		pessoaDAO.inserir(pessoa1);
		pessoaDAO.inserir(pessoa2);
		
		//Update de pessoa existente, consulta por Id e consulta de todos
		Pessoa pessoaQueJaExiste = pessoaDAO.consultarPorId(1);
		System.out.println("-=- Antes do Update: " + pessoaQueJaExiste);
		
		pessoaQueJaExiste.setNome("Nicolas");
		boolean atualizou = pessoaDAO.atualizar(pessoaQueJaExiste);
		if(atualizou) {
			System.out.println("Pessoa atualizada");
		} else {
			System.out.println("Pessoa não pôde ser atualizada");
		}
		System.out.println("-=- Depois do update: " + pessoaQueJaExiste);
		
		System.out.println("Consulta da tabela Pessoa: ");
		System.out.println(pessoaDAO.consultarTodasPessoas());
		//Exclusao de Pessoa
		pessoaDAO.excluirPessoa(2);
		System.out.println(pessoaDAO.consultarTodasPessoas());
		
		//Criação/Inserção de Vacina nova
		System.out.println("-=-=-=-=-= Vacina =-=-=-=-=-");
		Vacina vacina1 = new Vacina("Alemanha", EstagioDaPesquisa.INICIAL, "2020-03-06", 3);
		Vacina vacina2 = new Vacina("Canadá", EstagioDaPesquisa.TESTES, "2020-04-16", 2);
		VacinaDAO vacinaDAO = new VacinaDAO();
		
		vacinaDAO.inserir(vacina1);
		vacinaDAO.inserir(vacina2);
		
		//Update de vavina existente, consulta por Id e consulta de todos
		Vacina vacinaQueJaExiste = vacinaDAO.consultarPorId(3);
		System.out.println("-=- Antes do Update: " + vacinaQueJaExiste);
		
		vacinaQueJaExiste.setEstagioDaPesquisa(EstagioDaPesquisa.INICIAL);
		atualizou = vacinaDAO.atualizar(vacinaQueJaExiste);
		if(atualizou) {
			System.out.println("Vacina Atualizada");
		} else {
			System.out.println("Vacina nao pôde ser atualizada");
		}
		System.out.println("-=- Depois do update: " + vacinaQueJaExiste);
		System.out.println("Consulta da tabela Vacina: ");
		System.out.println(vacinaDAO.consultarTodasVacinas());
		//Exclusao de vacina
		vacinaDAO.excluirPessoa(2);
		System.out.println(vacinaDAO.consultarTodasVacinas());
	}
}
