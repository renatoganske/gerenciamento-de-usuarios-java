package net.lyncas.entities;

import net.lyncas.dtos.PersonDto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="Person")
public class PersonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personId", nullable = false)
    private Long personId;
    @Column(nullable = false, length = 45 )
    @NotEmpty(message = "Preencha o nome.")
    private String name;
    @Column(nullable = false, length = 45)
    @NotEmpty(message = "Preencha o sobrenome.")
    private String lastname;
    @Column(nullable = false, unique = true, length = 45)
    @NotEmpty(message = "Preencha um email válido.")
    private String email;
    @Column(nullable = false, length = 14)
    @NotEmpty(message = "Preencha o telefone.")
    private String phone;
    @Column(nullable = false)
    @NotNull(message = "Preencha a data de nascimento.")
    private LocalDate birth_date;
    @OneToOne (mappedBy = "personEntity", cascade = CascadeType.ALL)
    private AuthenticationEntity authentication;

    public PersonEntity() {
    }

    public PersonEntity(PersonDto personDto, Boolean status){
        this.personId = personDto.getPersonId();
        this.name = personDto.getName();
        this.lastname = personDto.getLastname();
        this.email = personDto.getEmail();
        this.phone = personDto.getPhone();
        this.birth_date = personDto.getBirth_date();
        AuthenticationEntity auth = new AuthenticationEntity();
        auth.setPassword(personDto.getAuth().getPassword());
        auth.setPersonEntity(this);
        auth.setStatus(status);
        this.authentication = auth;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setpersonId(Long personId) {
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

    public AuthenticationEntity getAuthentication() {
        return authentication;
    }

    public void setAuthentication(AuthenticationEntity authentication) {
        this.authentication = authentication;
    }
}
