package no.hvl.dat108;

import static no.hvl.dat108.UrlMappings.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * implementation class LoggInnServlet
 */
@WebServlet(name = LOGIN_URL, urlPatterns = "/"+LOGIN_URL)
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String brukernavn = request.getParameter("username");
		
		if(!LoggInnUtil.isGyldigUsername(brukernavn, getServletConfig().getInitParameter("Riktig_passord"))) {
			response.sendRedirect(LOGIN_URL + "?feilkode=invalidpassword");
		}else {
			LoggInnUtil.logginnmedtimeout(request, Integer.parseInt(getServletConfig().getInitParameter("LoggInnTimer")));
			response.sendRedirect(WEBSHOP_URL);
		}
	}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String feilmelding = "";
		String feilkode = request.getParameter("feilkode");
		if(feilkode != null && feilkode.equals("invalidpassword")) {
			feilmelding = "Ugylid passord";
		}
		
		response.setContentType("text/html; charset=ISO-8859-1");
		
		PrintWriter out = response.getWriter();
		
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<meta charset=\"ISO-8859-1\">");
	        out.println("<title>Login</title>");
	        out.println("</head>");
	        out.println("<body>");
	        
	        // Inn noe kode her i forbindelse med evt. feilmeldinger?
	        
	        out.println("<p>" + feilmelding + "</p>");
	        out.println("<form action=\"" + LOGIN_URL + "\" method=\"post\">");
	        out.println("  <fieldset>");
	        out.println("    <legend>Login</legend>");
	        out.println("    <p>Passord: <input type=\"text\" name=\"username\" /></p>");
	        out.println("    <p><input type=\"submit\" value=\"Logg inn\" /></p>");
	        out.println("  </fieldset>");
	        out.println("</form>");
	        out.println("</body>");
	        out.println("</html>");
	}

}
