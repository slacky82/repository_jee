package it.nerd.basic.cast;

public class Automobile extends VeicoloTerrestre {
	
	public Automobile(Integer numeroRuote,String tipoAlimentazione, Double velocitaMax){
		this.numeroRuote=numeroRuote;
		this.tipoAlimentazione=tipoAlimentazione;
		this.velocitaMax=velocitaMax;
	}

	@Override
	public String getTarga() {
		return "AUTOMOBILE -> TARGA = AA124JL";
	}

	@Override
	public Double calcolaBollo() {
		return new Double(200.10);
	}
	
	public void effettuaTestacoda(){
		System.out.println("TESTA_CODA EFFETTUATA!!");
	}
	
	

}
