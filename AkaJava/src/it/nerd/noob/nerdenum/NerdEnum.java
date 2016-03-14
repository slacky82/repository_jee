package it.nerd.noob.nerdenum;

//TEST GIT
public class NerdEnum {
	public enum UserStatus {
		PENDING(100,"A"), ACTIVE(200,"B");

		private int code;
		private String stringCode;

		private UserStatus(int code, String stringCode) {
			this.code = code;
			this.stringCode = stringCode; 
		}

		public String getStatusCode() {
			return stringCode;
		}
		public int getCode(){
			return code;
		}
	}
	
	

}
