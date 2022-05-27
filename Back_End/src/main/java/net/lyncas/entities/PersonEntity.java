package net.lyncas.entities;

import net.lyncas.dtos.PersonDto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="Person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personId", nullable = false)
    private Long personId;
    @Column(nullable = false, length = 45 )
    @NotEmpty
    private String name;
    @Column(nullable = false, length = 45)
    @NotEmpty
    private String lastname;
    @Column(nullable = false, unique = true, length = 45)
    @NotEmpty
    private String email;
    @Column(nullable = false, length = 14)
    @NotEmpty
    private String phone;
    @Column(nullable = false)
    @NotNull
    private LocalDate birthDate;
    @OneToOne (mappedBy = "personEntity", cascade = CascadeType.ALL)
    private AuthenticationEntity authentication;

    public PersonEntity() {
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

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public AuthenticationEntity getAuthentication() {
        return authentication;
    }

    public void setAuthentication(AuthenticationEntity authentication) {
        this.authentication = authentication;
    }

}
