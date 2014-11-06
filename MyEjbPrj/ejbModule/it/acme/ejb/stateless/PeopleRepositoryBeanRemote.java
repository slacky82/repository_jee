package it.acme.ejb.stateless;

import it.acme.data.dto.PersonDTO;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface PeopleRepositoryBeanRemote {
	
	public List<PersonDTO> findPeople(Boolean like);

}
