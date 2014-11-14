package it.acme.ejb.stateless;

import it.acme.data.dto.PersonDTO;
import it.acme.interceptors.AInt;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 * Session Bean implementation class PeopleRepositoryBean
 */
@Stateless(mappedName = "peopleRepositoryEJB")
public class PeopleRepositoryBean implements PeopleRepositoryBeanRemote, PeopleRepositoryBeanLocal {

   private List<PersonDTO> listPerson;
	
    public PeopleRepositoryBean() {    	
    }
    
    @PostConstruct
    private void initListPeople(){
    	System.out.println("#peopleRepositoryEJB: @PostConstruct CALLED!");
    	listPerson = new ArrayList<PersonDTO>();
    	for (int i = 0; i <10; i++) {
    		PersonDTO dummyObj =  ((i%2==0) ? new PersonDTO("nameObj"+i,true) : new PersonDTO("nameObj"+i,false));
    		listPerson.add(dummyObj);			
		}
	}

	@Override
	@Interceptors(AInt.class)
	public List<PersonDTO> findPeople(Boolean like) {
		if(like==null){
			return listPerson;
		}
		
		List<PersonDTO> listDummy= new ArrayList<PersonDTO>();
		for (PersonDTO currObj : listPerson) {
			if(currObj.getLike().equals(like)){
				listDummy.add(currObj);
			}
		}
		return listDummy;		
	}

	
    
    
    

}
