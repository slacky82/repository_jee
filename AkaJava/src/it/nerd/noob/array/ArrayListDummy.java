package it.nerd.noob.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ArrayListDummy {

	public static void main(String[] args) {		
		String customerSpecialLabelAllowed = ",123,124,6,";
		String target ="6";
		
		//method1
		try {
			String[] customerSpecialLabelSplitted = StringUtils.split(customerSpecialLabelAllowed, ',');
			List<String> customerSpecialLabelList = new ArrayList<String>(Arrays.asList(customerSpecialLabelSplitted));
			if (customerSpecialLabelList.contains(target)) {
				System.out.println("METHOD1 says: yes");
			} else {
				System.out.println("METHOD1 says: no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//method2
		try {
			if (StringUtils.contains(customerSpecialLabelAllowed, target)) {
				System.out.println("METHOD2 says: yes");
			} else {
				System.out.println("METHOD2 says: no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
