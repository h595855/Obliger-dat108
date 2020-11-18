package no.hvl.dat100;

public abstract class Spar {

	private String kunde, bjørn, ansatt;
	private int timer, ansNr;
	
public Spar(String kunde, String bjørn, int timer, String ansatt, int ansNr) {
	this.kunde=kunde;
	this.bjørn=bjørn;
	this.timer=timer;
	this.ansatt=ansatt;
	this.ansNr=ansNr;
}

public String getAnsatt() {
	return ansatt;
}

public void setAnsatt(String ansatt) {
	this.ansatt = ansatt;
}

public String getKunde() {
	return kunde;
}

public void setKunde(String kunde) {
	this.kunde = kunde;
}

public String getBjørn() {
	return bjørn;
}

public void setBjørn(String bjørn) {
	this.bjørn = bjørn;
}

public int getTimer() {
	return timer;
}

public void setTimer(int timer) {
	this.timer = timer;
}

@Override
public String toString() {
	return "Spar [kunde=" + kunde + ", bjørn=" + bjørn + ", timer=" + timer + "]";
}
}
