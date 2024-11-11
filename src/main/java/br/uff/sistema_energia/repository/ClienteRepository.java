package br.uff.sistema_energia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.uff.sistema_energia.entities.abstratas.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(name = "Cliente.findByCpf")
    Cliente findByCpf(@Param("cpf") String cpf);

    @Query(name = "Cliente.findAllOrdensServico")
    List<Cliente> findAllOrdensServico(@Param("cpf") String cpf);

    @Query("SELECT c FROM Cliente c WHERE SIZE(c.ordensServico) > 0")
    List<Cliente> findClientesWithOpenOrdens();
}
