package f06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class F06B {

	public static void main(String[] args) {
		
		List<String> listen = Arrays.asList("Hallo", "blabla", "knut", "Per");
		
		Collections.sort(listen);
		System.out.println(listen);
		
//		//Sortere alfabetisk. Hva gjør vi ?
//		Collections.sort(listen, new Comparator<String>() {
//			@Override
//			public int compare(String a, String b) {
//				return a.toUpperCase().compareTo(b.toUpperCase());
//			}
//		});
//		System.out.println(listen);
		
		Collections.sort(listen, (a, b) -> a.toUpperCase().compareTo(b.toUpperCase()));
		System.out.println(listen);
		
		//Sortere på String-lengde
		
		Collections.sort(listen, (a, b) -> a.length() - b.length());
		System.out.println(listen);
		
		//Sortere baklengs på lengde
		Comparator<String> baklengsPaaLengde = (a, b) -> b.length() - a.length();
		Collections.sort(listen, baklengsPaaLengde);
		System.out.println(listen);
	}

}
