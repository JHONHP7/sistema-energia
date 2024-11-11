package br.uff.sistema_energia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.uff.sistema_energia.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	
	@Query(name = "Equipe.findByTerceirizada")
    List<Equipe> findByTerceirizada(@Param("terceirizadaCodigo") Long terceirizadaCodigo);

    @Query("SELECT e FROM Equipe e WHERE e.quantidadeFuncionarios > :minFuncionarios")
    List<Equipe> findByMinFuncionarios(@Param("minFuncionarios") int minFuncionarios);
}	