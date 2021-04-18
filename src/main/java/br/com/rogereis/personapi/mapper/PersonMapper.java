package br.com.rogereis.personapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.rogereis.personapi.dto.request.PersonDTO;
import br.com.rogereis.personapi.model.Person;

@Mapper
public interface PersonMapper {
	
	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	
	PersonDTO toDTO(Person person);
	
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy" )
	Person toModel(PersonDTO personDTO);

}
