package model.dao.vacinas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import model.dao.Banco;
import model.vo.vacinas.Pessoa;
import model.vo.vacinas.ReacaoAVacina;
import model.vo.vacinas.TipoPessoa;

public class PessoaDAO {
	
	public boolean atualizar(Pessoa pessoaEditada) {
		boolean atualizou = false;
		Connection conn = Banco.getConnection();
		String sql =  " UPDATE PESSOA "
					+ " SET NOME = ?, CPF = ?, DATA_NASCIMENTO = ?, SEXO = ?, TIPO_PESSOA = ?, REACAO_VACINA = ? "
					+ " WHERE ID = ? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		
		try {
			query.setString(1, pessoaEditada.getNome());
			query.setString(2, pessoaEditada.getCpf());
			query.setDate(3, Date.valueOf(pessoaEditada.getDataNascimento()));
			query.setString(4, pessoaEditada.getSexo());
			query.setInt(5, pessoaEditada.getTipoPessoa().getValor());
			query.setInt(6, pessoaEditada.getReacaoAVacina().getValor());
			query.setInt(7, pessoaEditada.getId());
			
			int linhasAtualizadas = query.executeUpdate();
			atualizou = linhasAtualizadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar pessoa."
					+ "\nCausa: " + e.getMessage());
		} finally {
		//Fechar conexão ao banco
		Banco.closePreparedStatement(query);
		Banco.closeConnection(conn);
		}
		
		return atualizou;
	}
	
	public boolean excluirPessoa(int id) {
		boolean excluiu = false;
		
		Connection conn = Banco.getConnection();
		String sql =  " DELETE FROM PESSOA "
					+ " WHERE ID = ? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		try {
			query.setInt(1, id);
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao excluir pessoa com id."
					+ "\nCausa: " + e.getMessage());
		} finally {
		//Fechar conexão ao banco
		Banco.closePreparedStatement(query);
		Banco.closeConnection(conn);
		}
		
		return excluiu;
	}
	
	public ArrayList<Pessoa> consultarTodasPessoas(){
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		String query = " SELECT * FROM PESSOA ";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				Pessoa pessoaBuscada = new Pessoa();
				pessoaBuscada.setId(resultado.getInt("id"));
				pessoaBuscada.setNome(resultado.getString("nome"));
				pessoaBuscada.setCpf(resultado.getString("cpf"));
				pessoaBuscada.setDataNascimento(resultado.getString("data_nascimento"));
				pessoaBuscada.setSexo(resultado.getString("sexo"));
				pessoaBuscada.setTipoPessoa(TipoPessoa.getTipoPessoaPorValor(resultado.getInt("tipo_pessoa")));
				pessoaBuscada.setReacaoAVacina(ReacaoAVacina.getReacaoAVacinaPorValor(resultado.getInt("reacao_vacina")));
				listaPessoas.add(pessoaBuscada);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar pessoas."
					+ "\nCausa: " + e.getMessage());
		} finally {
		//Fechar conexão ao banco
		Banco.closeResultSet(resultado);
		Banco.closeStatement(stmt);
		Banco.closeConnection(conn);
		}
		
		
		return listaPessoas;
	}
	
	public Pessoa consultarPorId(int id) {
		Pessoa pessoaBuscada = null;
		Connection conn = Banco.getConnection();
		String sql =  " SELECT * FROM PESSOA "
					+ " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				pessoaBuscada = new Pessoa();
				pessoaBuscada.setId(resultado.getInt("id"));
				pessoaBuscada.setNome(resultado.getString("nome"));
				pessoaBuscada.setCpf(resultado.getString("cpf"));
				pessoaBuscada.setDataNascimento(resultado.getString("data_nascimento"));
				pessoaBuscada.setSexo(resultado.getString("sexo"));
				pessoaBuscada.setTipoPessoa(TipoPessoa.getTipoPessoaPorValor(resultado.getInt("tipo_pessoa")));
				pessoaBuscada.setReacaoAVacina(ReacaoAVacina.getReacaoAVacinaPorValor(resultado.getInt("reacao_vacina")));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar pessoa com id."
					+ "\nCausa: " + e.getMessage());
		} finally {
		//Fechar conexão ao banco
		Banco.closePreparedStatement(query);
		Banco.closeConnection(conn);
		}
		return pessoaBuscada;
	}
	
	public Pessoa inserir(Pessoa novaPessoa){
		//Conectar ao banco
		Connection conn = Banco.getConnection();
		String sql =  " INSERT INTO PESSOA (NOME, DATA_NASCIMENTO, SEXO, CPF, TIPO_PESSOA, REACAO_VACINA) "
					+ " VALUES (?, ?, ?, ?, ?, ?) ";
		
		PreparedStatement query = Banco.getPreparedStatementWithPk(conn, sql);
		//Inserção de valores
		try {
			query.setString(1, novaPessoa.getNome());
			query.setDate(2, Date.valueOf(novaPessoa.getDataNascimento()));
			query.setString(3, novaPessoa.getSexo());
			query.setString(4, novaPessoa.getCpf());
			query.setInt(5, novaPessoa.getTipoPessoa().getValor());
			query.setInt(6, novaPessoa.getReacaoAVacina().getValor());
			query.execute();
			ResultSet resultado = query.getGeneratedKeys();
			if(resultado.next()) {
				novaPessoa.setId(resultado.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar pessoa."
					+ "\nCausa: " + e.getMessage());
		} finally {
		//Fechar conexão ao banco
		Banco.closePreparedStatement(query);
		Banco.closeConnection(conn);
		}
		return novaPessoa;
	}
	
	
}
