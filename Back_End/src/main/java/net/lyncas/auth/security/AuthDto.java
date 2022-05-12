package net.lyncas.auth.security;

import net.lyncas.entities.PersonEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

public class AuthDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuth;
    private String  email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "A senha deve conter no mínimo 6 caracteres, "
            + "sendo pelo menos um deles um número.")
    @Length(min = 6, max = 50, message = "Digite uma senha válida.")
    private String password;

    private Boolean status;

    public Long getIdAuth() {
        return idAuth;
    }

    public void setIdAuth(Long idAuth) {
        this.idAuth = idAuth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
