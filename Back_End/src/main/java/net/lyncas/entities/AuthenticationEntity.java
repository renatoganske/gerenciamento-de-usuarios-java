package net.lyncas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Authentication")
public class AuthenticationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuth;
    @Column(length = 255, nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean status;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPessoa")
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
