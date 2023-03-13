package model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
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
	
}
