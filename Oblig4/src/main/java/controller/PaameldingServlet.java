package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaameldingServlet
 */
@WebServlet("/PaameldingServlet")
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Fornavn = request.getParameter("fornavn");
		
		String Etternavn = request.getParameter("Fornavn");
		int Mobil = Integer.parseInt(request.getParameter("mobil"));
		String passord = request.getParameter("passord");
		String passordRepeat = request.getParameter("password");
		String kjonn = request.getParameter("kjonn");
		
		if(kjonn.equals("mann") && passord.equals(passordRepeat)) {
			Person ny = new Person(Fornavn, Etternavn, Mobil, passord, Gender.MANN);			
		}else if(kjonn.equals("kvinne") && passord.equals(passordRepeat)) {
			Person ny = new Person(Fornavn, Etternavn, Mobil, passord, Gender.KVINNE);
		}
		
		
		
	}

}
