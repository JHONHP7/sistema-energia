package br.uff.sistema_energia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.uff.sistema_energia.entities.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
}
