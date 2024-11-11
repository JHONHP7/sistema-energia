package br.uff.sistema_energia.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "Equipe.findByTerceirizada", query = "SELECT e FROM Equipe e WHERE e.terceirizada.codigo = :terceirizadaCodigo")
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "terceirizada_codigo", nullable = false)
	private Terceirizada terceirizada;

	@Column(nullable = false)
	private int quantidadeFuncionarios;
}
