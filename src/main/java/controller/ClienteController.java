package controller;

import model.bo.telefonia.ClienteBO;
import model.exception.CampoInvalido;
import model.exception.CpfJaUtilizadoException;
import model.exception.EnderecoInvalidoException;
import model.vo.telefonia.Cliente;


public class ClienteController {
		
	private ClienteBO bo = new ClienteBO();
	
	public Cliente inserir(Cliente novoCliente) throws CpfJaUtilizadoException, EnderecoInvalidoException{
		return bo.inserir(novoCliente);
	}
	
	private void validarCampostObrigatorios(Cliente c) throws CampoInvalido {
		
		if(c.getNome() != null && c.getNome().trim().length() < 2) {
			throw new CampoInvalido("Nome inválido.");
		}
		
		String cpfSemMascara = c.getCpf().replace(".", "");
		cpfSemMascara = c.getCpf().replace("-", "");
		
		if(c.getCpf() != null) {
			if(c.getCpf().length() != 11) {
				throw new CampoInvalido("CPF deve possuir 11 dígitos.");
			}
			
			try {
				Integer.valueOf(c.getCpf());
			} catch (NumberFormatException ex) {
				throw new CampoInvalido("CPF deve possuir somente números.");
			}
		}
	}
}
