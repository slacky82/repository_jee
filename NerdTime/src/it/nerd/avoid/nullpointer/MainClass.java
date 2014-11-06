package it.nerd.avoid.nullpointer;

public class MainClass {

	public static void main(String args[]) {
		AvoidNullPointer facade = new AvoidNullPointer();
		String test = null;
		Boolean res = null;
		try {
			res = facade.isFinished(test);				
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}		
		try{
			facade.test();
		}catch (NullPointerException npe) {
			npe.printStackTrace();
		}	
		try{
			System.out.println("isEmpty  "+facade.getEmptyEmployees().isEmpty());
		}catch (NullPointerException npe) {
			npe.printStackTrace();
		}	
		if(facade.getEmptyEmployees()!=null){
			facade.getEmptyEmployees().isEmpty();			
		}
		else{
			System.out.println("getEmptyEmployees() == NULL!!!");
		}
			
		
		
		res = facade.avoidNullIsFinished(test);
		System.out.println("finished?: " + res);	
		 
	}
	
	

}
