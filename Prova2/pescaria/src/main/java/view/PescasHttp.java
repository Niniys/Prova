package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import controller.PescasProcess;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pescas;

@WebServlet("/pescas")
public class PescasHttp {
	
	private PrintWriter pw;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pw = resp.getWriter();
		
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		try {
			JSONObject obj = new JSONObject(body);
			
			String Cidade = obj.getString("Cidade");
			String Quantidade = obj.getString("Quantidade");
			int Id = obj.getInt("Id");
			
			Pescas pesca = new Pescas();
			pesca.setId(Id);
			pesca.setCidade(Cidade);
			pesca.setQuantidade(Quantidade);
			
			PescasProcess rp = new PescasProcess();
			
			if(rp.create(pesca)) {
				pw.write(obj.toString());
			}else {
				resp.setStatus(401);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@SuppressWarnings("unused")
	private void doget(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PescasProcess rp = new PescasProcess();
		pw = resp.getWriter();
		
		String Cidade = req.getParameter("Cidade");
		String Quantidade = req.getParameter("Quantidade");
		
		JSONArray arr = rp.read(Cidade, Quantidade);
				
		pw.write(arr.toString());
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pw = resp.getWriter();
		PescasProcess rp = new PescasProcess();
		
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		try {
			JSONObject obj = new JSONObject(body);
			
			@SuppressWarnings("unused")
			String Cidade = obj.getString("Quantidade");
			@SuppressWarnings("unused")
			String Quantidade = obj.getString("Cidade");
			int id = obj.getInt("Id");
			
			Pescas pesca = new Pescas();
			pesca.setId(id);
			pesca.setCidade("Cidade");
			pesca.setQuantidade("Quantidade");
			
			if(rp.update(pesca) == true) {
				pw.write(obj.toString());
			}else {
				resp.setStatus(401);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pw = resp.getWriter();
		PescasProcess rp = new PescasProcess();
		
		String tempId = req.getParameter("id");
		int id = Integer.parseInt(tempId);
		
		if(rp.delete(id) == false) {
			resp.setStatus(401);
		}
	}

	}
