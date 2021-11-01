package oppgave3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Oppg3 {

	public static void main(String[] args) {
	
	List<Ansatt> ansatter = Arrays.asList(
			new Ansatt("Joe", "Peder", Kjonn.MANN, "utvikler", 300000),
			new Ansatt("Petra", "Persen", Kjonn.DAME, "Burgar", 500000),
			new Ansatt("Bjørn", "Eide", Kjonn.MANN, "sjef-utvikler", 1500000),
			new Ansatt("Alfred", "Nordqvist", Kjonn.MANN, "java-utvikler", 680000),
			new Ansatt("Anton", "Tran", Kjonn.DAME, "sjef-retard", 600000)
			);

	//Liste med kun etternavn til de ansatte
	List<String> Ansattetternavn = ansatter.stream()
				.map(a -> "" + a.getEtternavn())
				.collect(Collectors.toList());
	System.out.println(Ansattetternavn);
	System.out.println();
	
	//Antall kvinner blant de sansatte
	long AntallKvinner = ansatter.stream()
			.filter(a -> a.getKjonn() == Kjonn.DAME)
			.count();
	System.out.println(AntallKvinner + " Antall Kvinner");
	System.out.println();
	
//	//Gjennomsnittslønnen til kvinner
	OptionalDouble snittlonnKvinner = ansatter.stream()
			.filter(a -> a.getKjonn() == Kjonn.DAME)
			.mapToDouble(a -> a.getAarslonn())
			.average();
	System.out.println(snittlonnKvinner + "Snittlønnen til kvinner");		
	System.out.println();
	
	//alle med sjef 7% llønnsøkning. Bruke stream direkte
	ansatter.stream()
	.filter(a -> a.getStilling().contains("sjef"))
	.forEach(a -> a.setAarslonn((a.getAarslonn()*7)/100 + a.getAarslonn()));
	
	//Finn ut om noen tjener over 800.000,-
	boolean TjeneOver = ansatter.stream()
			.anyMatch(a -> a.getAarslonn() > 800000.0);
	System.out.println(TjeneOver + " At noen tjener over 800 000,-");
	System.out.println();
	
	//Skrive ut alle ansatte uten forløkke
	ansatter.forEach(System.out::println);
	System.out.println();
	
	//Finner ansatte med lavest lønn
	Ansatt LavestLonn = ansatter.stream()
			.min(Comparator.comparing(Ansatt::getAarslonn))
			.get();
	System.out.println(LavestLonn + " Tjener minst");

	
	//Summen av heiltal fra 1-1000 som er delelig med 5 eller 3
	System.out.println(IntStream.rangeClosed(1, 1000)
			.filter(a -> a%5 == 0 || a%3 == 0)
			.sum());
	
	}

}
