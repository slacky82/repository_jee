package it.nerd.basic.cast;

public class VeicoloTerrestre extends IVeicolo {
	
	public Integer numeroRuote;
	
	public VeicoloTerrestre(Integer numeroRuote,String tipoAlimentazione, Double velocitaMax){		
		this.numeroRuote=numeroRuote;
		this.tipoAlimentazione=tipoAlimentazione;
		this.velocitaMax=velocitaMax;
	}
	
	@Override
	public void printInfo(){		
		System.out.println("TIPO VEICOLO: "+this.getClass());
		System.out.println("TIPO ALIMENTAZIONE: "+super.tipoAlimentazione);		
		System.out.println("VELOCITA' MAX: "+super.velocitaMax);
		System.out.println("NUMERO RUOTE: "+numeroRuote);		
	}


	@Override
	public void ignition() {
		System.out.println("chiave + accensione");
		
	}


	@Override
	public void switchOff() {
		System.out.println("chiave + spegnimento");
		
	}
	
	
	

}
