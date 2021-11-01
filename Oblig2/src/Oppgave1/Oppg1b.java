package Oppgave1;

import java.util.function.BiFunction;


public class Oppg1b {
	
	public static int beregn(int a, int b, BiFunction funktion) {
		Integer svar = (Integer)funktion.apply(a, b);
		return svar;
	}

	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, Integer> sum = (a,b) -> a+b;
		BiFunction<Integer, Integer, Integer> storste = (a,b) -> Integer.max(a, b);
		BiFunction<Integer, Integer, Integer> differeanse = (a,b) -> a - b;
		
		System.out.println(beregn(12,13,sum) + " Summert");
		System.out.println(beregn(54,45, differeanse) + " Differanse");
		System.out.println(beregn(-5,3,storste) + " Største");
		

	}

}
