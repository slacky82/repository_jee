package it.nerd.basic.cast;

public class Razzo extends VeicoloSpaziale {

	public Razzo(Integer numeroBruciatori, String tipoAlimentazione,
			Double velocitaMax) {
		super(numeroBruciatori, tipoAlimentazione, velocitaMax);
		// TODO Auto-generated constructor stub
	}
	
	public void rilasciaStadioAlfa(){
		System.out.println("Rilasciato Stadio Alfa!!!");
	}

}
