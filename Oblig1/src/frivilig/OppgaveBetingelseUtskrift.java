package frivilig;

public class OppgaveBetingelseUtskrift {
	@FunctionalInterface
	interface Betingelse {
		boolean erOppfylt(String s);
	}

	public static void betingetUtskrift(String s, Betingelse betingelse) {
		if(betingelse.erOppfylt(s)) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {

		String t = "Amo";
		String L = "Among us inreallife";
		String x = "XXX";

		betingetUtskrift(t, s -> s.charAt(0) == 'X');
		betingetUtskrift(x, s -> s.charAt(0) == 'X');
		betingetUtskrift(L, s -> s.length() >= 8);
	}
}
