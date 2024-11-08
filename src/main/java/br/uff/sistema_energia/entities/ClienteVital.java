package br.uff.sistema_energia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("VITAL")
public class ClienteVital extends Cliente {

	@Column(nullable = false)
	private int tempoMaximoSemEnergia;

	@Column(nullable = false)
	private int codigoPrioridade;

}