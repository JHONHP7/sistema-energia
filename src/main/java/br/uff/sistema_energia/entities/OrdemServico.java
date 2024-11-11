package br.uff.sistema_energia.entities;

import java.time.Instant;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.uff.sistema_energia.entities.abstratas.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
    @NamedQuery(name = "OrdemServico.findByStatusAberta", query = "SELECT o FROM OrdemServico o WHERE o.dataHoraEncerramento IS NULL"),
    @NamedQuery(name = "OrdemServico.findByPrioridadeAlta", query = "SELECT o FROM OrdemServico o WHERE o.codigoPrioridade = 1")
})
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToMany
    @JoinTable(name = "ordem_cliente",
               joinColumns = @JoinColumn(name = "ordem_id"),
               inverseJoinColumns = @JoinColumn(name = "cliente_id"))
    @JsonManagedReference
    private Set<Cliente> clientes;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraAbertura;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraEncerramento;

    @Column(nullable = true)
    private Integer codigoPrioridade;
    
    @ManyToOne
    @JoinColumn(name = "equipe_codigo", nullable = false)
    private Equipe equipe;
    
    @PrePersist
    public void prePersist() {
        this.dataHoraAbertura = Date.from(Instant.now());
    }
}
