package model.dao.vacinas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.dao.Banco;
import model.vo.vacinas.EstagioDaPesquisa;
import model.vo.vacinas.Pessoa;
import model.vo.vacinas.ReacaoAVacina;
import model.vo.vacinas.TipoPessoa;
import model.vo.vacinas.Vacina;

public class VacinaDAO {
	
	public boolean atualizar(Vacina vacinaEditada) {
		boolean atualizou = false;
		Connection conn = Banco.getConnection();
		String sql =  " UPDATE VACINA "
					+ " SET PAIS_DE_ORIGEM = ?, ESTAGIO_PESQUISA = ?, DT_INICIO_PESQUISA = ? "
					+ " WHERE ID = ? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		
		try {
			query.setString(1, vacinaEditada.getPaisDeOrigem());
			query.setInt(2, vacinaEditada.getEstagioDaPesquisa().getValor());
			query.setDate(3, Date.valueOf(vacinaEditada.getDataInicioDaPesquisa()));
			query.setInt(4, vacinaEditada.getId());
			
			int linhasAtualizadas = query.executeUpdate();
			atualizou = linhasAtualizadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar vacina."
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
		String sql =  " DELETE FROM VACINA "
					+ " WHERE ID = ? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		try {
			query.setInt(1, id);
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao excluir vacina com id."
					+ "\nCausa: " + e.getMessage());
		} finally {
		//Fechar conexão ao banco
		Banco.closePreparedStatement(query);
		Banco.closeConnection(conn);
		}
		
		return excluiu;
	}
	
	public ArrayList<Vacina> consultarTodasVacinas(){
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<Vacina> listaVacinas = new ArrayList<Vacina>();
		
		String query = " SELECT * FROM VACINA ";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				Vacina vacinaBuscada = new Vacina();
				vacinaBuscada.setId(resultado.getInt("id"));
				vacinaBuscada.setPaisDeOrigem(resultado.getString("pais_de_origem"));
				vacinaBuscada.setEstagioDaPesquisa(EstagioDaPesquisa.estagioDaPesquisaPorValor(resultado.getInt("estagio_pesquisa")));
				vacinaBuscada.setDataInicioDaPesquisa(resultado.getString("dt_inicio_pesquisa"));
				listaVacinas.add(vacinaBuscada);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar vacinas."
					+ "\nCausa: " + e.getMessage());
		} finally {
		//Fechar conexão ao banco
		Banco.closeResultSet(resultado);
		Banco.closeStatement(stmt);
		Banco.closeConnection(conn);
		}		
		return listaVacinas;
	}
	
	public Vacina consultarPorId(int id) {
		Vacina vacinaBuscada = null;
		Connection conn = Banco.getConnection();
		String sql =  " SELECT * FROM VACINA "
					+ " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conn, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				vacinaBuscada = new Vacina();
				vacinaBuscada.setId(resultado.getInt("id"));
				vacinaBuscada.setPaisDeOrigem(resultado.getString("pais_de_origem"));
				vacinaBuscada.setEstagioDaPesquisa(EstagioDaPesquisa.estagioDaPesquisaPorValor(resultado.getInt("estagio_pesquisa")));
				vacinaBuscada.setDataInicioDaPesquisa(resultado.getString("dt_inicio_pesquisa"));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar vacina com id."
					+ "\nCausa: " + e.getMessage());
		} finally {
		//Fechar conexão ao banco
		Banco.closePreparedStatement(query);
		Banco.closeConnection(conn);
		}
		return vacinaBuscada;
	}
	public Vacina inserir(Vacina novaVacina){
		//Conectar ao banco
				Connection conn = Banco.getConnection();
				String sql =  " INSERT INTO VACINA (PAIS_DE_ORIGEM, ESTAGIO_PESQUISA, DT_INICIO_PESQUISA) "
							+ " VALUES (?, ?, ?) ";
				
				PreparedStatement query = Banco.getPreparedStatementWithPk(conn, sql);
				
				//Inserção de valores
				try {
					query.setString(1, novaVacina.getPaisDeOrigem());
					query.setInt(2, novaVacina.getEstagioDaPesquisa().getValor());
					query.setDate(3, Date.valueOf(novaVacina.getDataInicioDaPesquisa()));
					query.execute();
					ResultSet resultado = query.getGeneratedKeys();
					if(resultado.next()) {
						novaVacina.setId(resultado.getInt(1));
					}
				} catch (SQLException e) {
					System.out.println("Erro ao cadastrar vacina."
							+ "\nCausa: " + e.getMessage());
				} finally {
				//Fechar conexão ao banco
				Banco.closePreparedStatement(query);
				Banco.closeConnection(conn);
				}
				return novaVacina;
	}
	
}
