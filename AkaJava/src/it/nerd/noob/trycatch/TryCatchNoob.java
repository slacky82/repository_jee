package it.nerd.noob.trycatch;

public class TryCatchNoob {
	
	protected void foo(boolean isErr ){
		try{
			if(isErr){
				throw new Exception("dummy exception");
			}			
		}
		catch(Exception e){
			e.printStackTrace();
			bar(0);
		}
		finally{
			finallyDummy();
		}
		bar(1);
		System.out.println("END");
		
	}
	
	protected void bar(int intFoo ){
		System.out.println("bar says: " + intFoo);
	}
	
	protected void finallyDummy(){
		System.out.println("Finally");
	}

}
