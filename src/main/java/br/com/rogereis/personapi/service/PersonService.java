package br.com.rogereis.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.rogereis.personapi.controller.dto.response.MessageResponseDTO;
import br.com.rogereis.personapi.model.Person;
import br.com.rogereis.personapi.repository.PersonRepository;

@Service
public class PersonService {
	
private PersonRepository personRepository;
	
	
	@Autowired
	public PersonService(PersonRepository personRepository) {		
		this.personRepository = personRepository;
	}
	
	public Person createPerson(@RequestBody Person person) {
		return personRepository.save(person);		
	}

}
