package controller;

public class Person {
	
	private String Fornavn, Etternavn, Passord;
	private int Mobil;
	private Gender Kjønn;
	
	public Person(String Fornavn, String Etternavn, int mobil, String Passord, Gender Kjønn) {
		this.Fornavn = Fornavn;
		this.Etternavn = Etternavn;
		this.Mobil = mobil;	
		this.Passord = Passord;
		this.Kjønn = Kjønn;
	}
	
	



	public String getFornavn() {
		return Fornavn;
	}
	public void setFornavn(String fornavn) {
		Fornavn = fornavn;
	}
	public String getEtternavn() {
		return Etternavn;
	}
	public void setEtternavn(String etternavn) {
		Etternavn = etternavn;
	}
	public String getPassord() {
		return Passord;
	}
	public void setPassord(String passord) {
		Passord = passord;
	}
	public int getMobil() {
		return Mobil;
	}
	public void setMobil(int mobil) {
		this.Mobil = mobil;
	}
}


	enum Gender {MANN,KVINNE};

