package f06;

import java.util.Arrays;
import java.util.List;

interface Sammenligner<T> {
	int sammenlign(T a, T b);
}

class FornavnSammenligner implements Sammenligner<Person> {

	@Override
	public int sammenlign(Person a, Person b) {
		return a.fornavn.compareTo(b.fornavn);
	}
}

public class F06a {

	private static <T extends Comparable<T>> void sorter(List<T> list) {

	private static <T extends Comparable<T>> void sorter(List<T> list, Sammenligner<T> sammenligner) {
		
	
		for (int i = 0; i < list.size(); i++) {
			for (int j = 1; j < list.size(); j++) {

				T a = list.get(j - 1);
				T b = list.get(j);

				if (sammenligner.sammenlign(a, b) > 0) {
					list.set(j-1, b);
					list.set(j, a);       
				}
			
			}
		}
	
	}

	public static void main(String[] args) {

		List<Integer> listeAvTall = Arrays.asList(4, 2, 7, 5, 9, 1);

		sorter(listeAvTall);

		System.out.println(listeAvTall);

		List<String> listeAvString = Arrays.asList("Aaa", "xxx", "bbb", "kkk");
		sorter(listeAvString);
		System.out.println(listeAvString);

		List<Person> listeAvPersoner = Arrays.asList(new Person("Anne", "Persen"), new Person("Per", "andersen"),
				new Person("Knut", "Svendsen"));
		sorter(listeAvPersoner);
		System.out.println(listeAvPersoner);

		// ønsker å sortere på fornavn

		sorter(listeAvPersoner, new FornavnSammenligner());
		System.out.println(listeAvPersoner);
		
		//Ønsker å sortere på fødselsår
		sorter(listeAvPersoner, new Sammenligner<Person>(){
			@Override
			public int sammenlign(Person a, Person b) {
				return a.fornavn -b.fornavn;
			}
		});
	}

}
