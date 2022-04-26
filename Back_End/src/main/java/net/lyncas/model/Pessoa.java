package net.lyncas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Pessoa")
public class Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPessoa", nullable = false)
    private Long idPessoa;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private LocalDate dataDeNascimento;
    @OneToOne (mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Autenticacao autenticacao;
}
