package br.uff.sistema_energia.resource.swagger;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.uff.sistema_energia.entities.Equipe;
import io.swagger.v3.oas.annotations.Operation;

public interface EquipeResourceApi {

	@Operation(summary = "Cadastrar uma nova equipe")
	public ResponseEntity<Equipe> cadastrar(Equipe equipe);

	@Operation(summary = "Listar equipes por terceirizada")
	public ResponseEntity<List<Equipe>> listarPorTerceirizada(Long codigo);

	@Operation(summary = "Listar equipes com mínimo de funcionários")
	public ResponseEntity<List<Equipe>> listarPorMinFuncionarios(int minFuncionarios);
}
