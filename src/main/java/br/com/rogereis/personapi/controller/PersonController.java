package br.com.rogereis.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rogereis.personapi.controller.dto.response.MessageResponseDTO;
import br.com.rogereis.personapi.model.Person;
import br.com.rogereis.personapi.service.PersonService;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {
	
	private PersonService personService;
		
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody Person person) {
		Person savedPerson = personService.createPerson(person);
		return MessageResponseDTO.builder()
				.message("Created person with ID " + savedPerson.getId())
				.build();
	}

}
