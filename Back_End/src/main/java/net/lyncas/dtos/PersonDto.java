package net.lyncas.dtos;



import net.lyncas.entities.PersonEntity;

import java.time.LocalDate;

public class PersonDto {

    private Long PersonId;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String password;
    private Boolean status;


    public PersonDto(){

    }

    public PersonDto(PersonEntity personEntity){
        this.PersonId = personEntity.getPersonId();
        this.name = personEntity.getName();
        this.lastname = personEntity.getLastname();
        this.email = personEntity.getEmail();
        this.phone = personEntity.getPhone();
        this.birthDate = personEntity.getBirthDate();
        this.status = personEntity.getAuthentication().getStatus();
    }

    public Long getPersonId() {
        return PersonId;
    }

    public void setPersonId(Long personId) {
        this.PersonId = personId;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

