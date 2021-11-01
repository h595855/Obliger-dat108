package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Navn
 */
@WebServlet("/Navn")
public class Navn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Navn() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public boolean erGyldigTegn(String s) {
    	return s.matches("^[A-Za-z0-9]+$");
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String navn = request.getParameter("navn");
		
		if(!erGyldigTegn(navn)) {
			
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<Head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>" + "Hallo!!!" + "</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Hallo "+ "Dette er en ulovelig input"  + "!</h1>");
			out.println("</body>");
			out.println("</html>");
		}else {
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<Head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>" + "Hallo tilbake" + "</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hallo " + navn + "!</h1>");
		out.println("</body>");
		out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
