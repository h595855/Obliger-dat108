package no.hvl.dat102;

public class Film {
	


	int Filmnr, År;
	String Produsent, Filmselskap, Tittel;
	enum sjanger{
		ACTION, DRAMA, HISTORY, SCIFI;
	}
	Sjanger sjanger;
	
	//Opprette eit tomt film-objekt
	 public Film() {
	}
	 
	 public Film(int Filmnr, String Filmselskap, String Tittel, int år, Sjanger sjanger, String Produsent) {
		 this.Filmnr = Filmnr;
		 this.Filmselskap = Filmselskap;
		 this.Tittel = Tittel;
		 this.År = år;
		 this.sjanger = sjanger;
		 this.Produsent = Produsent;
	 }

	public int getFilmnr() {
		return Filmnr;
	}

	public void setFilmnr(int filmnr) {
		Filmnr = filmnr;
	}

	public int getÅr() {
		return År;
	}

	public void setÅr(int år) {
		År = år;
	}

	public String getProdusent() {
		return Produsent;
	}

	public void setProdusent(String produsent) {
		Produsent = produsent;
	}

	public String getFilmselskap() {
		return Filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		Filmselskap = filmselskap;
	}

	public String getTittel() {
		return Tittel;
	}

	public void setTittel(String tittel) {
		Tittel = tittel;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}	
	@Override
	public String toString() {
		return "Filmnr= " + Filmnr +
				"\n År= " + År + 
				"\n Produsent= " + Produsent +
				"\n Filmselskap=" + Filmselskap +
				"\n Tittel= " + Tittel + 
				"\n sjanger= " + sjanger + "\n";
	}
}
