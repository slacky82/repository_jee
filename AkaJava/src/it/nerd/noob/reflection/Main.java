package it.nerd.noob.reflection;

import java.net.URL;

public class Main {

	public static void main(String[] args) {
		URL dummyUrl = Bar.class.getResource("textFile.txt");
	}
}
