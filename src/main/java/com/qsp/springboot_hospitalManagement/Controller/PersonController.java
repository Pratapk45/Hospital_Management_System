package com.qsp.springboot_hospitalManagement.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_hospitalManagement.Dto.Hospital;
import com.qsp.springboot_hospitalManagement.Dto.Person;
import com.qsp.springboot_hospitalManagement.Service.PersonService;
import com.qsp.springboot_hospitalManagement.Util.ResponceStructure;

@RestController
public class PersonController {
	@Autowired
	private PersonService service;

	@PostMapping("/Person")
	public ResponceStructure<Person> savePerson(@Valid @RequestBody Person person) {
		return service.savePerson(person);

	}

	@GetMapping("/Person")
	public ResponceStructure<Person> getPerson(@RequestParam int id) {
		return service.getPerson(id);
	}

	@DeleteMapping("/Person")
	public ResponceStructure<Person> deletePerson(@RequestParam int id) {
		return service.deletePerson(id);

	}

	@PutMapping("/Person")
	public Person updatePerson(@RequestParam int id, @RequestBody Person person) {
		return service.updatePerson(id, person);

	}

	@GetMapping("/findPersonByEmail")
	public Person getPersonByEmail(@RequestParam String email) {
		return service.getPersonByEmail(email);

	}

}
