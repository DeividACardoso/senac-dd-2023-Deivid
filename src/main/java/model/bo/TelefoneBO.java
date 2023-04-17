package model.bo;

import java.util.List;

import model.dao.telefonia.TelefoneDAO;
import model.exception.TelefoneJaUtilizadoException;
import model.vo.telefonia.Telefone;

public class TelefoneBO {

	private TelefoneDAO dao = new TelefoneDAO();
	
	public Telefone inserir(Telefone novoTelefone) throws TelefoneJaUtilizadoException {
		novoTelefone.setAtivo(novoTelefone.getIdCliente() != null && novoTelefone.isAtivo());
		
		if(dao.telefoneExiste(novoTelefone.getDdd(), novoTelefone.getNumero())) {
			throw new TelefoneJaUtilizadoException(null);
		}
		return dao.inserir(novoTelefone);
	}
	
	public boolean atualizar(Telefone telefoneAlterado) {
		telefoneAlterado.setAtivo(telefoneAlterado.getIdCliente() != null);

		return dao.atualizar(telefoneAlterado);
	}
	
	public boolean excluir(int id) {
		return dao.excluir(id);
	}
	
	public Telefone consultarPorId(int id) {
		return dao.consultarPorId(id);
	}
	
	public List<Telefone> consultarTodos() {
		return dao.consultarTodos();
	}
}