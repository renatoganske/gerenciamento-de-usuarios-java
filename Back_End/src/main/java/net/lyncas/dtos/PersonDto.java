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
    private LocalDate birth_date;


    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "{password.rule}")
    @Length(min = 6, max = 50, message = "{size.validation}")
    private String password;

    private Boolean status;

    private AuthenticationEntity auth;

    public PersonDto(){
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

