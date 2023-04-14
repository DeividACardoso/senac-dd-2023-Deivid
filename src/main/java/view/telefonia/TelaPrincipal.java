package view.telefonia;

import controller.EnderecoController;
import model.dao.telefonia.EnderecoDAO;
import model.exception.CampoInvalidoException;
import model.vo.telefonia.Endereco;

public class TelaPrincipal {

	public static void main(String[] args) {
		EnderecoController enderecoController = new EnderecoController();
		EnderecoDAO endDAO = new EnderecoDAO();
		Endereco endereco1 = new Endereco("1122233", "Rua dos testes", "1", "Bairro da agonia", "Cidade do pavor", "SC");
		try {
			enderecoController.inserir(endereco1);
		} catch (CampoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(endDAO.consultarTodos());
	}

}
