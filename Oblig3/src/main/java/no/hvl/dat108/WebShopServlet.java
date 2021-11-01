package no.hvl.dat108;

import static no.hvl.dat108.UrlMappings.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/" + WEBSHOP_URL)
public class WebShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * GET /webshop er forespørselen for å vise webshop-siden.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Inn noe kode her i forbindelse med autentisering, autorisasjon
		// og feilhåndtering?
		if (!LoggInnUtil.erInnlogget(request)) {
			response.sendRedirect(LOGIN_URL);

		} else {

			// Inn noe kode her i forbindelse med uthenting av sesjonsdata?
			HttpSession sesjon = request.getSession(true);
			String brukernavn = (String) sesjon.getAttribute("username");
			Cart handlevogn = (Cart) sesjon.getAttribute("cart");

			response.setContentType("text/html; charset=ISO-8859-1");

			PrintWriter out = response.getWriter();

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<title>Handleliste</title>");
			out.println("</head>");
			out.println("<body>");

			// Inn noe kode her for "Du er innlogget som <bruker>"?

			out.println("Din handleliste:<br />");

			// Inn noe kode her for å vise innhold i handlevogn:

			out.println("</table><br/>");
			out.println("<form action=\"" + WEBSHOP_URL + "\" method=\"post\">");
			out.println("<fieldset>");
			out.println("<legend>HandleListe</legend>");
			out.println("vare: <input type=\"text\" name=\"vare\" /><br/>");
			out.println("<p><input type=\"submit\" value=\"Legg i handlekure\" /></p>");
			
			
			for (CartItem item : handlevogn.getItems()) {
				
				out.print("<button type='submit' value=" + item.getItem() + " name='slettVare' /> Slett </button>"  +  "  ");
				out.println(item.getItem() + "<br>");
				
			}

			out.println("</fieldset>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		if (!LoggInnUtil.erInnlogget(request)) {
			response.sendRedirect(LOGIN_URL);

		} else {


			HttpSession sesjon = request.getSession(true);

			String brukernavn = (String) sesjon.getAttribute("username");

			Cart handlevogn = (Cart) sesjon.getAttribute("cart");

			String vare = request.getParameter("vare");
			
			String slett = request.getParameter("slettVare");

			// Legge til
			if(!Validator.isGydlingvare(vare)) {
				handlevogn.addItem(new CartItem(vare));				
			}
			
			
			// Fjerne
			if(slett != null) {
				handlevogn.getItems().removeIf(x -> x.getItem().equals(slett));
			}
			
			
			response.sendRedirect(WEBSHOP_URL);
		}
	}

}
