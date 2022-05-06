package net.lyncas.dtos;

import net.lyncas.entities.PersonEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PersonResponseDto {

    private Long personId;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private LocalDate birth_date;
    private Boolean status;

    public PersonResponseDto(){
    }

    public PersonResponseDto(PersonEntity personEntity) {
        this.personId = personEntity.getPersonId();
        this.name = personEntity.getName();
        this.lastname = personEntity.getLastname();
        this.email = personEntity.getEmail();
        this.phone = personEntity.getPhone();
        this.birth_date = personEntity.getBirth_date();
        this.status = personEntity.getAuthentication().getStatus();
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}