package com.qsp.springboot_hospitalManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.springboot_hospitalManagement.Dao.PersonDao;
import com.qsp.springboot_hospitalManagement.Dto.Person;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;

@Service
public class PersonService {
	@Autowired
	private PersonDao dao;

	public ResponceStructure<Person> savePerson(Person person) {
		// TODO Auto-generated method stub
		 ResponceStructure<Person> structure = new ResponceStructure<>();
		 structure.setMessage(" Save Person Successufuly");
		 structure.setStatus(HttpStatus.CREATED.value());
		 structure.setData(dao.savePerson(person));
		 return structure;
		 
	}

	public ResponceStructure<Person> getPerson(int id) {
		// TODO Auto-generated method stub
		Person person = dao.getPerson(id);
		ResponceStructure<Person> structure = new ResponceStructure<>();
		if(person!=null)
	{
			 structure.setMessage("  Person FOUND Successufuly");
			 structure.setStatus(HttpStatus.FOUND.value());
			 structure.setData(person);
			 return structure;
	}
		else
		{
			 structure.setMessage("Person NOT FOUND  Successufuly");
			 structure.setStatus(HttpStatus.NOT_FOUND.value());
			 structure.setData(person);
			 return structure;
		}
	}

	public ResponceStructure<Person> deletePerson(int id) {
		// TODO Auto-generated method stub
		Person person= dao.deletePerson(id);
		ResponceStructure<Person> structure = new ResponceStructure<>();
		if(person!=null)
	{
			 structure.setMessage("  Person Deleted Successufuly");
			 structure.setStatus(HttpStatus.OK.value());
			 structure.setData(person);
			 return structure;
	}
		else
		{
			 structure.setMessage(" Person NOT FOUND  Successufuly");
			 structure.setStatus(HttpStatus.NOT_FOUND.value());
			 structure.setData(person);
			 return structure;
		}
		
	}

	public Person updatePerson(int id, Person person) {
		// TODO Auto-generated method stub
		return dao.updatePerson(id , person);
	}

	public Person getPersonByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.getPersonByEmail(email);
	}



}
