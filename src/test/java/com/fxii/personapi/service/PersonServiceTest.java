package com.fxii.personapi.service;

import com.fxii.personapi.dto.MessageResponseDTO;
import com.fxii.personapi.dto.mapper.PersonMapper;
import com.fxii.personapi.dto.request.PersonDTO;
import com.fxii.personapi.entity.Person;
import com.fxii.personapi.repositories.PersonRepository;
import com.fxii.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.fxii.personapi.utils.PersonUtils.createFakeDTO;
import static com.fxii.personapi.utils.PersonUtils.createFakeEntity;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavePerson = createFakeEntity();

        Mockito.when(personMapper.toModel(personDTO)).thenReturn(expectedSavePerson);
        Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(expectedSavePerson);

        MessageResponseDTO expectedMessageDTO = createExpectedMessage(expectedSavePerson);
        MessageResponseDTO messageResponseDTO = personService.createPerson(personDTO);

        Assertions.assertEquals(expectedMessageDTO, messageResponseDTO);
    }

    private MessageResponseDTO createExpectedMessage(Person expectedSavePerson) {
        return MessageResponseDTO.builder()
                .message(String.format("Created person %s with ID %d", expectedSavePerson.getFirstName(), expectedSavePerson.getId()))
                .build();
    }
}
