package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Omregning
 */
@WebServlet("/Omregning")
public class Omregning extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Omregning() {
		super();
		// TODO Auto-generated constructor stub
	}

	private boolean ValidDecimal(String s) {
		return s != null && s.matches("^-?[0-9]\\d*(\\.\\d+)?$");
	}
	
	private static double round(double value, int precision) {
		int scale = (int) Math.pow(10, precision);
		return (double) Math.round(value * scale) / scale;
		}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String temperaturString = request.getParameter("temp");
		String radio = request.getParameter("CelTilFar");
		// FeilSøker
		if (!ValidDecimal(temperaturString) || radio == null) {
			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<Head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>" + "TemperaturOmregning Resultat" + "</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Ikke Lovelig Input</h3>");
			out.println(temperaturString);
			out.println("<a href=" + "http://localhost:8080/Frivillig1/temperaturforskjell.html"
					+ ">Nytt for&oslash;k</a>");
			out.println("</body>");
			out.println("</html>");

		} else {

			double temp = Double.parseDouble(temperaturString);

			if (radio.equals("Celsius")) {
				// Trykke knapp 1
				if (temp >= -273.15) {
					double celtilfar = (temp * 9 / 5) + 32;
					DecimalFormat value = new DecimalFormat("#.#");
					PrintWriter out = response.getWriter();
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<Head>");
					out.println("<meta charset=\"UTF-8\">");
					out.println("<title>" + "TemperaturOmregning Resultat" + "</title>");
					out.println("</head>");
					out.println("<body>");
					out.println("<h1>TemperaturUtrekning</h1><br>");
					out.println("<h3>" + temp + "&#8451;" + " = " + round(celtilfar, 1) + "&#8457;</h3>");
					out.println("<a href=" + "http://localhost:8080/Frivillig1/temperaturforskjell.html"
							+ ">Nytt for&oslash;k</a>");
					out.println("</body>");
					out.println("</html>");

				} else {
					
					PrintWriter out = response.getWriter();
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<Head>");
					out.println("<meta charset=\"UTF-8\">");
					out.println("<title>" + "TemperaturOmregning Resultat" + "</title>");
					out.println("</head>");
					out.println("<body>");
					out.println("<h1>TemperaturUtrekning</h1><br>" + "Celcius");
					out.println("<h3>For lite tall</h3>");
					out.println("<a href=" + "http://localhost:8080/Frivillig1/temperaturforskjell.html"
							+ ">Nytt for&oslash;k</a>");
					out.println("</body>");
					out.println("</html>");
				}

			} else if (radio.equals("Fareinheit")) {
				// Trykke knap 2
				if(temp >= -459.67) {
				double FarTilCel = (temp -32)/1.8;
				DecimalFormat value = new DecimalFormat("#.#");
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<Head>");
				out.println("<meta charset=\"UTF-8\">");
				out.println("<title>" + "TemperaturOmregning Resultat" + "</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>TemperaturUtrekning</h1><br>");
				out.println("<h3>" + temp + "&#8457;" + " = " + round(FarTilCel,1) + "&#8451;</h3>");
				out.println("<br>");
				out.println("<a href=" + "http://localhost:8080/Frivillig1/temperaturforskjell.html"
						+ ">Nytt for&oslash;k</a>");
				out.println("</body>");
				out.println("</html>");
				
				} else {
			
					PrintWriter out = response.getWriter();
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<Head>");
					out.println("<meta charset=\"UTF-8\">");
					out.println("<title>" + "TemperaturOmregning Resultat" + "</title>");
					out.println("</head>");
					out.println("<body>");
					out.println("<h1>TemperaturUtrekning</h1><br>");
					out.println("<h3>Temperaturen er ikke gyldig</h3>");
					out.println("<a href=" + "http://localhost:8080/Frivillig1/temperaturforskjell.html"
							+ ">Nytt for&oslash;k</a>");
					out.println("</body>");
					out.println("</html>");
				}
				
			}

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
