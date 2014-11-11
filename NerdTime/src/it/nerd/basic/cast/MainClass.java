package it.nerd.basic.cast;

public class MainClass {

	public static void main(String[] args) {
		try {

			VeicoloTerrestre vTerrestre = new VeicoloTerrestre(4, "metano", 130.00);			
			VeicoloTerrestre motoCicloVTerrestre =(VeicoloTerrestre) new Motociclo("benzina", 310.00);
			//Automobile veicoloE = (Automobile) new VeicoloTerrestre(); //java.lang.ClassCastException			
			
			IVeicolo motociclo=(IVeicolo) new Motociclo("elettrica", 100.00);			
			IVeicolo razzo=(IVeicolo) new Razzo(3, "cherosene", 600.00);
			IVeicolo automobile=(IVeicolo) new Automobile("metano", 135.00);
			
			
			getInfo(motociclo);
			piega((Motociclo)motociclo);
			checkType(motociclo);	
			System.out.println("##########################");
			getInfo(razzo);
			rilasciaStadio((Razzo)razzo);
			checkType(razzo);
			System.out.println("##########################");
			getInfo(automobile);
			testaCoda((Automobile)automobile);
			checkType(automobile);				
			System.out.println("##########################");
			
						
			
			
			// figlio = padre COMPILE ERROR 
			//veicoloB=veicoloA;
			//padre = figlio OK	
			
			// padre = new VeicoloTerrestre("", tipoAlimentazione, velocitaMax);
			//vTerrestre=(Automobile) automobile; //padre = figlio OK			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static IVeicolo getInfo(IVeicolo veicolo){
		veicolo.printInfo();
		return veicolo;
	}
	
	public static void checkType(IVeicolo veicolo){
		if(veicolo instanceof IVeicolo){
			System.out.println("IS AN IVEICOLO");			
		}
		if(veicolo instanceof VeicoloTerrestre){
			System.out.println("IS AN VEICOLO TERRESTRE");			
		}
		if(veicolo instanceof VeicoloSpaziale){
			System.out.println("IS A VEICOLO SPAZIALE");			
		}
		if(veicolo instanceof Razzo){
			System.out.println("IS A RAZZO");			
		}	
		if(veicolo instanceof Automobile){
			System.out.println("IS A AUTOMOBILE");			
		}
		if(veicolo instanceof Motociclo){
			System.out.println("IS A MOTOCICLO");			
		}	
		
	}
	
	public static void piega(Motociclo veicolo){
		veicolo.effettuaPiega();
	}
	public static void testaCoda(Automobile veicolo){
		veicolo.effettuaTestacoda();
	}
	public static void rilasciaStadio(Razzo rocket){
		rocket.rilasciaStadioAlfa();
	}
	
	


}
