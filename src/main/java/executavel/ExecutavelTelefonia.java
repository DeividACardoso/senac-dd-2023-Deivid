package executavel;

import java.util.ArrayList;
import java.util.List;

import model.dao.telefonia.EnderecoDAO;
import model.dao.telefonia.TelefoneDAO;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] args) {
		
		Endereco endereco1 = new Endereco("88000123", "Mauro Ramos", "Trindade", "Florianópolis", "SC", "150");
		EnderecoDAO salvadorDeEnderecos = new EnderecoDAO();
		salvadorDeEnderecos.inserir(endereco1);
		
		if(endereco1.getId() != null) {
			System.out.println("Novo endereço cadastrado.");
		} else {
			System.out.println("Erro ao cadastrar endereço.");
		}
		
		Telefone telefone1 = new Telefone("48", "84700912", false, true);
		TelefoneDAO salvadorDeTelefones = new TelefoneDAO();
		salvadorDeTelefones.inserir(telefone1);
		
		if(telefone1.getId() != null) {
			System.out.println("Novo telefone cadastrado.");
		} else {
			System.out.println("Erro ao cadastrar telefone.");
		}
		
		Cliente socrates = new Cliente(02, "Sócrates Brasileiro", "33322211144", null, true, endereco1);
		Cliente pele = new Cliente(01, "Edson Arantes", "11122233344", null, true, endereco1);
		
		List<Telefone> telefonesDoSocrates = new ArrayList<Telefone>();
		//Telefone telefone1 = new Telefone(01, pele.getId(), "48", "32328888", true, false);
		telefonesDoSocrates.add(new Telefone(02, null, "48", "12348888", true, true));
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(pele);
		clientes.add(socrates);
		
		System.out.println("---------- Clientes da firma ----------");
		for(Cliente c : clientes) {
			System.out.println(c.toString());
		}

	}

}
