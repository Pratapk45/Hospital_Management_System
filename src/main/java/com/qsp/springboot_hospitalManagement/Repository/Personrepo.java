package com.qsp.springboot_hospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.springboot_hospitalManagement.Dto.Person;

public interface Personrepo extends JpaRepository<Person, Integer> {

	Person findPersonByEmail(String email);

}
