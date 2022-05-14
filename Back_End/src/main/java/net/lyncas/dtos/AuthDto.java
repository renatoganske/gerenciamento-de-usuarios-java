package net.lyncas.dtos;

import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AuthDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuth;
    private String  email;

    @NotEmpty(message = "{required.password.validation}")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "{password.rule}")
    @Length(min = 6, max = 50, message = "{size.validation}")
    private String password;

    private Boolean status;

    public AuthDto() {
    }

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
