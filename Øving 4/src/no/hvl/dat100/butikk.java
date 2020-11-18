package no.hvl.dat100;

public class butikk{
	
	private Spar[] Spar;
	private int nesteledig;
	
 public butikk() {
	 Spar = new Spar[20];
 }
 public butikk(int lengde) {
	 Spar = new Spar[lengde];
 }
 
 public int finnAnsatt(Spar ansatt) {
	 for(int i = 0; i < Spar.length-1; i++) {
		if(Spar[i].equals(ansatt)) {
			 return i;
		 }
	 }
	 return -1;
 }
 public boolean Jobber(Spar ansatt) {
	 if(finnAnsatt(ansatt) != -1){
		 return true;
	 }
	 return false;
 }
 
 public String ErDetBjørn(String ans) {
	 
	if(ans.equals("bjørn")) {
		ans = null;
		System.out.println("Han får ikkje jobb");
		return ans;	
	}
	return null;
 }
}
