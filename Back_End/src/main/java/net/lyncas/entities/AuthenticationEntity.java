package net.lyncas.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Authentication")
public class AuthenticationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuth;

    @NotEmpty
    @Column(length = 255, nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean status;

    @OneToOne
    @JoinColumn(name = "personId", nullable = false)
    private PersonEntity personEntity;

    public Long getIdAuth() {
        return idAuth;
    }

    public void setIdAuth(Long idAuth) {
        this.idAuth = idAuth;
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

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }
}
