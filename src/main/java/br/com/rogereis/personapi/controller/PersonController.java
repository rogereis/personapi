package br.com.rogereis.personapi.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rogereis.personapi.controller.dto.request.PersonDTO;
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
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		return personService.createPerson(personDTO);
	}

}
