package net.lyncas.dtos;

import net.lyncas.entities.PersonEntity;

import java.time.LocalDate;

public class UpdatePersonDto {

    public UpdatePersonDto() {

    }

    public UpdatePersonDto(PersonEntity personEntity) {
        this.personId = personEntity.getPersonId();
        this.name = personEntity.getName();
        this.lastname = personEntity.getLastname();
        this.email = personEntity.getEmail();
        this.phone = personEntity.getPhone();
        this.birthDate = personEntity.getBirthDate();
    }

    private Long personId;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String senha;
    private Boolean status;

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
