package executavel;

import javax.swing.JOptionPane;

import model.bo.telefonia.ClienteBO;
import model.dao.telefonia.EnderecoDAO;
import model.dao.telefonia.TelefoneDAO;
import model.exception.CpfJaUtilizadoException;
import model.exception.EnderecoInvalidoException;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] args) {
		
		ClienteBO clienteBO = new ClienteBO();
		
		Cliente novoCliente = new Cliente();
		novoCliente.setNome("Mario Jorge");
		novoCliente.setCpf("10122233311");
		novoCliente.setAtivo(true);

		try {
			clienteBO.inserir(novoCliente);
		} catch (CpfJaUtilizadoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (EnderecoInvalidoException e) {
			JOptionPane.showMessageDialog(null, "Erros acontecem. Causa: " 
						+ e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		//		TelefoneDAO dbaTelefone = new TelefoneDAO();
//		
//		if(dbaTelefone.excluir(3)) {
//			System.out.println("Telefone excluido.");
//		} else {
//			System.out.println("Telefone não pode ser excluido");
//		}
//		
//		System.out.println("------------ Clientes da firma ------------");
//		for(Cliente c: clientes) {
//			System.out.println(c.toString());
//		}
//		
//		for(int i=0; i < clientes.size(); i++) {
//			Cliente c = clientes.get(i);
//			System.out.println(c.toString());
//		}
		
	}
}