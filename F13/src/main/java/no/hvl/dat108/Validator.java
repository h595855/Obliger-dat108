package no.hvl.dat108;

public class Validator {

	public static final String ANY_LETTER = "[a-zA-Z0-9ÆØÅæøå]";
	public static final String THREE_OR_MORE_TIMES = "{3,}";
	
    /**
     * @param username Brukernavnet som skal valideres
     * @return Om brukenavnet er gyldig eller ikke
     *
     * Et gyldig brukernavn består av 4 eller flere tegn. Lovlige tegn
     * er bokstaver (små og store) inkl. de norske bokstavene, og tall.
     * Brukernavnet kan ikke begynne med et tall.
     */
    public static boolean isGyldigUsername(String username) {
    	
    	if(username == null) {
    		return false;
    	}
    	return username.matches("^"
    			+ ANY_LETTER
    			+ "[A-Za-zÆØÅæøå\\d]" + THREE_OR_MORE_TIMES
    			+ "[A-Za-zÆØÅæøå\\d]*"
    			+ "$");
    }
}
