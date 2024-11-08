package br.uff.sistema_energia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.uff.sistema_energia.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}	