package br.uff.sistema_energia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.uff.sistema_energia.entities.ClienteVital;

public interface ClienteVitalRepository extends JpaRepository<ClienteVital, Long> {

    @Query(name = "ClienteVital.findByCodigoPrioridade")
    List<ClienteVital> findByCodigoPrioridade(@Param("codigoPrioridade") int codigoPrioridade);

    @Query("SELECT v FROM ClienteVital v WHERE v.tempoMaximoSemEnergia <= :tempoMaximo")
    List<ClienteVital> findByMaxTempoSemEnergia(@Param("tempoMaximo") int tempoMaximo);

    @Query("SELECT v FROM ClienteVital v WHERE v.tempoMaximoSemEnergia <= :tempoMaximo")
    List<ClienteVital> findClientesVitaisByTempoMaximoSemEnergia(@Param("tempoMaximo") int tempoMaximo);
}
