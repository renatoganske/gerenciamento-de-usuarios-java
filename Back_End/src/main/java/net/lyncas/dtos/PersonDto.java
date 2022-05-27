package net.lyncas.dtos;


import net.lyncas.entities.AuthenticationEntity;
import net.lyncas.entities.PersonEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class PersonDto {

    private Long personId;
    @NotEmpty(message = "required.name.validation")
    @Size(min = 3, max = 45, message = "size.validation")
    private String name;

    @NotEmpty(message = "required.lastname.validation")
    @Length(min = 3, max = 45, message = "size.validation")
    private String lastname;

    @NotEmpty(message = "required.email.validation")
    @Length(min = 3, max = 45)
    @Email(regexp = ".+[@].+[\\.].+", message = "{size.validation}")
    private String email;

    @NotEmpty(message = "required.phone.validation")
    @Length(min = 3, max = 14, message = "size.validation")
    private String phone;

    @NotNull(message = "required.birth_date.validation")
    private LocalDate birthDate;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "{password.rule}")
    @Length(min = 6, max = 50, message = "{size.validation}")
    private String password;

    private Boolean status;

    private AuthenticationEntity auth;

    public PersonDto() {
    }

    public PersonDto(PersonEntity personEntity) {
        this.personId = personEntity.getPersonId();
        this.name = personEntity.getName();
        this.lastname = personEntity.getLastname();
        this.email = personEntity.getEmail();
        this.phone = personEntity.getPhone();
        this.birthDate = personEntity.getBirthDate();
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirth_date(LocalDate birthDate) {
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

    public AuthenticationEntity getAuth() {
        return auth;
    }

    public void setAuth(AuthenticationEntity auth) {
        this.auth = auth;
    }
}

