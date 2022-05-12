package net.lyncas.service;


import net.lyncas.dtos.PersonDto;
import net.lyncas.dtos.PersonResponseDto;
import net.lyncas.entities.PersonEntity;
import net.lyncas.repository.PersonRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PasswordEncoder encoder;

    public PersonService(PersonRepository personRepository, PasswordEncoder encoder){
        this.personRepository = personRepository;
        this.encoder = encoder;
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

    public PersonResponseDto findById(Long personId) throws Exception {
        Optional<PersonEntity> personEntityById = personRepository.findById(personId);
        if (personEntityById.isPresent()) {
            PersonEntity personEntity = personEntityById.get();
            PersonResponseDto person = new PersonResponseDto(personEntity);
            return person;
        } else {
            throw new Exception("Usuário não encontrado.");
        }
    }


    public PersonResponseDto saveUser(PersonDto personDto, Boolean status) throws Exception {
        PersonEntity personEntity = new PersonEntity(personDto, status);
        if(personRepository.existsByEmail(personDto.getEmail())) {
            throw new Exception("Esse e-mail já existe.");
        }
        else {
            personEntity.getAuthentication().setPassword(encoder.encode(personEntity.getAuthentication().getPassword()));
            PersonEntity newPersonEntity = personRepository.save(personEntity);
            PersonResponseDto newPersonResponseDto = new PersonResponseDto(newPersonEntity);

            return newPersonResponseDto;
        }}

    public PersonResponseDto updateUser(Long personId, PersonDto updatingPersonDto) throws Exception {
        Optional<PersonEntity> userById = personRepository.findById(personId);
        if(userById.isPresent()){
            String password;
            if(updatingPersonDto.getAuth().getPassword() == null || updatingPersonDto.getAuth().getPassword().isEmpty()){
                password = userById.get().getAuthentication().getPassword();
            } else {
                password = updatingPersonDto.getAuth().getPassword();
            }

            PersonEntity personEntity = userById.get();
            personEntity.setpersonId(updatingPersonDto.getPersonId());
            personEntity.setName(updatingPersonDto.getName());
            personEntity.setLastname(updatingPersonDto.getLastname());
            personEntity.setEmail(updatingPersonDto.getEmail());
            personEntity.setPhone(updatingPersonDto.getPhone());
            personEntity.setBirth_date(updatingPersonDto.getBirth_date());
            personEntity.getAuthentication().setStatus(updatingPersonDto.getAuth().getStatus());
            personEntity.getAuthentication().setPassword(encoder.encode(password));
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
