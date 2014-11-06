package it.nerd.architecture;

public class Main {

	public static void main(String[] args) {
		
		MyConfirmable myConf = new MyConfirmable();
		AnotherConfirmable  myConfNew = new AnotherConfirmable();
		
		Confirmable confirmable = new Confirmable();		
		
		confirmable.showConfirmablePopup(myConf);		
		confirmable.showConfirmablePopup(myConfNew);
		
	
	}

}
