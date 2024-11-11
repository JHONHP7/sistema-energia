package br.uff.sistema_energia.entities;

import br.uff.sistema_energia.entities.abstratas.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("REGULAR")
@NamedQueries({
		@NamedQuery(name = "ClienteRegular.findByCpf", query = "SELECT c FROM ClienteRegular c WHERE c.cpf = :cpf"),
		@NamedQuery(name = "ClienteRegular.findAllOrdensServico", query = "SELECT c.ordensServico FROM ClienteRegular c WHERE c.cpf = :cpf") })
public class ClienteRegular extends Cliente {

	@Column(nullable = true)
	private int tempoMaximoSemEnergia;

	@Min(1)
	@Max(3)
	@Column(nullable = true)
	private Integer codigoPrioridade;

	@PrePersist
	public void prePersist() {
		if (this.codigoPrioridade == null) {
			this.codigoPrioridade = 1;
		}
		if (this.tempoMaximoSemEnergia == 0) {
			this.tempoMaximoSemEnergia = 1;
		}
	}
}
