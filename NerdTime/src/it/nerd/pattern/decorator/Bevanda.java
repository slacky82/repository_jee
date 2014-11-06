package it.nerd.pattern.decorator;

public abstract class Bevanda {

	String nome = "";

	public String getNome() {
		return nome;
	}

	public abstract double getPrezzo();
}
