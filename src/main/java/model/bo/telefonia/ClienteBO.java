package model.bo.telefonia;

import java.util.List;

import model.dao.telefonia.ClienteDAO;
import model.dao.telefonia.TelefoneDAO;
import model.exception.ClienteComTelefoneException;
import model.exception.CpfJaUtilizadoException;
import model.exception.EnderecoInvalidoException;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Telefone;

public class ClienteBO {
	
	private ClienteDAO dao = new ClienteDAO();
	
	public Cliente inserir(Cliente novoCliente) throws CpfJaUtilizadoException, EnderecoInvalidoException{
		
		if(dao.cpfJaUtilizado(novoCliente.getCpf())) {
			//Caso cpf já utilizado -> Não salvar e devolver exceção
			throw new CpfJaUtilizadoException("CPF informado já foi utilizado");
		}
		
		if(novoCliente.getEndereco() == null || novoCliente.getEndereco().getId() == null) {
			throw new EnderecoInvalidoException("Endereço não informado");
		}
		return dao.inserir(novoCliente);
	}

	/**
	 * Não deixar excluir cliente que possua telefone associado
	 * Criar exceção ClienteComTelefoneException
	 * Caso Cliente possua telefone(s): lançar ClienteComTelefoneException
	 * Caso contrário: chamar dao.excluir(id)
	 * @param id
	 * @return se excluiu ou não o cliente
	 * @throws ClienteComTelefoneException 
	 */
	public boolean excluir(int id) throws ClienteComTelefoneException {
		
		Cliente clienteBuscado = dao.consultarPorId(id);
		
		if(!clienteBuscado.getTelefones().isEmpty()) { 
			throw new ClienteComTelefoneException("Cliente já possui telefone");
		}
		
		return dao.excluir(id);
	}
	public boolean excluir_OPCAO2(int id) throws ClienteComTelefoneException{
		
		TelefoneDAO telDAO = new TelefoneDAO();
		 List<Telefone> telefonesDoCliente = telDAO.consultarPorIdCliente(id);
		 
		 if(telefonesDoCliente != null && !telefonesDoCliente.isEmpty()) {
			 throw new ClienteComTelefoneException("Cliente possui telefones.");
		 }
		
		return dao.excluir(id);
	}
}
