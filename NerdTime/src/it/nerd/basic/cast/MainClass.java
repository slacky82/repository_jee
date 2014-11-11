package it.nerd.basic.cast;

public class MainClass {

	public static void main(String[] args) {
		try {

			VeicoloTerrestre veicoloA = new VeicoloTerrestre();
			Automobile veicoloB = new Automobile(4, "metano", 130.00);
			Motociclo veicoloC = new Motociclo(2, "BENZINA", 270.00);			
			VeicoloTerrestre veicoloD =(VeicoloTerrestre) new Automobile(4, "benzina", 220.00);
			//Automobile veicoloE = (Automobile) new VeicoloTerrestre(); //java.lang.ClassCastException
			VeicoloTerrestre veicoloF =(VeicoloTerrestre) new Motociclo(2, "benzina", 300.00);			
		
			getInfo(veicoloF);
			piega((Motociclo)veicoloF);
			checkType(veicoloF);	
			
			
			// figlio = padre COMPILE ERROR 
			//veicoloB=veicoloA;
			//padre = figlio OK	
			veicoloA=veicoloB; //padre = figlio OK			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static VeicoloTerrestre getInfo(VeicoloTerrestre veicolo){
		veicolo.printInfo();
		return veicolo;
	}
	
	public static void piega(Motociclo veicolo){
		veicolo.effettuaPiega();
	}
	public static void testaCoda(Automobile veicolo){
		veicolo.effettuaTestacoda();
	}
	
	public static void checkType(VeicoloTerrestre veicolo){
		if(veicolo instanceof VeicoloTerrestre){
			System.out.println("IS AN VEICOLO TERRESTRE");			
		}
		if(veicolo instanceof Automobile){
			System.out.println("IS A AUTOMOBILE");			
		}
		if(veicolo instanceof Motociclo){
			System.out.println("IS A MOTOCICLO");			
		}		
	}


}
