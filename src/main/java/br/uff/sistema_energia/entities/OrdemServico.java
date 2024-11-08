package br.uff.sistema_energia.entities;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@ManyToMany
	@JoinTable(name = "ordem_cliente", joinColumns = @JoinColumn(name = "ordem_id"), inverseJoinColumns = @JoinColumn(name = "cliente_id"))
	private Set<Cliente> clientes;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraAbertura;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraEncerramento;

	@Column(nullable = true)
	private Integer codigoPrioridade;

}