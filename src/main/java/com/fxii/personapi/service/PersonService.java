package com.fxii.personapi.service;

import com.fxii.personapi.dto.MessageResponseDTO;
import com.fxii.personapi.dto.request.PersonDTO;
import com.fxii.personapi.entity.Person;
import com.fxii.personapi.dto.mapper.PersonMapper;
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
        return MessageResponseDTO
                .builder()
                .message(String.format("Created person %s with ID %d", p.getFirstName(), p.getId()))
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
}
