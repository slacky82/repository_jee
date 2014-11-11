package it.nerd.basic.cast;

public abstract class IVeicolo implements Veicolo {
	
	public Integer numeroRuote;
	public Double velocitaMax;
	public String  tipoAlimentazione;

	@Override
	public abstract String getTarga();

	@Override
	public abstract Double calcolaBollo();
	
	public void printInfo(){		
		System.out.println("TIPO VEICOLO: "+this.getClass());
		System.out.println("TIPO ALIMENTAZIONE: "+tipoAlimentazione);
		System.out.println("NUMERO RUOTE: "+numeroRuote);
		System.out.println("VELOCITA' MAX: "+velocitaMax);
		System.out.println("############################################");
	}
 
}
