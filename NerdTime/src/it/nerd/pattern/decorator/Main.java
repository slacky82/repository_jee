package it.nerd.pattern.decorator;

public class Main {
	
	public static void main(String args[]){
		Bevanda espresso = new Espresso();
		System.out.printf("%s: prezzo %.2f\n", espresso.getNome(), espresso.getPrezzo());
		
		Bevanda macchiato = new Macchiato(espresso);
		System.out.printf("%s: prezzo: %s\n", macchiato.getNome(), macchiato.getPrezzo());
		
		Bevanda correttoMacchiato = new Corretto(new Macchiato(new Espresso()));
		System.out.printf("%s : prezzo %.2f\n", correttoMacchiato.getNome(), correttoMacchiato.getPrezzo());
	}

}
