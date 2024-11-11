package br.uff.sistema_energia.entities.abstratas;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import br.uff.sistema_energia.entities.ClienteRegular;
import br.uff.sistema_energia.entities.ClienteVital;
import br.uff.sistema_energia.entities.OrdemServico;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_cliente", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({
    @NamedQuery(name = "Cliente.findByCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf"),
    @NamedQuery(name = "Cliente.findAllOrdensServico", query = "SELECT c.ordensServico FROM Cliente c WHERE c.cpf = :cpf")
})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo_cliente")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ClienteRegular.class, name = "REGULAR"),
    @JsonSubTypes.Type(value = ClienteVital.class, name = "VITAL")
})
public abstract class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String endereco;

    @JsonBackReference
    @ManyToMany(mappedBy = "clientes")
    private Set<OrdemServico> ordensServico;
}
