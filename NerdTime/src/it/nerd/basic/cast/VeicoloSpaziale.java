package it.nerd.basic.cast;

public class VeicoloSpaziale extends IVeicolo {

	public Integer numeroInceneritori;
	
	
	
	public VeicoloSpaziale(Integer numeroBruciatori,String tipoAlimentazione, Double velocitaMax){
		this.numeroInceneritori=numeroBruciatori;
		this.tipoAlimentazione=tipoAlimentazione;
		this.velocitaMax=velocitaMax;
	}
	
	
	
	public void printInfo(){		
		System.out.println("TIPO VEICOLO: "+this.getClass());
		System.out.println("TIPO ALIMENTAZIONE: "+super.tipoAlimentazione);		
		System.out.println("VELOCITA' MAX: "+super.velocitaMax);
		System.out.println("NUMERO INCENERITORI: "+numeroInceneritori);		
	}



	@Override
	public void ignition() {
		System.out.println("Complicato!!");
		
	}



	@Override
	public void switchOff() {
		System.out.println("Complicato!!");
		
	}
	
	

}
