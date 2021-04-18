package br.com.rogereis.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.rogereis.personapi.dto.request.PersonDTO;
import br.com.rogereis.personapi.dto.response.MessageResponseDTO;
import br.com.rogereis.personapi.exception.PersonNotFoundException;
import br.com.rogereis.personapi.mapper.PersonMapper;
import br.com.rogereis.personapi.model.Person;
import br.com.rogereis.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
	
	private PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;
		
	public MessageResponseDTO createPerson(@RequestBody PersonDTO personDTO) {
		
		Person person = personMapper.toModel(personDTO);
		
		Person savedPerson = personRepository.save(person);
		
		return createMessageResponse(savedPerson.getId(), "Created person with ID ");		
	}

	public List<PersonDTO> listAll() {		
		List<Person> allPersons = personRepository.findAll();
		return allPersons.stream().map(personMapper::toDTO).collect(Collectors.toList());
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
		
		Person person = verifyIfExists(id);
				
		return personMapper.toDTO(person);
		
	}

	public void deleteById(Long id) throws PersonNotFoundException {
		verifyIfExists(id);
		
		personRepository.deleteById(id);
	}

	public MessageResponseDTO updateById(Long id, @Valid PersonDTO personDTO) throws PersonNotFoundException {
		
		verifyIfExists(id);
		
		Person personToUpdate = personMapper.toModel(personDTO);
		
		Person updatedPerson = personRepository.save(personToUpdate);
		
		return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");		
	}
	
	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}

	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO.builder()
				.message(message + id)
				.build();
	}

}
