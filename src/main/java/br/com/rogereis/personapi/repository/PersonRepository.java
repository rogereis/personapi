package br.com.rogereis.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rogereis.personapi.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
