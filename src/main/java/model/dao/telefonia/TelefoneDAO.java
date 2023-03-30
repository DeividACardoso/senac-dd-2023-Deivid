package model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.dao.Banco;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

public class TelefoneDAO {

	//INSERT
	//INSERT INTO TELEFONE (DDD, NUMERO, ATIVO, MOVEL)
	//VALUES ('', '', '', '', '');
	
	public Telefone inserir(Telefone novoTelefone) {
		
		//Conectar ao Banco
		Connection conexao = Banco.getConnection();
		String sql =  " INSERT INTO TELEFONE (DDD, NUMERO, ATIVO, MOVEL) "
					+ "	VALUES (?, ?, ?, ?) ";
		
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		//Executar o insert
		try {
			query.setString(1, novoTelefone.getDdd());
			query.setString(2, novoTelefone.getNumero());
			query.setBoolean(3, novoTelefone.isAtivo());
			query.setBoolean(4, novoTelefone.isMovel());
			query.execute();
		//Preencher o id gerado no banco no objeto
			ResultSet resultado = query.getGeneratedKeys();
			if(resultado.next()) {
				novoTelefone.setId(resultado.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao inserir endereço."
					+ "\nCausa: " + e.getMessage());
		} finally {
			//Fechar a conexão
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return novoTelefone;
	}
	
	public boolean atualizar(Telefone telefoneEditado) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE TELEFONE "
				   + " SET DDD = ?, NUMERO = ?, ATIVO= ?, "
				   + "     MOVEL = ? "
				   + " WHERE ID = ? " ;
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setString(1, telefoneEditado.getDdd());
			query.setString(2, telefoneEditado.getNumero());
			query.setBoolean(3, telefoneEditado.isAtivo());
			query.setBoolean(4, telefoneEditado.isMovel());
			query.setInt(5, telefoneEditado.getId());
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			atualizou = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar telefone. "
					+ "\n Causa: " + e.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		
		return atualizou;
	}
	
	public Telefone consultarPorId(int id) {
		Telefone telefoneConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM TELEFONE "
				    + " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				telefoneConsultado = new Telefone();
				telefoneConsultado.setIdCliente(resultado.getInt("id"));
				telefoneConsultado.setDdd(resultado.getString("ddd"));
				telefoneConsultado.setNumero(resultado.getString("numero"));
				telefoneConsultado.setAtivo(resultado.getBoolean("ativo"));
				telefoneConsultado.setMovel(resultado.getBoolean("movel"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar telefone com id: + " + id 
					+ "\n Causa: " + e.getMessage());	
		}
		
		
		return telefoneConsultado;
	}
	
	public boolean excluir(int id) {
		boolean excluiu = false;
		
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM TELEFONE "
				   + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao excluir endereço. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return excluiu;
	}

	public void ativarTelefones(Cliente novoCliente, List<Telefone> telefones) {
		// TODO Auto-generated method stub
		
	}
}
