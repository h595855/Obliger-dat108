package no.dat.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StemmeTeller
 */
@WebServlet("/StemmeTeller")
public class StemmeTeller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StemmeTeller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int Eple = 0;
		int Appelsin = 2;
		int Banan = 5;

		String frukt = request.getParameter("Fav_Frukt");

		if (frukt.equals("eple")) {
			Eple+=Eple++;
		} else if (frukt.equals("appelsin")) {
			Appelsin++;
		} else if (frukt.equals("banan")) {
			Banan++;
		}

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<Head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>" + "Resultat" + "</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>FavorittFrukt resultat!</h1>");
		out.println("Eple: " + Eple + "<br>");
		out.println("Appelsin: " + Appelsin + "<br>");
		out.println("Banan: " + Banan + "<br>");
		out.println("<a href=" + "http://localhost:8080/Frivillig3/stemmeskjema.html"
				+ ">Ny Stemme</a>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
