package hello.service.impl;

import hello.dao.AddressDAO;
import hello.dao.PersonDAO;
import hello.entity.Person;
import hello.service.PersonService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDAO personDAO;
	@Autowired
  private AddressDAO addressDAO;
	@Override
	public Person getPersonById(int pid) {
	    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%% came to DAO ");
		Person obj = personDAO.findOne(new Long(pid));
		return obj;
	}	
	@Override
	public List<Person> getAllPersons(){
		return (List<Person>) personDAO.findAll();
	}
	@Override
	public synchronized boolean addPerson(Person person){
	    addressDAO.save(person.getAddress());
    	   personDAO.save(person);
    	   return true;
	}
	/*@Override
	public void updatePerson(Person person) {
		personDAO.updatePerson(person);
	}*/
	@Override
	public void deletePerson(int pid) {
		personDAO.delete((long) pid);
	}
}
