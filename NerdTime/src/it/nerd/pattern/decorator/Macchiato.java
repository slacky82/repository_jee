package it.nerd.pattern.decorator;


public class Macchiato extends Decorator {

	private Bevanda bevanda;
	
	public Macchiato(Bevanda bevanda){
		this.bevanda=bevanda;
	}
	
	@Override
	public String getNome() {		
		return bevanda.getNome()+" Macchiato";
	}

	@Override
	public double getPrezzo() {		
		return bevanda.getPrezzo()+0.05;
	}

}
