package br.uff.sistema_energia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.uff.sistema_energia.entities.Terceirizada;

public interface TerceirizadaRepository extends JpaRepository<Terceirizada, Long> {

	@Query(name = "Terceirizada.findByCidade")
	List<Terceirizada> findByCidade(@Param("cidade") String cidade);

	@Query("SELECT t FROM Terceirizada t WHERE t.numeroAtendimentos > :minAtendimentos")
	List<Terceirizada> findByMinAtendimentos(@Param("minAtendimentos") int minAtendimentos);
}
