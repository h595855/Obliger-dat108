package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SokKonge
 */
@WebServlet("/SokKonge")
public class SokKonge extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SokKonge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean Validering(String s) {
		return s!=null && s.matches("^\\d{4}+$");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String aarString = request.getParameter("aar");

		// Validerer årstall og gi alternativ respons hvis ugyldig.

		if (!Validering(aarString)) {

			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<Head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>" + "Feil" + "</title>");
			out.println("</head>");
			out.println("<body>");
			out.println(aarString + " Er ikkje mulig");
			out.println("<a href=" + "http://localhost:8080/Obl2/index.html" + ">Nytt s&oslash;k</a>");
			out.println("</body>");
			out.println("</html>");
			
		} else {

			int aar = Integer.parseInt(aarString);

			// Finn et passende Konge-objekt fra listen Konger.Norske
			// ved Bruke stream og lambda-Utrykk.

			Konge konge = Konger.norske
					.stream()
					.filter(a -> a.getKongeFraAar() <= aar && a.getKongeTilAar() >= aar)
					.findFirst()
					.orElse(null);

			PrintWriter out = response.getWriter();

			// Lag repons-siden.
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<Head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>" + konge.getNavn() + "</title>");
			out.println(konge.getNavn());
			out.println("</head>");
			out.println("<body>");
			out.println("<img src=" + konge.getBilde() + ">");
			out.println(
					"<p> Konge i &aring;r " + aar + " var " + konge.getNavn() + ", f&oslash;dt " + konge.getFodtAar()
							+ ", \n konge fra " + konge.getKongeFraAar() + " til " + konge.getKongeTilAar() + "</p>");
			out.println("<a href=" + "http://localhost:8080/Obl2/index.html" + ">Nytt s&oslash;k</a>");
			out.println("</body>");
			out.println("</html>");
		}
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
