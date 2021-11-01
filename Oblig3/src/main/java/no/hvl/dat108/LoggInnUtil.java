package no.hvl.dat108;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoggInnUtil {
	
	   public static boolean isGyldigUsername(String passord, String korrektPassord) {
	    	return passord != null && passord.equals(korrektPassord);
	    }
	
	//Logge inn
	public static void logginnmedtimeout(HttpServletRequest request, int timeoutIsekunder) {
		
		loggut(request);
		
		HttpSession sesjon = request.getSession(true); //True eller False
		sesjon.setMaxInactiveInterval(timeoutIsekunder); //sekunder
		sesjon.setAttribute("username", "Passord");
		sesjon.setAttribute("cart", new Cart());
		
	}
	//Logge ut
	public static void loggut(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
		if(sesjon != null) {
			sesjon.invalidate();
		}
	}
	//Sjekke om request tilhører innlogget bruker
	public static boolean erInnlogget(HttpServletRequest request) {
		HttpSession sesjon = request.getSession(false);
		return sesjon != null && sesjon.getAttribute("username") != null;
	}
	//Annet ...?
}
