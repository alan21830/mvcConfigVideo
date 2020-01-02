package configMVC.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import configMVC.model.*;
@Repository
public class UtentiRepository {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Utenti> getUtenti()
	{
		
		List<Utenti> utenti = jdbcTemplate.query("SELECT * FROM UTENTI", new RowMapper()
				{

					@Override
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Utenti utente = new Utenti();
						try
						{
							utente.setId(rs.getInt("ID"));
							utente.setUsername(rs.getString("USERNAME"));
							utente.setPassword(rs.getString("PASSWORD"));
							utente.setQty(rs.getInt("QTY"));
						}catch(Exception e)
						{
							System.out.print(e);
						}
						return utente;
						
					}
			
				}		
				);
		
		return utenti;
	}
	
	
	public void inserisci(String username, String password, int qty)
	{
		 
jdbcTemplate.update("INSERT INTO UserEnable.utenti (USERNAME, PASSWORD, QTY) VALUES ('"+username+"','"+password+"','"+qty+"')");

		
	}
	
	public void elimina(int id)
	{
		jdbcTemplate.update("DELETE FROM UserEnable.utenti WHERE ID="+id);
		 
	}
	
	public Utenti findbyId(int id)
	{
 
		
		
		 String sql = "SELECT * FROM UserEnable.utenti WHERE ID = ?";

	        return (Utenti) jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper(){

				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					Utenti utente = new Utenti();
					try
					{
						utente.setId(rs.getInt("ID"));
						utente.setUsername(rs.getString("USERNAME"));
						utente.setPassword(rs.getString("PASSWORD"));
						utente.setQty(rs.getInt("QTY"));
					}catch(Exception e)
					{
						System.out.print(e);
					}
					return utente;
					
				}
		
			}		
			);
		
	}
	
	public void modifica(Utenti utente)
	{
		
		jdbcTemplate.update("UPDATE UserEnable.utenti SET USERNAME='"+utente.username+"',PASSWORD='"+utente.password+"',QTY='"+utente.qty+"'  WHERE ID="+utente.Id);  
			
	}
	
	
}
