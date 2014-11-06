package it.nerd.avoid.nullpointer;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AvoidNullPointer {
	
	protected  Boolean isFinished(String status){
		if (status.equalsIgnoreCase("finish")){
				return Boolean.TRUE;
		}
		else{
			return Boolean.FALSE;
		}
	}	
	
	protected  Boolean avoidNullIsFinished(String status){
		if ("finisch".equalsIgnoreCase(status)){
				return Boolean.TRUE;
		}
		else{
			return Boolean.FALSE;
		}
	}
	
	protected List avoidNullGetEmptyEmployees(){
		List list = Collections.EMPTY_LIST;
		return list;		
	}
	
	protected List getEmptyEmployees(){
		List list = null;
		return list;		
	}
	
	protected String avoidNullPointerGetManager(String employeeId){
		//bosogna abilitare le ssertion con il comando -enableassertion
		assert(employeeId!=null):"employeeId must be not null!!";
		return "Fabrizio Gerina";
	}
	
	
	
	protected void test() {
		String myName = "fabrizio";
		System.out.println("contains "+avoidNullGetEmptyEmployees().contains(myName)); 
		System.out.println("indexOf "+avoidNullGetEmptyEmployees().indexOf(myName));
		System.out.println("isEmpty "+avoidNullGetEmptyEmployees().isEmpty()); 
		System.out.println("isEmpty null "+getEmptyEmployees().isEmpty()); 
	}
	

}
