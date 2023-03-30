package model.bo.telefonia;

import model.dao.telefonia.ClienteDAO;
import model.exception.CpfJaUtilizadoException;
import model.exception.EnderecoInvalidoException;
import model.vo.telefonia.Cliente;

public class ClienteBO {
	
	private ClienteDAO dao;
	
	public Cliente inserir(Cliente novoCliente) throws CpfJaUtilizadoException, EnderecoInvalidoException{
		
		if(dao.cpfJaUsado(novoCliente.getCpf())) {
			//Caso cpf já utilizado -> Não salvar e devolver exceção
			throw new CpfJaUtilizadoException("CPF informado já foi utilizado");
		}
		
		if(novoCliente.getEndereco() == null || novoCliente.getEndereco().getId() == null) {
			throw new EnderecoInvalidoException("Endereço não informado");
		}
		return dao.inserir(novoCliente);
	}
}
