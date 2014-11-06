package it.nerd.pattern.decorator;

public class Corretto extends Decorator {
	
	private Bevanda bevanda;
	
	public Corretto(Bevanda bevanda){
		this.bevanda=bevanda;
	}

	@Override
	public String getNome() {		
		return bevanda.getNome()+" Corretto";
	}

	@Override
	public double getPrezzo() {
		return bevanda.getPrezzo()+0.60;
	}

}
