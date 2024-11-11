package br.uff.sistema_energia.entities;

import br.uff.sistema_energia.entities.abstratas.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@NamedQuery(name = "ClienteVital.findByCodigoPrioridade", query = "SELECT v FROM ClienteVital v WHERE v.codigoPrioridade = :codigoPrioridade")
public class ClienteVital extends Cliente {

    @Column(nullable = false)
    private int tempoMaximoSemEnergia;

    @Min(1)
    @Max(3)
    @Column(nullable = false)
    private int codigoPrioridade;
}
