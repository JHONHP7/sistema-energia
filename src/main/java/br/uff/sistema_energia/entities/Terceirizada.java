package br.uff.sistema_energia.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "Terceirizada.findByCidade", query = "SELECT t FROM Terceirizada t WHERE t.cidade = :cidade")
public class Terceirizada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private int numeroAtendimentos;
}
