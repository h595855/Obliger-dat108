package f06;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Betingelse{
	boolean erOppfylt(int x);
}

public class F06c {

	public static List<Integer> filtrer(List<Integer> liste, Betingelse betingelse){
		
		List<Integer> retultat = new ArrayList<>();
		
		for(int tall : liste) {
			if(betingelse.erOppfylt(tall)){
				retultat.add(tall);
			}
		}
		return retultat;
		
	}
	
	public static void main(String[] args) {

		List<Integer> listen = List.of(-4,1,5,8,3,2,4,6,77);
		List<Integer> resultat;
		
		//resultat skal inneholde alle partall fra listen
		resultat = filtrer(listen, (x) -> x%2 == 0);
		System.out.println(resultat);
		
		
		//Alle tall større enn 0
		resultat = filtrer(listen, x -> x > 0);
		System.out.println(resultat);
	
		//Alle tall større enn 5
		resultat = filtrer(listen, x -> x > 5);
		System.out.println(resultat);
	
		//Alle tall større enn 7
		resultat = filtrer(listen, storreEnn(7));
		System.out.println(resultat);
		
	}
	public static Betingelse storreEnn(int grense) {
		return x -> x > grense;
	}

}
