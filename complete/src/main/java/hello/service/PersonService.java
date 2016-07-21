package hello.service;

import hello.entity.Person;

import java.util.List;

public interface PersonService {
     List<Person> getAllPersons();
     Person getPersonById(int pid);
     boolean addPerson(Person person);
     //void updatePerson(Person person);
     void deletePerson(int pid);
}
