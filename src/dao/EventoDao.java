package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Empresa;
import model.Evento;

import service.EmpresaService;

/**
 * Data Acess Object para o Evento
 * 
 * @author Maicon Souza e Davi Fonseca
 * @version
 * @since 
 */
public class EventoDao {
	
	/**
	 * Criacao de um novo evento
	 * @param evento
	 * @throws SQLException
	 */
	public Integer inserirEvento(Evento evento) throws SQLException {
		String sqlInsert = "INSERT INTO evento"
				+ "(data_hora, localizacao, descricao, duracao, quantidade_vagas, palestrante, titulo, fk_empresa_cnpj)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		
		try(Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setTimestamp(1,  new java.sql.Timestamp(evento.getDataHora().getTime()));
			pst.setString(2, evento.getLocalizacao());
			pst.setString(3, evento.getDescricao());
			pst.setInt(4, evento.getDuracao());
			pst.setInt(5, evento.getQuantidadeVagas());
			pst.setString(6, evento.getPalestrante());
			pst.setString(7, evento.getTitulo());
			pst.setString(8, evento.getEmpresa().getCnpj());
			
			pst.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conectar.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					evento.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return evento.getId();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Consultar evento usando um id
	 * @param id
	 * @return
	 */
	public Evento consultarEvento(int id) {
		String sqlSelect = "SELECT * FROM evento WHERE id = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlSelect)) {
			pst.setInt(1, id);
			
			ResultSet result = pst.executeQuery();
			
			if (result.next()){
				Evento evento = new Evento();
				
				evento.setId(id);
				evento.setDataHora(result.getDate("data_hora"));
				evento.setLocalizacao(result.getString("localizacao"));
				evento.setDescricao(result.getString("descricao"));
				evento.setDuracao(result.getInt("duracao"));
				evento.setQuantidadeVagas(result.getInt("quantidade_vagas"));
				evento.setPalestrante(result.getString("palestrante"));
				evento.setTitulo(result.getString("titulo"));
				
				EmpresaService es = new EmpresaService();
				Empresa empresa = new Empresa();
				
				empresa = es.carregarCpf(result.getString("fk_empresa_cnpj"));
				
				evento.setEmpresa(empresa);
				
				return evento;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Listagem de eventos utilizando um titulo
	 * @param titulo
	 * @return
	 */
	public ArrayList<Evento> listarEventos(String titulo) {
		String sqlSelect = "SELECT * FROM evento WHERE titulo LIKE '%" +titulo +"%'";

		ArrayList<Evento> listaEvento = new ArrayList<>();
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlSelect);) {
			
			ResultSet resultado = pst.executeQuery();
			
			while(resultado.next())
				listaEvento.add(consultarEvento(resultado.getInt("id")));
			
			return listaEvento;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	/**
	 * Lista de eventos de uma empresa
	 * @param cnpj
	 * @return
	 */
	public ArrayList<Evento> consultarEventos(String cnpj) {
        String sqlSelect = "SELECT * FROM evento WHERE fk_empresa_cnpj='" +cnpj +"'";

        ArrayList<Evento> listaEvento = new ArrayList<>();
        
        try (Connection conectar = ConnectionFactory.obtemConexao();
                PreparedStatement pst = conectar.prepareStatement(sqlSelect);) {
            
            ResultSet resultado = pst.executeQuery();
            
            while(resultado.next())
                listaEvento.add(consultarEvento(resultado.getInt("id")));
            
            return listaEvento;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
	
	/**
	 * consultar os eventos passados
	 * @param cnpj
	 * @return
	 */
	public ArrayList<Evento> consultarEventosPassados(String cnpj) {
	    Evento evento = null;
	    String sqlSelect = "SELECT * FROM evento WHERE fk_empresa_cnpj=? and data_hora < '"
                + handleDataHoraAtual() + "' order by data_hora asc";

        ArrayList<Evento> listaEvento = new ArrayList<>();
        
        try (Connection conectar = ConnectionFactory.obtemConexao();
                PreparedStatement pst = conectar.prepareStatement(sqlSelect);) {
            pst.setString(1, cnpj);
            
            ResultSet result = pst.executeQuery();
            
            while(result.next()) {
                evento = new Evento();
                evento.setId(result.getInt("id"));
                evento.setDataHora(result.getDate("data_hora"));
                evento.setLocalizacao(result.getString("localizacao"));
                evento.setDescricao(result.getString("descricao"));
                evento.setDuracao(result.getInt("duracao"));
                evento.setQuantidadeVagas(result.getInt("quantidade_vagas"));
                evento.setPalestrante(result.getString("palestrante"));
                evento.setTitulo(result.getString("titulo"));
                
                EmpresaService es = new EmpresaService();
                evento.setEmpresa(es.carregarCpf(cnpj));
                listaEvento.add(evento);
                evento = null;
            }
            
            return listaEvento;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
	
	/**
	 * todos os eventos futuros
	 * @param cnpj
	 * @return
	 */
	public ArrayList<Evento> consultarEventosFuturos(String cnpj) {
        Evento evento = null;
        String sqlSelect = "SELECT * FROM evento WHERE fk_empresa_cnpj='" + cnpj + "' and data_hora > '"
                + handleDataHoraAtual() + "' order by data_hora asc";

        
        ArrayList<Evento> listaEvento = new ArrayList<>();
        
        try (Connection conectar = ConnectionFactory.obtemConexao();
                PreparedStatement pst = conectar.prepareStatement(sqlSelect);) {
            
            ResultSet result = pst.executeQuery();
            while(result.next()) {
                evento = new Evento();
                evento.setId(result.getInt("id"));
                evento.setDataHora(result.getDate("data_hora"));
                evento.setLocalizacao(result.getString("localizacao"));
                evento.setDescricao(result.getString("descricao"));
                evento.setDuracao(result.getInt("duracao"));
                evento.setQuantidadeVagas(result.getInt("quantidade_vagas"));
                evento.setPalestrante(result.getString("palestrante"));
                evento.setTitulo(result.getString("titulo"));
                System.out.println(evento.toString());
                listaEvento.add(evento);
                evento = null;
            }
            
            return listaEvento;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
	
	/**
	 * Tres proximos eventos
	 * @param cnpj
	 * @return
	 */
    public ArrayList<Evento> consultarTresProximosEventos(String cnpj) {
        Evento evento = null;
        String sqlSelect = "SELECT * FROM evento WHERE fk_empresa_cnpj='" + cnpj + "' and data_hora > '"
                + handleDataHoraAtual() + "' order by data_hora asc";

        ArrayList<Evento> listaEvento = new ArrayList<>();

        try (Connection conectar = ConnectionFactory.obtemConexao();
                PreparedStatement pst = conectar.prepareStatement(sqlSelect);) {

            ResultSet result = pst.executeQuery();
            
            for (int i = 0; result.next() && i <= 3; i++) {
                evento = new Evento();
                evento.setId(result.getInt("id"));
                evento.setDataHora(result.getDate("data_hora"));
                evento.setLocalizacao(result.getString("localizacao"));
                evento.setDescricao(result.getString("descricao"));
                evento.setDuracao(result.getInt("duracao"));
                evento.setQuantidadeVagas(result.getInt("quantidade_vagas"));
                evento.setPalestrante(result.getString("palestrante"));
                evento.setTitulo(result.getString("titulo"));
                // TODO otimizar com dao.consultarEvento
                listaEvento.add(evento);
                evento = null;
            }

            return listaEvento;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
	
	
	/**
	 * Atualiza�ao de um evento existente
	 * @param evento
	 * @throws SQLException
	 */
	public void atualizarEvento(Evento evento) throws SQLException {
		String sqlUpdate = "UPDATE evento SET data_hora = ?, localizacao = ?, descricao = ?, duracao = ?, quantidade_vagas = ?, palestrante = ?, titulo = ?"
		        + "WHERE id = ?";
		
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlUpdate)) {
			pst.setTimestamp(1, new java.sql.Timestamp(evento.getDataHora().getTime()));
			pst.setString(2, evento.getLocalizacao());
			pst.setString(3, evento.getDescricao());
			pst.setInt(4, evento.getDuracao());
			pst.setInt(5, evento.getQuantidadeVagas());
			pst.setString(6, evento.getPalestrante());
			pst.setString(7, evento.getTitulo());
			pst.setInt(8, evento.getId());
			
			pst.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	/**
	 * Deletar um evento utilizando id
	 * @param id
	 * @throws SQLException
	 */
	public void deletarEvento(int id) throws SQLException {
		String sqlDelete = "DELETE FROM evento WHERE id='" +id +"'";
		
		try(Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlDelete);) {
			pst.execute();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Remove todos os eventos de uma empresa
	 * @param cnpj
	 * @throws SQLException
	 */
	public void deletarEvento(String cnpj) throws SQLException {
		String sqlDelete = "DELETE FROM evento WHERE fk_empresa_cnpj='" +cnpj +"'";
		
		try(Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlDelete);) {
			pst.execute();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * Insere tag_usuario
	 * @param cpf
	 * @param idTag
	 */
	public void inserirTag(int id, int idTag){
		String sqlInsert = "INSERT INTO tag_evento"
				+"(fk_tag_id, fk_evento_id)"
				+"VALUES (?,?)";
		try (Connection conectar = ConnectionFactory.obtemConexao();
				PreparedStatement pst = conectar.prepareStatement(sqlInsert);) {
			pst.setInt(1, idTag);
			pst.setInt(2, id);

			pst.execute();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public String handleDataHoraAtual() {
	    Date data = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(data);
	}
}
