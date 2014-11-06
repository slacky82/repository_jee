package org.icefaces.template.tab;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.icefaces.template.tab.model.Person;

@ManagedBean
@SessionScoped
public class MenuBarBean implements Serializable{

	private static final long serialVersionUID = 1066567223439036231L;
	private final String MenuBarId = "menuBar";
	private List<Person> tableData;
	private String[] firstNames = {"Matthew", "Paul", "Bob", "Tam", "Dave", "Perry", "Denis", "Dan", "Simon", "Chris"};
	private String[] lastNames = {"Wood", "Cooper", "Hill", "Truck", "Cowell", "Norris", "Sandler", "Barlow", "Coffee", "Zimmerman"};
	
	@PostConstruct
	public void init()
	{
		// Generate a list of people
		tableData =  new LinkedList<Person>();
		for (int i = 1; i<= 500; i++)
		{
			tableData.add(new Person(i, firstNames[new Random().nextInt(10)], lastNames[new Random().nextInt(10)], "100 Main Street", "Toronto", "Ontario", "K1A 0T6", "416-555-1122", "416-555-7788", "416-995-8855", "cowemat", "secret", "2012-Aug-21"));
		}
		
	}
	public String getMenuBarId() {
		return MenuBarId;
	}
	public List<Person> getTableData() {
		return tableData;
	}
	public void setTableData(List<Person> tableData) {
		this.tableData = tableData;
	}

}
