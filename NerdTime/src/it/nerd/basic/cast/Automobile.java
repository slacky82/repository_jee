package it.nerd.basic.cast;

public class Automobile extends VeicoloTerrestre {
	
	protected static final Integer numeroRuote=4;
	

	public Automobile(String tipoAlimentazione,
			Double velocitaMax) {
		super(numeroRuote, tipoAlimentazione, velocitaMax);
		// TODO Auto-generated constructor stub
	}	
	
	
	public void effettuaTestacoda(){
		System.out.println("Testa Coda Effettuato!!");
	}
	
	

}
