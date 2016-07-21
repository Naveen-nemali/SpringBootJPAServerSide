package hello.dao;
import hello.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PersonDAO extends JpaRepository<Person, Long>{
    
    //boolean personExists(String name, String location);
}
 