package br.uff.sistema_energia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.uff.sistema_energia.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}