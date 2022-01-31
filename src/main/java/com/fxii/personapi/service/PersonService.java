package com.fxii.personapi.service;

import com.fxii.personapi.dto.MessageResponseDTO;
import com.fxii.personapi.dto.mapper.PersonMapper;
import com.fxii.personapi.dto.request.PersonDTO;
import com.fxii.personapi.entity.Person;
import com.fxii.personapi.exception.PesonNotFoundException;
import com.fxii.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        // convert DTO to Model
        Person person = personMapper.toModel(personDTO);

        Person p = personRepository.save(person);
        return createMessageResponseDTO(p, "Created");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PesonNotFoundException {
        Person p = verifyIfExists(id);

        return personMapper.toDTO(p);
    }

    public void deleteById(Long id) throws PesonNotFoundException {
        verifyIfExists(id);

        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PesonNotFoundException {
        verifyIfExists(id);

        Person person = personMapper.toModel(personDTO);

        Person p = personRepository.save(person);
        return createMessageResponseDTO(p, "Updated");
    }

    private Person verifyIfExists(Long id) throws PesonNotFoundException {
        return personRepository.findById(id).
                orElseThrow(() -> new PesonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponseDTO(Person person, String message) {
        return MessageResponseDTO
                .builder()
                .message(String.format(message + " person %s with ID %d", person.getFirstName(), person.getId()))
                .build();
    }
}
