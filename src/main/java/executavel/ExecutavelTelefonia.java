package executavel;

import java.util.ArrayList;
import java.util.List;

import model.vo.Cliente;
import model.vo.Endereco;
import model.vo.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] args) {
		
		Endereco endereco1 = new Endereco("88000123", "Mauro Ramos", "Centro", "Florianópolis");
		Cliente pele = new Cliente("Edson Arantes", "11122233344", null, true, endereco1);
		
		List<Telefone> telefonesDoSocrates = new ArrayList<Telefone>();
		Telefone telefone1 = new Telefone("48", "32328888", true, false);
		telefonesDoSocrates.add(new Telefone("48", "12348888", true, true));
		Cliente socrates = new Cliente("Sócrates Brasileiro", "33322211144", telefonesDoSocrates, true, endereco1);
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(pele);
		clientes.add(socrates);
		
		System.out.println("---------- Clientes da firma ----------");
		for(Cliente c : clientes) {
			System.out.println(c.toString());
		}

	}

}
