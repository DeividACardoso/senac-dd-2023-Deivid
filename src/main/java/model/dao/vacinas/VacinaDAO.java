package model.dao.vacinas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.vacinas.Vacina;

public class VacinaDAO {
	
	public Vacina inserir(Vacina novaVacina){
		//Conectar ao banco
				Connection conn = Banco.getConnection();
				String sql =  " INSERT INTO PESSOA (PAIS_DE_ORIGEM, ESTAGIO_PESQUISA, DT_INICIO_PESQUISA, NOME_PESQUISADOR) "
							+ " VALUES (?, ?, ?, ?) ";
				
				PreparedStatement query = Banco.getPreparedStatementWithPk(conn, sql);
				
				//Inserção de valores
				try {
					query.setString(1, novaVacina.getPaisDeOrigem());
					query.setDate(2, Date.valueOf(novaVacina.getDataInicioDaPesquisa()));
					query.setInt(3, novaVacina.getEstagioDaPesquisa().getValor());
					query.setString(4, novaVacina.getNomePesquisadorResponsavel());
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
