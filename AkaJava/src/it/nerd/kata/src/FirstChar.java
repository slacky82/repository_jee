package it.nerd.kata.src;


public class FirstChar {
	
	//BAD
	public  static char getFirstCharWithOccurrence(String text){
		char res = ' ';
		int[] reps = new int[text.length()];
		for (int i = 0; i < text.length(); i++) {
			for (int j = 0; j < text.length(); j++){
				int repeat = 0;
				if(text.charAt(i) == text.charAt(j)){
					reps[i]++;
				}				
			}		
		}
		for (int i = 0; i < reps.length; i++) {
			if(reps[i]==1)
				return text.charAt(i);
		}
		return ' ';
	}
	
	//GOOD
	public static char firstNonRepeatingChar(String str) {
		char c;
		int pos = 0;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			c = str.charAt(i);
			pos = str.indexOf(c);
			pos = str.indexOf(c, pos + 1);
			if (pos == -1) {
//				System.out.println("non repeating char : " + c);
//				break;
				return c;
			}			
		}
		return ' ';
	}
}
