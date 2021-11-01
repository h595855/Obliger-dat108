package oppgave2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import oppgave3.Kjonn;

public class Oppg2 {

	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> func) {
		for (int i = 0; i < ansatte.size(); i++) {
			ansatte.get(i).setAarslonn(func.apply(ansatte.get(i)));
		}
	}

	public static void main(String[] args) {

		List<Ansatt> ansatter = Arrays.asList(new Ansatt("Joe", "Burger", Kjonn.MANN, "utvikler", 300000),
				new Ansatt("Petra", "Persen", Kjonn.DAME, "Kokk", 500000),
				new Ansatt("Bjørn", "Eide", Kjonn.MANN, "sjef-utvikler", 1500000),
				new Ansatt("Alfred", "Nordqvist", Kjonn.MANN, "java-utvikler", 680000),
				new Ansatt("Anton", "Tran", Kjonn.DAME, "sjef-utvikler", 600000),
				new Ansatt("Jeff", "Bazoz", Kjonn.MANN, "CEO", 30000000));
		
		// Kronetilegg på 2000kr
		Function<Ansatt, Integer> Kronetillegg = a -> a.getAarslonn() + 2000;

		// Fast prosenttilegg
		Function<Ansatt, Integer> ProsentTillegg = a -> (a.getAarslonn() * 4) / 100 + a.getAarslonn();

		// Fast Kronetillegg om lav lønn
		Function<Ansatt, Integer> FastTilleggLavLonn = a -> {
			if (a.getAarslonn() < 500000) {
				return a.getAarslonn() + 20000;
			} else {
				return a.getAarslonn();
			}
		};
		// Fast prosenttillegg om du er mann
		Function<Ansatt, Integer> FastProsentMann = a -> {
			if (a.getKjonn() == Kjonn.MANN) {
				return (a.getAarslonn() * 4) / 100 + a.getAarslonn();
			}
			return a.getAarslonn();
		};
		// Fast prosenttillegg om du er dame
		Function<Ansatt, Integer> FastProsentDame = a -> {
			if(a.getKjonn() == Kjonn.DAME) {
				return (a.getAarslonn()*2) / 100 + a.getAarslonn();
			}
				return a.getAarslonn();
		};
		
		lonnsoppgjor(ansatter, Kronetillegg);
		lonnsoppgjor(ansatter, ProsentTillegg);
		lonnsoppgjor(ansatter, FastTilleggLavLonn);
		lonnsoppgjor(ansatter, FastProsentMann);
		lonnsoppgjor(ansatter, FastProsentDame);
		ansatter.forEach(System.out::println);
		
	}

}
