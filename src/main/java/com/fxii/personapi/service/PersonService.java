package com.fxii.personapi.service;

import com.fxii.personapi.dto.MessageResponseDTO;
import com.fxii.personapi.entity.Person;
import com.fxii.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) {
        Person p = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message(String.format("Created person %s with ID %d", p.getFirstName(), p.getId()))
                .build();
    }
}
