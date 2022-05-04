package net.lyncas.service;


import net.lyncas.dtos.AuthDto;
import net.lyncas.dtos.PersonDto;
import net.lyncas.dtos.PersonResponseDto;
import net.lyncas.entities.PersonEntity;
import net.lyncas.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<PersonResponseDto> findAll() {
        List<PersonEntity> entities = personRepository.findAll();
        List<PersonResponseDto> responseDtos = new ArrayList<>();
        for (int i = 0; i < entities.size(); i++) {
            PersonEntity entity = entities.get(i);
            PersonResponseDto personResponseDto = new PersonResponseDto(entity);
            responseDtos.add(personResponseDto);
        }
        return responseDtos;
    }

    public PersonEntity findById(Long personId) throws Exception {
        return personRepository.findById(personId)
                .orElseThrow(() -> new Exception("Usuário não encontrado."));
    }

    public PersonResponseDto saveUser(PersonDto personDto, AuthDto authDto) {
        PersonEntity personEntity = new PersonEntity(personDto);
        PersonEntity newPersonEntity = personRepository.save(personEntity);
        PersonResponseDto newPersonResponseDto = new PersonResponseDto(newPersonEntity);
        return newPersonResponseDto;
    }

    public PersonResponseDto updateUser(Long personId, PersonDto updatingPersonDto) throws Exception {
        Optional<PersonEntity> byId = personRepository.findById(personId);
        if(byId.isPresent()){
            PersonEntity personEntity = byId.get();
            personEntity.setName(updatingPersonDto.getName());
            personEntity.setLastname(updatingPersonDto.getLastname());
            personEntity.setEmail(updatingPersonDto.getEmail());
            personEntity.setPhone(updatingPersonDto.getPhone());
            personEntity.setBirthDate(updatingPersonDto.getBirthDate());
            personRepository.save(personEntity);
            PersonResponseDto updated = new PersonResponseDto(personEntity);
            return updated;
        } else {
            throw new Exception("Usuário não encontrado.");
        }
   }

    public void delete(Long personId){
        Optional<PersonEntity> personEntity = personRepository.findById(personId);
            personRepository.delete(personEntity.get());
    }
}
