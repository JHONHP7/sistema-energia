package br.uff.sistema_energia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.uff.sistema_energia.entities.Terceirizada;

public interface TerceirizadaRepository extends JpaRepository<Terceirizada, Long> {
}
