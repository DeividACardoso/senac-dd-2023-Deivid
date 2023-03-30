package model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.telefonia.Cliente;

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
	
	public boolean cpfJaUsado(String cpfBuscado) {
		boolean cpfJaUtilizado = false;
		Connection conn = Banco.getConnection();
		String sql =  " SELECT COUNT(*) FROM CLIENTE "
					+ " WHERE CPF = ? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		try {
			query.setString(1, cpfBuscado);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				cpfJaUtilizado = true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo cliente: Cpf já utilizado.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conn);
		}
		return cpfJaUtilizado;
	}
}
