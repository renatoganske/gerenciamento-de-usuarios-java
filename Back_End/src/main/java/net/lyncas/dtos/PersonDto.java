package net.lyncas.dtos;


import net.lyncas.entities.PersonEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PersonDto {

    private Long personId;
    @NotEmpty(message = "Campo obrigatório.")
    @Length(min = 3, max = 45, message = "Digite um nome válido.")
    private String name;
    @NotEmpty(message = "Campo obrigatório.")
    @Length(min = 3, max = 45, message = "Digite um sobrenome válido.")
    private String lastname;
    @NotEmpty(message = "Campo obrigatório.")
    @Length(min = 3, max = 45, message = "Digite um email válido.")
    private String email;
    @NotEmpty(message = "Campo obrigatório.")
    @Length(min = 3, max = 14, message = "Digite um telefone válido.")
    private String phone;
    @NotNull(message = "Cadastre uma data de nascimento válida.")
    private LocalDate birth_date;
    @NotNull
    @Valid
    private AuthDto auth;

    public PersonDto(){
    }

    public PersonDto(PersonEntity personEntity){
        this.personId = personEntity.getPersonId();
        this.name = personEntity.getName();
        this.lastname = personEntity.getLastname();
        this.email = personEntity.getEmail();
        this.phone = personEntity.getPhone();
        this.birth_date = personEntity.getBirth_date();
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public AuthDto getAuth() {
        return auth;
    }

    public void setAuth(AuthDto auth) {
        this.auth = auth;
    }
}

