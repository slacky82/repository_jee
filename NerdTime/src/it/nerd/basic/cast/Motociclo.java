package it.nerd.basic.cast;

public class Motociclo extends VeicoloTerrestre {	
	
	public Motociclo(Integer numeroRuote,String tipoAlimentazione, Double velocitaMax){
		this.numeroRuote=numeroRuote;
		this.tipoAlimentazione=tipoAlimentazione;
		this.velocitaMax=velocitaMax;
	}

	@Override
	public String getTarga() {
		return "MOTOCICLO -> TARGA = 123AG";
	}

	@Override
	public Double calcolaBollo() {
		return new Double(110.10);
	}
	
	public void  effettuaPiega(){
		System.out.println("PIEGA EFFETTUATA!!");
	}

}
