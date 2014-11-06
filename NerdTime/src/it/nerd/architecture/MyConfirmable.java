package it.nerd.architecture;

public class MyConfirmable implements IConfirmable {
	
	//un qualsiasi MANAGED_BEAN che deve usare una popup	
	
	
	public MyConfirmable(){		
	}
	
	//........

	@Override
	public String yesAction() {
		// TODO Auto-generated method stub
		return "YES_ACTION";
	}

	@Override
	public String noAction() {
		// TODO Auto-generated method stub
		return "NO_ACTION";
	}

	@Override
	public String getHeader() {
		// TODO Auto-generated method stub
		return "MY_HEADER";
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "RETURN MY_MESSAGE";
	}
	
	
	
	
	
	

}
