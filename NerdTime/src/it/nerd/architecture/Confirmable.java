package it.nerd.architecture;

public class Confirmable {
	
	private String message;
	private String header;
	
	//MANAGEDBEAN confirmable
	private IConfirmable iconfimrable;
	
	public void showConfirmablePopup(IConfirmable iconfirmable){
		
		setIconfimrable(iconfirmable);
		setMessage(iconfimrable.getMessage());
		setHeader(iconfimrable.getHeader());	
		
		System.out.println("POPUP_IS_SHOWED");
		System.out.println(getMessage());
		System.out.println(getHeader());
		System.out.println(iconfimrable.yesAction());
		System.out.println(iconfimrable.noAction());		
	}	
	
	public String yesAction(){
		return iconfimrable.yesAction();
	}
	public String noAction(){
		return iconfimrable.noAction();
	}
	
	//Getter/mutator


	public void setIconfimrable(IConfirmable iconfimrable) {
		this.iconfimrable = iconfimrable;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}
	
	
	
	
	
	
	

}
