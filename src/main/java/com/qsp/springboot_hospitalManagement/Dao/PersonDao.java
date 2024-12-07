package com.qsp.springboot_hospitalManagement.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_hospitalManagement.Dto.Hospital;
import com.qsp.springboot_hospitalManagement.Dto.Person;
import com.qsp.springboot_hospitalManagement.Repository.Personrepo;

@Repository
public class PersonDao {
	@Autowired
	private Personrepo repo;

	public Person savePerson(Person person) {
		// TODO Auto-generated method stub
		return repo.save(person);
	}

	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		Optional<Person> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();

		}
		return null;
	}

	public Person deletePerson(int id) {
		// TODO Auto-generated method stub
		// return null;
		Optional<Person> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;

	}

	public Person updatePerson(int id, Person person) {
		// TODO Auto-generated method stub
		// return null;
		Optional<Person> optional = repo.findById(id);
		if (optional.isPresent()) {
			person.setId(id);
			return repo.save(person);
		}
		return null;
	}

	public Person getPersonByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findPersonByEmail(email);
	}

}
