package net.lyncas.entities;

import net.lyncas.dtos.PersonDto;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Person")
public class PersonEntity {

    public PersonEntity() {
    }

    public PersonEntity(PersonDto personDto){
        this.personId = personDto.getPersonId();
        this.name = personDto.getName();
        this.lastname = personDto.getLastname();
        this.email = personDto.getEmail();
        this.phone = personDto.getPhone();
        this.birthDate = personDto.getBirthDate();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPessoa", nullable = false)
    private Long personId;
    @Column(nullable = false, length = 45 )
    private String name;
    @Column(nullable = false, length = 45)
    private String lastname;
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(nullable = false, length = 14)
    private String phone;
    @Column(nullable = false)
    private LocalDate birthDate;
    @OneToOne (mappedBy = "personEntity", cascade = CascadeType.ALL)
    private AuthenticationEntity authentication;

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
