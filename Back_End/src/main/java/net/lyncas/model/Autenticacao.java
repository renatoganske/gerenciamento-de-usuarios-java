package net.lyncas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Autenticacao")
public class Autenticacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuth;
    @Column(length = 255, nullable = false)
    private String senha;
    @Column(nullable = false)
    private Boolean status;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;
}
