package net.lyncas.dtos;

import net.lyncas.entities.PersonEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AuthDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuth;
    @NotNull(message = "Campo obrigatório.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "A senha deve conter no mínimo 6 caracteres, "
            + "sendo pelo menos um deles um número.")
    @Length(min = 6, max = 50, message = "Digite uma senha válida.")
    public String password;

    private Boolean status;

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

    public PersonEntity get() {
        return null;
    }

}
