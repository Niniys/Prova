package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Pescas;

public class PescasProcess {

	PreparedStatement ps;
	Connection con;
	ResultSet rs;
	
	public PescasProcess() {
		this.con = ConnectionDB.getConnection();
	}
	
	public boolean create(Pescas pesca) {
		
			String query = "INSERT INTO reservas VALUES (DEFAULT, ?, ?, ?)";
		
			try {
				ps = con.prepareStatement(query);
				
				ps.setString(1, pesca.getCidade());
				ps.setString(2, pesca.getQuantidade());
				
				if(ps.executeUpdate() > 0) {
					rs = ps.getGeneratedKeys();
					rs.next();
					int id = rs.getInt(1);
					pesca.setId(id);
					ps.close();
					return true;
				}
				
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
	}

	//Quantidade > cidade = excedente
	//Excedente != Status
	//quantidade x 1000 = multa
	public JSONArray read(String Cidade, String Quantidade) {
		
		JSONArray arr = new JSONArray();
		
		String query = "SELECT * FROM pescas";
		
		if(Cidade != null && Quantidade != null) {
			query += " WHERE Quantidade = ? AND Cidade = ?";
		}else if(Cidade != null || Quantidade != null) {
			String part = (Cidade != null) ? "Cidade" : "Quantidade";
			query += " WHERE " + part + " = ?";
		}
		
		try {
			ps = con.prepareStatement(query);
			
			if(Cidade != null && Quantidade != null) {
				ps.setString(1, Quantidade);
				ps.setString(2, Cidade);
			}else if(Cidade != null || Quantidade != null) {
				//SELECT * FROM Quantidade WHERE nome_livro = ?
				String busca = (Cidade != null) ? Cidade : Quantidade;
				ps.setString(1, busca);
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("Cidade", rs.getString("Cidade"));
				obj.put("Quantidade", rs.getString("Quantidade"));
				obj.put("Status", rs.getString("Status"));
				obj.put("Excedente", rs.getString("Excedente"));
				obj.put("Multa", rs.getString("Multa"));
				
				arr.put(obj);
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arr;
		
	}

	public boolean update(Pescas pesca) {
		
		String query = "UPDATE reservas SET Cidade = ?, Quantidade = ?, WHERE id = ?";
	
		try {
			ps = con.prepareStatement(query);
			
			ps.setString(1, pesca.getCidade());
			ps.setString(2, pesca.getQuantidade());
			ps.setInt(3, pesca.getId());
			
			if(ps.executeUpdate() > 0) {
				ps.close();
				return true;
			}
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return false;
		}
	
		public boolean delete(int id) {
			
			String query = "DELETE FROM reservas WHERE id = ?";
			
			try {
				ps = con.prepareStatement(query);
			
				ps.setInt(1, id);
				
				if(ps.executeUpdate() > 0) {
					ps.close();
					return true;
				}
				
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false;
	}
}
