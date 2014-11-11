package it.nerd.basic.cast;

public class Motociclo extends VeicoloTerrestre {
	
	private final static Integer numeroRuote=2;

	public Motociclo(String tipoAlimentazione,	Double velocitaMax) {
		super(numeroRuote, tipoAlimentazione, velocitaMax);
	}
	
	public void effettuaPiega(){
		System.out.println("Piega effettuata");
	}	
}
