package model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.Banco;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;

public class ClienteDAO {

	public Cliente inserir(Cliente novoCliente) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO CLIENTE(NOME, CPF, ID_ENDERECO, ATIVO, MOVEL) "
				+ " VALUES (?,?,?,?) ";
		PreparedStatement stmt = Banco.getPreparedStatementWithPk(conexao, sql);
		try {
			stmt.setString(1, novoCliente.getNome());
			stmt.setString(2, novoCliente.getCpf());
			stmt.setInt(3, novoCliente.getEndereco().getId());
			stmt.setBoolean(4, novoCliente.isAtivo());
			//stmt.setBoolean(5, novoCliente.isMovel());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				int idGerado = rs.getInt(1);
				novoCliente.setId(idGerado);

				if (!novoCliente.getTelefones().isEmpty()) {
					TelefoneDAO telefoneDAO = new TelefoneDAO();
					telefoneDAO.ativarTelefones(novoCliente, novoCliente.getTelefones());
				}
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo cliente.");
			System.out.println("Erro: " + e.getMessage());
		}
		return novoCliente;
	}
	
	public boolean cpfJaUtilizado(String cpfBuscado) {
		boolean cpfJaUtilizado = false;
		Connection conexao = Banco.getConnection();
		String sql = " select count(*) from cliente "
				   + " where cpf = ? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setString(1, cpfBuscado);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				cpfJaUtilizado = resultado.getInt(1) > 0;
			}
		}catch (Exception e) {
			System.out.println("Erro ao verificar uso do CPF " + cpfBuscado 
					+ "\n Causa:" + e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return cpfJaUtilizado;
	}

	public boolean clienteTemTelefoneAssociado(int id) {
		ClienteDAO cliente= new ClienteDAO();
		Cliente clienteBuscado = new Cliente(); 
		
		clienteBuscado = cliente.consultarPorId(id);
		
		boolean possuiTelefone = false;
		
		if(!clienteBuscado.getTelefones().isEmpty()) {
			possuiTelefone = true;
		}
		
		return possuiTelefone;
	}

	public boolean excluir(int id) {
		return false;
	}
	
	public Cliente consultarPorId(int id) {
		Cliente clienteBuscado = null;
		Connection conexao = Banco.getConnection();
		String sql = " select * from cliente "
				   + " where id = ? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				clienteBuscado = montarClienteComResultadoDoBanco(resultado);
			}
			
		}catch (Exception e) {
			System.out.println("Erro ao buscar cliente com id: " + id 
					+ "\n Causa:" + e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return clienteBuscado;
	}
	
	public List<Cliente> consultarTodos() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Connection conexao = Banco.getConnection();
		String sql = " select * from cliente ";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				Cliente clienteBuscado = montarClienteComResultadoDoBanco(resultado);
				clientes.add(clienteBuscado);
			}
			
		}catch (Exception e) {
			System.out.println("Erro ao buscar todos os clientes. \n Causa:" + e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return clientes;
	}
	
	private Cliente montarClienteComResultadoDoBanco(ResultSet resultado) throws SQLException {
		Cliente clienteBuscado = new Cliente();
		clienteBuscado.setId(resultado.getInt("id"));
		clienteBuscado.setNome(resultado.getString("nome"));
		clienteBuscado.setCpf(resultado.getString("cpf"));
		clienteBuscado.setAtivo(resultado.getBoolean("ativo"));
		
		int idEnderecoDoCliente = resultado.getInt("id_endereco");
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.consultarPorId(idEnderecoDoCliente);
		clienteBuscado.setEndereco(endereco);
		
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		clienteBuscado.setTelefones(telefoneDAO.consultarPorIdCliente(clienteBuscado.getId()));
		
		return clienteBuscado;
	}
}
