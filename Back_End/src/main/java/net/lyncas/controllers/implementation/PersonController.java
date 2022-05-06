package net.lyncas.controllers.implementation;

import net.lyncas.dtos.PersonDto;

import net.lyncas.dtos.PersonResponseDto;
import net.lyncas.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/users")
public class PersonController {

    @Autowired
    private PersonService service;

    public PersonController(PersonService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PersonResponseDto>> findAll (){
        List<PersonResponseDto> listarPersonResponseDto = service.findAll();
        return ResponseEntity.ok().body(listarPersonResponseDto);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonResponseDto> findById(@PathVariable Long personId) {

        try{
            return new ResponseEntity<>(service.findById(personId), HttpStatus.OK);}

        catch(Exception exp){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/newUser")
    public ResponseEntity<PersonResponseDto> saveUser(
            @Valid @RequestBody PersonDto newPersonDTO){
        PersonResponseDto persistedPerson = service.saveUser(newPersonDTO, true);
        return new ResponseEntity<>(persistedPerson, HttpStatus.OK);
    }

    @PutMapping("/{personId}")
    public ResponseEntity<PersonResponseDto> updateUser(
            @PathVariable Long personId,
            @Valid@RequestBody PersonDto personDto) {

        PersonResponseDto personResponseDto = null;
        try {
            personResponseDto = service.updateUser(personId, personDto);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(personResponseDto);
    }

    @DeleteMapping("/{personId}")
    public void delete(@PathVariable Long personId){
        service.delete(personId);
    }
}
