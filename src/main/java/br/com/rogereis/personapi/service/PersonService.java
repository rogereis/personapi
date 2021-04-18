package br.com.rogereis.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.rogereis.personapi.dto.request.PersonDTO;
import br.com.rogereis.personapi.dto.response.MessageResponseDTO;
import br.com.rogereis.personapi.mapper.PersonMapper;
import br.com.rogereis.personapi.model.Person;
import br.com.rogereis.personapi.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;
		
	@Autowired
	public PersonService(PersonRepository personRepository) {		
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO) {
		
		Person person = personMapper.toModel(personDTO);
		
		Person savedPerson = personRepository.save(person);
		
		return MessageResponseDTO.builder()
				.message("Created person with ID " + savedPerson.getId())
				.build();		
	}

}
