package br.uff.sistema_energia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.uff.sistema_energia.entities.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
	
	@Query(name = "OrdemServico.findByStatusAberta")
    List<OrdemServico> findByStatusAberta();

    @Query(name = "OrdemServico.findByPrioridadeAlta")
    List<OrdemServico> findByPrioridadeAlta();

    @Query("SELECT o FROM OrdemServico o WHERE o.dataHoraEncerramento IS NOT NULL")
    List<OrdemServico> findEncerradas();
}
